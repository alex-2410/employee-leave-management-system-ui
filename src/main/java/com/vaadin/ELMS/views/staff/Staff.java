package com.vaadin.ELMS.views.staff;

import com.vaadin.ELMS.views.data.Employee;
import com.vaadin.ELMS.views.data.EmployeeData;
import com.vaadin.ELMS.views.data.Leave;
import com.vaadin.ELMS.views.data.TypeOfLeave;
import com.vaadin.ELMS.views.data.Application;
import com.vaadin.ELMS.views.data.ApplicationData;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "staff", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("Staff | Employee Leave Management System")
public class Staff extends VerticalLayout{

	TypeOfLeave tol = new TypeOfLeave();
	EmployeeData data_e = new EmployeeData();
	ApplicationData data_a = new ApplicationData();
	Grid<Employee> grid = new Grid<>();
	TextField search = new TextField();
	Grid<Leave> gridemployee = new Grid<>();
	ArrayList<Employee> employeelist;
	Grid<Application> gridapplications = new Grid<>();
	ArrayList<Application> applicationslist;
	HorizontalLayout toplayout = new HorizontalLayout();
	VerticalLayout topleftlayout = new VerticalLayout();
	VerticalLayout toprightlayout = new VerticalLayout();
	VerticalLayout middlelayout = new VerticalLayout();
	HorizontalLayout bottomlayout = new HorizontalLayout();
	VerticalLayout bottomleftlayout = new VerticalLayout();
	VerticalLayout bottomrightlayout = new VerticalLayout();
	StaffForm staffform = new StaffForm();
	ApplicationForm applicationform = new ApplicationForm();
    public Staff(){

		setSizeFull();
		toprightlayout.add(staffform);
		toprightlayout.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		toprightlayout.setJustifyContentMode(JustifyContentMode.CENTER);
		toprightlayout.setWidth("50%");
		toprightlayout.setVisible(false);

		bottomrightlayout.add(new H2(""),applicationform);
		bottomrightlayout.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		bottomrightlayout.setJustifyContentMode(JustifyContentMode.CENTER);
		bottomrightlayout.setWidth("50%");
		bottomrightlayout.setVisible(false);

		setEmployeeData();
		setPendingData();
		configureGrid();
		configureFilter();
		configureBottomLayout();
		configureStaffForm();
		configureApplicationForm();
		topleftlayout.add(new H2("Staff"),search,grid);
		topleftlayout.setSizeFull();
		toplayout.add(topleftlayout,toprightlayout);
		toplayout.setSizeFull();
		Button Back = new Button("Back",click-> {
			toplayout.setVisible(true);
			toprightlayout.setVisible(false);
			middlelayout.setVisible(false);
			bottomlayout.setVisible(true);
		});
		middlelayout.add(new H2("History of the Employee"),gridemployee,Back);
		middlelayout.setSizeFull();
		middlelayout.setVisible(false);
		bottomlayout.setSizeFull();
		bottomlayout.setVisible(true);
		bottomleftlayout.add(new H2("Pending Approvals"),gridapplications);
		bottomleftlayout.setSizeFull();
		bottomlayout.add(bottomleftlayout,bottomrightlayout);
		add(toplayout,middlelayout,bottomlayout);
	}
	
