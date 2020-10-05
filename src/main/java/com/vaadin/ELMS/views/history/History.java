package com.vaadin.ELMS.views.history;

import com.vaadin.ELMS.views.data.Leave;
import com.vaadin.ELMS.views.data.LeaveData;
import com.vaadin.ELMS.views.data.TypeOfLeave;
import com.vaadin.ELMS.views.data.TypeOfLeave.Type;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "history", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("History | Employee Leave Management System")
public class History extends HorizontalLayout {

	Grid<Leave> grid = new Grid<>();
	TextField search = new TextField();
	LeaveData data = new LeaveData();
	TypeOfLeave tol = new TypeOfLeave();
	ArrayList<Leave> leavelist = new ArrayList<>();
	VerticalLayout leftlayout = new VerticalLayout();
	VerticalLayout rightlayout = new VerticalLayout();
	LeaveForm leaveform = new LeaveForm();
	Dialog dialog = new Dialog();
	public History() {

		rightlayout.add(leaveform);
		rightlayout.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		rightlayout.setJustifyContentMode(JustifyContentMode.CENTER);
		rightlayout.setWidth("50%");
		rightlayout.setVisible(false);
		//CookieConsent cc = new CookieConsent("We are using cookies to make your visit here awesome!","Cool!","Why?","",Position.BOTTOM);
		

		setLeaveData();
		configureGrid();
		configureFilter();
		configureLeaveForm();
		leftlayout.add(new H2("History"),search,grid);

		add(leftlayout,rightlayout);
	}

	private void configureLeaveForm() {

		Leave leave = new Leave();

		leaveform.Save.addClickListener(click -> {
			TypeOfLeave tol = new TypeOfLeave();
			int i = Integer.valueOf(leaveform.SrNo.getText()) - 1;
			if(leaveform.LeaveType.isEmpty() || leaveform.From.isEmpty() || leaveform.To.isEmpty() || leaveform.Reason.isEmpty()) {
				dialog.removeAll();
                dialog.add("Please enter valid information");
                dialog.open();
			}
			else {
				leavelist.set(i,new Leave(i + 1,leavelist.get(i).getDateApplicationDate(),Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue())),leaveform.From.getValue(),leaveform.To.getValue(),leaveform.Reason.getValue(),leavelist.get(i).ApprovedUnapproved));
				grid.setItems(leavelist);
				rightlayout.setVisible(false);
			}
		});

		leaveform.Delete.addClickListener(click -> {
			int i = Integer.valueOf(leaveform.SrNo.getText()) - 1;
			leavelist.remove(i);
			grid.setItems(leavelist);
			for(int j = i; j < leavelist.size(); j++) {
				leavelist.get(j).setSrNo(j+1);
			}
			rightlayout.setVisible(false);
			grid.getColumns().get(0).setFooter("Total : " + leavelist.size());
		});

		leaveform.Close.addClickListener(click -> {
			rightlayout.setVisible(false);
		});

		leaveform.LeaveType.addValueChangeListener(e -> {
            if ((leaveform.LeaveType.isEmpty() == false) && (leave.daysbefore(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))) != 0)) {
                leaveform.alertdaysbefore.setText("For this leave, you need to apply "+ Long.toString(leave.daysbefore(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue())))) + " days earlier");
            }
            else
				leaveform.alertdaysbefore.setText(" ");
            leaveform.From.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))));
            leaveform.To.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))).plusDays(1));
            leaveform.alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),leaveform.From.getValue()).getDays()));
            leaveform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(leaveform.From.getValue(),leaveform.To.getValue()).getDays()));
		});
		
		leaveform.From.addValueChangeListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))).compareTo(leaveform.From.getValue()) <= 0) {
                leaveform.To.setValue(leaveform.From.getValue().plusDays(1));
                leaveform.alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),leaveform.From.getValue()).getDays()));
                leaveform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(leaveform.From.getValue(),leaveform.To.getValue()).getDays()));
            }
            else {
                leaveform.alertdaysprior.setText(" ");
                leaveform.alerttotaldays.setText(" ");
            }
        });
        leaveform.From.addFocusListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))).compareTo(leaveform.From.getValue()) > 0) {
				dialog.removeAll();
				dialog.add("Please enter a valid start date");
				dialog.open();
			}
		});
		
		leaveform.To.addValueChangeListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))).plusDays(1).compareTo(leaveform.To.getValue()) <= 0) && (leaveform.To.getValue().compareTo(leaveform.From.getValue()) > 0)) {
                leaveform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(leaveform.From.getValue(),leaveform.To.getValue()).getDays()));
            }
            else
				leaveform.alerttotaldays.setText(" ");
        });
        leaveform.To.addFocusListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(leaveform.LeaveType.getValue()))).plusDays(1).compareTo(leaveform.To.getValue()) > 0) || (leaveform.To.getValue().compareTo(leaveform.From.getValue()) <= 0)) {
				dialog.removeAll();
				dialog.add("Please enter a valid end date");
				dialog.open();
			}
        });

	}

	private void configureFilter() {
		search.setPlaceholder("Search by reason");
		search.setClearButtonVisible(true);
		search.setValueChangeMode(ValueChangeMode.EAGER);
		search.addValueChangeListener(e -> updateList());
	}

	private void updateList() {
		
		if(search.getValue() == null || search.isEmpty())
			setLeaveData();
		else{
			ArrayList<Leave> list = new ArrayList<>();
			leavelist.forEach((leave) -> {
				if(leave.getReason().substring(0,search.getValue().length()).equalsIgnoreCase(search.getValue()))
					list.add(leave);
			});
			leavelist.retainAll(list);
		}	
		grid.setItems(leavelist);
	}

	private void configureGrid() {
		grid.setItems(leavelist);
		grid.setSelectionMode(SelectionMode.SINGLE);
		grid.addColumn(Leave::getSrNo,"SrNo").setHeader("Sr No").setFooter("Total : " + leavelist.size()).setAutoWidth(true);
		grid.addColumn(Leave::getApplicationDate,"ApplicationDate").setHeader("Application Date").setAutoWidth(true);
		grid.addColumn(Leave::getDaysPrior,"DaysPrior").setHeader("Days Prior").setAutoWidth(true);
		grid.addColumn(Leave::getType,"Type").setHeader("Type").setSortable(false).setAutoWidth(true);
		grid.addColumn(Leave::getFrom,"From").setHeader("From").setAutoWidth(true);
		grid.addColumn(Leave::getTo,"To").setHeader("To").setAutoWidth(true);
		grid.addColumn(Leave::getTotalDays,"TotalDays").setHeader("Total Days").setAutoWidth(true);
		grid.addColumn(Leave::getReason,"Reason").setHeader("Reason").setSortable(false).setAutoWidth(true);
		grid.addColumn(Leave::isApprovedUnapproved,"ApprovedUnapproved").setHeader("Status").setSortable(false).setAutoWidth(true);

		grid.addItemClickListener(click -> {
			TypeOfLeave tol = new TypeOfLeave(click.getItem().getType());
			rightlayout.setVisible(true);
			leaveform.SrNo.setText(Integer.toString(click.getItem().getSrNo()));
			leaveform.LeaveType.setValue(tol.getTypeLong());
			leaveform.From.setValue(click.getItem().From);
			leaveform.From.setValue(click.getItem().To);
			leaveform.Reason.setValue(click.getItem().getReason());
		});
	}

	private void setLeaveData() {
		data.setLeaveData();
		leavelist = data.getLeaveData();
	}
}