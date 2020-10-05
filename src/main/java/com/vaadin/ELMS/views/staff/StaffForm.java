package com.vaadin.ELMS.views.staff;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class StaffForm extends FormLayout{

    Span SrNo = new Span();
    TextField EmployeeID = new TextField();
    TextField FirstName = new TextField();
    TextField LastName = new TextField();
    TextField Designation = new TextField();
    TextField Course = new TextField();
    TextField Branch = new TextField();
    TextField DOB = new TextField();
    TextField YOJ = new TextField();
    TextField PN = new TextField();
    TextField Email = new TextField();

    Button View = new Button("View Leave Record");
    Button Close = new Button("Close");
    public StaffForm() {

        EmployeeID.setReadOnly(true);
        FirstName.setReadOnly(true);
        LastName.setReadOnly(true);
        Designation.setReadOnly(true);
        Course.setReadOnly(true);
        Branch.setReadOnly(true);
        DOB.setReadOnly(true);
        YOJ.setReadOnly(true);
        PN.setReadOnly(true);
        Email.setReadOnly(true);
        HorizontalLayout layout = new HorizontalLayout();
        View.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Close.addThemeVariants(ButtonVariant.LUMO_ERROR);
        View.addClickShortcut(Key.ENTER);
        Close.addClickShortcut(Key.ESCAPE);
        layout.add(View,Close);

        add(new H2("Employee Details"),new Span(""),EmployeeID,FirstName,LastName,Designation,Branch,DOB,YOJ,PN,Email,layout);
    }
}