	private void configureBottomLayout() {
		gridapplications.setItems(data_a.getApplicationData());
		gridapplications.setSelectionMode(SelectionMode.SINGLE);
		gridapplications.addColumn(Application::getSrNo,"SrNo").setHeader("Sr No").setFooter("Total : " + data_a.getApplicationData().size()).setAutoWidth(true);
		gridapplications.addColumn(Application::getEmployeeID,"EmployeeID").setHeader("Employee ID").setAutoWidth(true);
		gridapplications.addColumn(Application::getFirstName,"FirstName").setHeader("First Name").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getLastName,"LastName").setHeader("LastName").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getDesignation,"Designation").setHeader("Designation").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getBranch,"Department").setHeader("Branch").setAutoWidth(true);
		gridapplications.addColumn(Application::getApplicationDate,"ApplicationDate").setHeader("Application Date").setAutoWidth(true);
		gridapplications.addColumn(Application::getDaysPrior,"DaysPrior").setHeader("Days Prior").setAutoWidth(true);
		gridapplications.addColumn(Application::getType,"Type").setHeader("Type").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getFrom,"From").setHeader("From").setAutoWidth(true);
		gridapplications.addColumn(Application::getTo,"To").setHeader("To").setAutoWidth(true);
		gridapplications.addColumn(Application::getTotalDays,"TotalDays").setHeader("Total Days").setAutoWidth(true);
		gridapplications.addColumn(Application::getReason,"Reason").setHeader("Reason").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getYOJ,"YOJ").setHeader("Year of Joining").setSortable(false).setAutoWidth(true);
		gridapplications.addColumn(Application::getPhoneNumber,"PhoneNumber").setHeader("Phone Number").setAutoWidth(true);
		gridapplications.addColumn(Application::getEmail,"Email").setHeader("Email Id").setAutoWidth(true);
		gridapplications.addItemClickListener(click -> {
			bottomrightlayout.setVisible(true);
			bottomleftlayout.setVisible(false);
			toprightlayout.setVisible(false);
			applicationform.SrNo.setText(Integer.toString(click.getItem().getSrNo()));
			applicationform.EmployeeID.setValue(click.getItem().getEmployeeID());
			applicationform.FirstName.setValue(click.getItem().getFirstName());
			applicationform.LastName.setValue(click.getItem().getLastName());
			applicationform.Designation.setValue(click.getItem().getDesignation().toString());
			applicationform.LeaveType.setValue(tol.getTypeLong(click.getItem().getType()));
			applicationform.From.setValue(click.getItem().From);
			applicationform.To.setValue(click.getItem().To);
			applicationform.Reason.setValue(click.getItem().getReason());
			applicationform.Branch.setValue(click.getItem().getBranch());
			applicationform.DOB.setValue(click.getItem().getDOB());
			applicationform.YOJ.setValue(click.getItem().getYOJ());
			applicationform.PN.setValue(click.getItem().getPhoneNumber());
			applicationform.Email.setValue(click.getItem().getEmail());
		});
	}

	private void configureMiddleLayout(int i) {
		gridemployee.setItems(data_e.getEmployeeData(i));
		gridemployee.getColumns().get(0).setFooter("Total : " + data_e.getEmployeeData(i).size());
	}

	private void configureStaffForm() {

		staffform.View.addClickListener(click -> {
			configureMiddleLayout(Integer.valueOf(staffform.SrNo.getText()));
			toplayout.setVisible(false);
			middlelayout.setVisible(true);
			bottomlayout.setVisible(false);
		});

		staffform.Close.addClickListener(click -> {
			topleftlayout.setVisible(true);
			toprightlayout.setVisible(false);
			middlelayout.setVisible(false);
			bottomleftlayout.setVisible(true);
			bottomrightlayout.setVisible(false);
		});
	}

	private void configureApplicationForm() {
		applicationform.Close.addClickListener(click -> {
			topleftlayout.setVisible(true);
			toprightlayout.setVisible(false);
			middlelayout.setVisible(false);
			bottomleftlayout.setVisible(true);
			bottomrightlayout.setVisible(false);
		});
		applicationform.Approve.addClickListener(click -> {
			Notification.show("Application Approved !");
			applicationslist.remove(Integer.parseInt(applicationform.SrNo.getText()) - 1);
			gridapplications.setItems(applicationslist);
			for(int i = Integer.parseInt(applicationform.SrNo.getText()) - 1; i < applicationslist.size(); i++) {
				applicationslist.get(i).setSrNo(i+1);
			}
			gridapplications.getColumns().get(0).setFooter("Total : " + applicationslist.size());
			applicationform.Close.click();
		});
		applicationform.Reject.addClickListener(click -> {
			Notification.show("Application Rejected !");
			applicationslist.remove(Integer.parseInt(applicationform.SrNo.getText()) - 1);
			gridapplications.setItems(applicationslist);
			for(int i = Integer.parseInt(applicationform.SrNo.getText()) - 1; i < applicationslist.size(); i++) {
				applicationslist.get(i).setSrNo(i+1);
			}
			gridapplications.getColumns().get(0).setFooter("Total : " + applicationslist.size());
			applicationform.Close.click();
		});
	}

    private void configureFilter() {
		search.setPlaceholder("Search by name");
		search.setClearButtonVisible(true);
		search.setValueChangeMode(ValueChangeMode.EAGER);
		search.addValueChangeListener(e -> updateList());
	}

	private void updateList() {
		
		if(search.getValue() == null || search.isEmpty())
			setEmployeeData();
		else{
			ArrayList<Employee> list = new ArrayList<>();
			employeelist.forEach((employee) -> {
				if((employee.getFirstName().substring(0,search.getValue().length()).equalsIgnoreCase(search.getValue()))||(employee.getLastName().substring(0,search.getValue().length()).equalsIgnoreCase(search.getValue())))
					list.add(employee);
			});
			employeelist.retainAll(list);
		}	
		grid.setItems(employeelist);
	}

	private void configureGrid() {
		grid.setItems(employeelist);
		grid.setSelectionMode(SelectionMode.SINGLE);
		grid.addColumn(Employee::getSrNo,"SrNo").setHeader("Sr No").setFooter("Total : " + employeelist.size()).setAutoWidth(true);
		grid.addColumn(Employee::getEmployeeID,"EmployeeID").setHeader("Employee ID").setAutoWidth(true);
		grid.addColumn(Employee::getFirstName,"FirstName").setHeader("First Name").setSortable(false).setAutoWidth(true);
		grid.addColumn(Employee::getLastName,"LastName").setHeader("LastName").setSortable(false).setAutoWidth(true);
		grid.addColumn(Employee::getDesignation,"Designation").setHeader("Designation").setSortable(false).setAutoWidth(true);
		grid.addColumn(Employee::getBranch,"Branch").setHeader("Branch").setAutoWidth(true);
		grid.addColumn(Employee::getDOB,"DOB").setHeader("Date of Birth").setAutoWidth(true);
		grid.addColumn(Employee::getYOJ,"YOJ").setHeader("Year of Joining").setSortable(false).setAutoWidth(true);
		grid.addColumn(Employee::getPhoneNumber,"PhoneNumber").setHeader("Phone Number").setAutoWidth(true);
		grid.addColumn(Employee::getEmail,"Email").setHeader("Email Id").setAutoWidth(true);
		grid.addItemClickListener(click -> {
			toprightlayout.setVisible(true);
			bottomrightlayout.setVisible(false);
			staffform.SrNo.setText(Integer.toString(click.getItem().getSrNo()));
			staffform.EmployeeID.setValue(click.getItem().getEmployeeID());
			staffform.FirstName.setValue(click.getItem().getFirstName());
			staffform.LastName.setValue(click.getItem().getLastName());
			staffform.Designation.setValue(click.getItem().getDesignation().toString());
			staffform.Branch.setValue(click.getItem().getBranch());
			staffform.DOB.setValue(click.getItem().getDOB());
			staffform.YOJ.setValue(click.getItem().getYOJ());
			staffform.PN.setValue(click.getItem().getPhoneNumber());
			staffform.Email.setValue(click.getItem().getEmail());
		});

		gridemployee.setSelectionMode(SelectionMode.SINGLE);
		gridemployee.addColumn(Leave::getSrNo,"SrNo").setHeader("Sr No").setAutoWidth(true);
		gridemployee.addColumn(Leave::getApplicationDate,"ApplicationDate").setHeader("Application Date").setAutoWidth(true);
		gridemployee.addColumn(Leave::getDaysPrior,"DaysPrior").setHeader("Days Prior").setAutoWidth(true);
		gridemployee.addColumn(Leave::getType,"Type").setHeader("Type").setSortable(false).setAutoWidth(true);
		gridemployee.addColumn(Leave::getFrom,"From").setHeader("From").setAutoWidth(true);
		gridemployee.addColumn(Leave::getTo,"To").setHeader("To").setAutoWidth(true);
		gridemployee.addColumn(Leave::getTotalDays,"TotalDays").setHeader("Total Days").setAutoWidth(true);
		gridemployee.addColumn(Leave::getReason,"Reason").setHeader("Reason").setSortable(false).setAutoWidth(true);
		gridemployee.addColumn(Leave::isApprovedUnapproved,"ApprovedUnapproved").setHeader("Status").setSortable(false).setAutoWidth(true);
	}

	private void setEmployeeData() {
		data_e.setEmployeeData();
		employeelist = data_e.getEmployeeData();
	}

	private void setPendingData() {
		data_a.setApplicationData();
		applicationslist = data_a.getApplicationData();
	}
}