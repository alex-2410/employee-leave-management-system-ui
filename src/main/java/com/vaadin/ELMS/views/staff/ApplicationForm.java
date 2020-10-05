package com.vaadin.ELMS.views.staff;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class ApplicationForm extends FormLayout{
    
    Span SrNo = new Span();
    TextField EmployeeID = new TextField();
    TextField FirstName = new TextField();
    TextField LastName = new TextField();
    TextField Designation = new TextField();

    ComboBox<String> LeaveType = new ComboBox<>();
    DatePicker From = new DatePicker();
    DatePicker To = new DatePicker();
    TextArea Reason = new TextArea("Reason");
    
    TextField Course = new TextField();
    TextField Branch = new TextField();
    TextField DOB = new TextField();
    TextField YOJ = new TextField();
    TextField PN = new TextField();
    TextField Email = new TextField();

    Button Approve = new Button("Approve");
    Button Reject = new Button("Reject");
    Button Close = new Button("Close");
    public ApplicationForm() {

        EmployeeID.setReadOnly(true);
        EmployeeID.setLabel("EmployeeID");
        FirstName.setReadOnly(true);
        FirstName.setLabel("First Name");
        LastName.setReadOnly(true);
        LastName.setLabel("Last Name");
        Designation.setReadOnly(true);
        Designation.setLabel("Designation");
        LeaveType.setReadOnly(true);
        LeaveType.setLabel("Type Of Leave");
        From.setReadOnly(true);
        From.setLabel("From");
        To.setReadOnly(true);
        To.setLabel("To");
        Reason.setReadOnly(true);
        Course.setReadOnly(true);
        Course.setLabel("Course");
        Branch.setReadOnly(true);
        Branch.setLabel("Branch");
        DOB.setReadOnly(true);
        DOB.setLabel("Date of Birth");
        YOJ.setReadOnly(true);
        YOJ.setLabel("Year of Joining");
        PN.setReadOnly(true);
        PN.setLabel("Phone Number");
        Email.setReadOnly(true);
        Email.setLabel("Email Id");

        HorizontalLayout layout = new HorizontalLayout();
        layout.setPadding(true);
        Approve.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        Reject.addThemeVariants(ButtonVariant.LUMO_ERROR);
        Close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        Approve.addClickShortcut(Key.ENTER);
        Reject.addClickShortcut(Key.DELETE);
        Close.addClickShortcut(Key.ESCAPE);
        layout.add(Approve,Reject,Close);

        add(new H1(" "),new H1(" "),new H1(" "),new H1(" "),new H1(" "),new H1(" "),new H1(""),new H2("Application Details"),new Span(""),EmployeeID,FirstName,LastName,Designation,LeaveType,From,To,Reason,Branch,DOB,YOJ,PN,Email,layout);
    }
}