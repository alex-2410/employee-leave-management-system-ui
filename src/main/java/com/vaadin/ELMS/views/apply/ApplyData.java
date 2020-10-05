package com.vaadin.ELMS.views.apply;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import com.vaadin.ELMS.views.data.Leave;
import com.vaadin.ELMS.views.data.LeavePendingData;
import com.vaadin.ELMS.views.data.TypeOfLeave;
import com.vaadin.ELMS.views.data.TypeOfLeave.Type;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "applydata", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("Leave Applications | Employee Leave Management System")
public class ApplyData extends VerticalLayout{
    
    Leave leave = new Leave();
    LeavePendingData data = new LeavePendingData();
    TypeOfLeave tol = new TypeOfLeave();
    Grid<Leave> grid = new Grid<>();
	TextField search = new TextField();
    ArrayList<Leave> pendinglist = new ArrayList<>();
    VerticalLayout topleft = new VerticalLayout();
    VerticalLayout topright = new VerticalLayout();
    ApplyForm applyform = new ApplyForm();
    Button apply = new Button("Apply for a Leave");
    Button back = new Button("Back");
    Dialog dialog = new Dialog();
    
    public ApplyData() {

        HorizontalLayout toplayout = new HorizontalLayout();
        toplayout.setSizeFull();
        topleft.setSizeFull();
        topright.add(applyform);
		topright.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		topright.setJustifyContentMode(JustifyContentMode.CENTER);
		topright.setWidth("50%");
        topright.setVisible(false);
        
        setPendingData();

        grid.setItems(pendinglist);
        grid.setSelectionMode(SelectionMode.SINGLE);
		grid.addColumn(Leave::getSrNo,"SrNo").setHeader("Sr No").setFooter("Pending : " + pendinglist.size()).setAutoWidth(true);
		grid.addColumn(Leave::getApplicationDate,"ApplicationDate").setHeader("Application Date").setAutoWidth(true);
		grid.addColumn(Leave::getDaysPrior,"DaysPrior").setHeader("Days Prior").setAutoWidth(true);
		grid.addColumn(Leave::getType,"Type").setHeader("Type").setSortable(false).setAutoWidth(true);
		grid.addColumn(Leave::getFrom,"From").setHeader("From").setAutoWidth(true);
		grid.addColumn(Leave::getTo,"To").setHeader("To").setAutoWidth(true);
		grid.addColumn(Leave::getTotalDays,"TotalDays").setHeader("Total Days").setAutoWidth(true);
        grid.addColumn(Leave::getReason,"Reason").setHeader("Reason").setSortable(false).setAutoWidth(true);
        grid.addItemClickListener(click -> {
            TypeOfLeave tol = new TypeOfLeave(click.getItem().getType());
			topright.setVisible(true);
			applyform.Srno.setText(Integer.toString(click.getItem().getSrNo()));
			applyform.LeaveType.setValue(tol.getTypeLong());
			applyform.From.setValue(click.getItem().From);
			applyform.From.setValue(click.getItem().To);
			applyform.Reason.setValue(click.getItem().getReason());
        });

		search.setPlaceholder("Search by reason");
		search.setClearButtonVisible(true);
		search.setValueChangeMode(ValueChangeMode.EAGER);
        search.addValueChangeListener(e -> updateList());
        
        HorizontalLayout bottomlayout = new HorizontalLayout();
        bottomlayout.setVisible(false);

        VerticalLayout bottomleft = new VerticalLayout(); 
        bottomleft.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        TextArea alertdaysbefore = new TextArea(" ");
        alertdaysbefore.setVisible(false);
        alertdaysbefore.setReadOnly(true);

        Span alertdaysprior = new Span(" ");

        Span alerttotaldays = new Span(" ");

        DatePicker From = new DatePicker();
        DatePicker To = new DatePicker();

        ComboBox<String> LeaveType = new ComboBox<>();
        LeaveType.setItems(tol.getTypeLong(Type.CL),tol.getTypeLong(Type.EL),tol.getTypeLong(Type.HPL),tol.getTypeLong(Type.LND),tol.getTypeLong(Type.ML),tol.getTypeLong(Type.AL),tol.getTypeLong(Type.WRIIL),tol.getTypeLong(Type.ODL),tol.getTypeLong(Type.SCL),tol.getTypeLong(Type.V),tol.getTypeLong(Type.CML),tol.getTypeLong(Type.EOL),tol.getTypeLong(Type.PL),tol.getTypeLong(Type.CCL));
        LeaveType.setPlaceholder("Type of Leave");
        LeaveType.setLabel("Type of Leave");
        LeaveType.setRequired(true);
        LeaveType.setRequiredIndicatorVisible(true);
        LeaveType.setErrorMessage("Please choose a Leave Type");
        LeaveType.addValueChangeListener(e -> {
            alertdaysbefore.setVisible(true);
            if ((LeaveType.isEmpty() == false) && (leave.daysbefore(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))) != 0)) {
                alertdaysbefore.setValue("Leave will be approved by the "+ tol.getAuthority(Type.valueOf(tol.getTypeShort(LeaveType.getValue())))+"\n"+"For this leave, you need to apply "+ Long.toString(leave.daysbefore(Type.valueOf(tol.getTypeShort(LeaveType.getValue())))) + " days earlier");
            }
            else
                alertdaysbefore.setVisible(false);
            From.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))));
            To.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))).plusDays(1));
            alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),From.getValue()).getDays()));
            alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(From.getValue(),To.getValue()).getDays()));
        });

        From.setPlaceholder("From");
        From.setLabel("From");
        From.setRequired(true);
        From.setRequiredIndicatorVisible(true);
        From.setErrorMessage("Please enter a Date");
        From.setValue(LocalDate.now().plusDays(1));
        From.addValueChangeListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))).compareTo(From.getValue()) <= 0) {
                To.setValue(From.getValue().plusDays(1));
                alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),From.getValue()).getDays()));
                alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(From.getValue(),To.getValue()).getDays()));
            }
            else {
                alertdaysprior.setText(" ");
                alerttotaldays.setText(" ");
            }
        });
        From.addFocusListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))).compareTo(From.getValue()) > 0) {
                dialog.removeAll();
				dialog.add("Please enter a valid start date");
				dialog.open();
            }
        });

        To.setPlaceholder("To");
        To.setLabel("To");
        To.setRequired(true);
        To.setRequiredIndicatorVisible(true);
        To.setErrorMessage("Please enter a Date");
        To.setValue(LocalDate.now().plusDays(2));
        To.addValueChangeListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))).plusDays(1).compareTo(To.getValue()) <= 0) && (To.getValue().compareTo(From.getValue()) > 0)) {
                alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(From.getValue(),To.getValue()).getDays()));
            }
            else
                alerttotaldays.setText(" ");
        });
        To.addFocusListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(LeaveType.getValue()))).plusDays(1).compareTo(To.getValue()) > 0) || (To.getValue().compareTo(From.getValue()) <= 0)) {
                dialog.removeAll();
				dialog.add("Please enter a valid end date");
				dialog.open();
            }
        });

        TextArea Reason = new TextArea("Reason");
        Reason.getStyle().set("maxHeight", "100px");
        Reason.setPlaceholder("Write here ...");

        Button submit = new Button("Submit Application");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submit.addClickListener(e -> {
            if(LeaveType.isEmpty() || From.isEmpty() || To.isEmpty() || Reason.isEmpty()) {
                dialog.removeAll();
				dialog.add("Please enter valid information");
				dialog.open();
            }
            else {
                Notification.show("Application Submitted !");
                TypeOfLeave tol = new TypeOfLeave();
                pendinglist.add(new Leave(pendinglist.size() + 1, LocalDate.now(),Type.valueOf(tol.getTypeShort(LeaveType.getValue())),From.getValue(),To.getValue(),Reason.getValue(), false));
                grid.setItems(pendinglist);
                toplayout.setVisible(true);
                bottomlayout.setVisible(false);
                LeaveType.clear();
                alertdaysbefore.setVisible(false);
                From.clear();
                To.clear();
                alertdaysprior.setText("");
                alerttotaldays.setText("");
                Reason.clear();
                grid.getColumns().get(0).setFooter("Total : " + pendinglist.size());
            }
        });

        apply.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        apply.addClickListener(click -> {
            bottomlayout.setVisible(true);
            toplayout.setVisible(false);
        });
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        back.addClickListener(click -> {
            toplayout.setVisible(true);
            bottomlayout.setVisible(false);
            LeaveType.clear();
            alertdaysbefore.setVisible(false);
            From.clear();
            To.clear();
            alertdaysprior.setText("");
            alerttotaldays.setText("");
            Reason.clear();
            
        });
        configureApplyForm();
        topleft.add(new H2("Pending Leave Applications"),search,grid,apply);
        topright.add(applyform);
        toplayout.add(topleft,topright);
        bottomleft.add(new H2("Apply for a Leave"), LeaveType, alertdaysbefore, From, To,alertdaysprior,alerttotaldays, Reason,submit,back);
        bottomlayout.add(bottomleft,new RichTextEditor());
		add(toplayout,bottomlayout);
	}

    private void configureApplyForm() {
        Leave leave = new Leave();

		applyform.Save.addClickListener(click -> {
            if(applyform.LeaveType.isEmpty() || applyform.From.isEmpty() || applyform.To.isEmpty() || applyform.Reason.isEmpty()) {
                dialog.removeAll();
                dialog.add("Please enter valid information");
                dialog.open();
            }
            else {
                TypeOfLeave tol = new TypeOfLeave();
                int i = Integer.valueOf(applyform.Srno.getText()) - 1;
                pendinglist.set(i,new Leave(i + 1,pendinglist.get(i).getDateApplicationDate(),Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue())),applyform.From.getValue(),applyform.To.getValue(),applyform.Reason.getValue(),false));
                grid.setItems(pendinglist);
                topright.setVisible(false);
            }
		});

		applyform.Delete.addClickListener(click -> {
			int i = Integer.valueOf(applyform.Srno.getText()) - 1;
			pendinglist.remove(i);
            grid.setItems(pendinglist);
            for(int j = i; j < pendinglist.size(); j++) {
				pendinglist.get(j).setSrNo(j+1);
			}
            topright.setVisible(false);
            grid.getColumns().get(0).setFooter("Total : " + pendinglist.size());
		});

		applyform.Close.addClickListener(click -> {
			topright.setVisible(false);
		});

		applyform.LeaveType.addValueChangeListener(e -> {
            applyform.alertdaysbefore.setVisible(true);
            if ((applyform.LeaveType.isEmpty() == false) && (leave.daysbefore(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))) != 0)) {
                applyform.alertdaysbefore.setValue("For this leave, you need to apply "+ Long.toString(leave.daysbefore(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue())))) + " days earlier");
            }
            else
				applyform.alertdaysbefore.setVisible(false);
            applyform.From.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))));
            applyform.To.setValue(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))).plusDays(1));
            applyform.alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),applyform.From.getValue()).getDays()));
            applyform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(applyform.From.getValue(),applyform.To.getValue()).getDays()));
		});
		
		applyform.From.addValueChangeListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))).compareTo(applyform.From.getValue()) <= 0) {
                applyform.To.setValue(applyform.From.getValue().plusDays(1));
                applyform.alertdaysprior.setText("Days Prior : " + Integer.toString(Period.between(LocalDate.now(),applyform.From.getValue()).getDays()));
                applyform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(applyform.From.getValue(),applyform.To.getValue()).getDays()));
            }
            else {
                applyform.alertdaysprior.setText(" ");
                applyform.alerttotaldays.setText(" ");
            }
        });
        applyform.From.addFocusListener(e -> {
            if(leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))).compareTo(applyform.From.getValue()) > 0) {
                dialog.removeAll();
				dialog.add("Please enter a valid start date");
				dialog.open();
            }
		});
		
		applyform.To.addValueChangeListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))).plusDays(1).compareTo(applyform.To.getValue()) <= 0) && (applyform.To.getValue().compareTo(applyform.From.getValue()) > 0)) {
                applyform.alerttotaldays.setText("Total Days : " + Integer.toString(Period.between(applyform.From.getValue(),applyform.To.getValue()).getDays()));
            }
            else
				applyform.alerttotaldays.setText(" ");
        });
        applyform.To.addFocusListener(e -> {
            if((leave.getvalidfromdate(Type.valueOf(tol.getTypeShort(applyform.LeaveType.getValue()))).plusDays(1).compareTo(applyform.To.getValue()) > 0) || (applyform.To.getValue().compareTo(applyform.From.getValue()) <= 0)) {
                dialog.removeAll();
				dialog.add("Please enter a valid start date");
				dialog.open();
            }
        });

    }

    private void updateList() {
		if(search.getValue() == null || search.isEmpty())
			setPendingData();
		else {
			ArrayList<Leave> list = new ArrayList<>();
			pendinglist.forEach((leave) -> {
				if(leave.getReason().substring(0,search.getValue().length()).equalsIgnoreCase(search.getValue()))
					list.add(leave);
			});
			pendinglist.retainAll(list);
		}
		grid.setItems(pendinglist);
	}

	public void setPendingData() {
        data.setPendingData();
        pendinglist = data.getPendingData();
    }
}