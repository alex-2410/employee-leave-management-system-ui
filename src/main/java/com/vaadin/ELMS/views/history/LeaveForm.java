package com.vaadin.ELMS.views.history;

import java.time.LocalDate;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class LeaveForm extends FormLayout{

    Span SrNo = new Span();
    ComboBox<String> LeaveType = new ComboBox<>();
    DatePicker From = new DatePicker();
    DatePicker To = new DatePicker();
    TextArea Reason = new TextArea("Reason");
    Span alertdaysbefore = new Span(" ");
    Span alertdaysprior = new Span(" ");
    Span alerttotaldays = new Span(" ");

    Button Save = new Button("Save");
    Button Delete = new Button("Delete");
    Button Close = new Button("Close");
    public LeaveForm() {

        setup();

        HorizontalLayout layout = new HorizontalLayout();
        layout.setPadding(true);
        layout.add(Save,Delete,Close);
        add(LeaveType,alertdaysbefore,From,To,alertdaysprior,alerttotaldays,Reason,layout);
    }

    private void setup() {

        LeaveType.setItems("Casual Leave", "Earned Leave", "Half Pay Leave", "Leave Not Due", "Maternity Leave","Adoption Leave", "Work Related Injury or Illness Leave", "On Duty Leave", "Special Case Leave","Vacation", "Commuted Leave", "Extra Ordinary Leave", "Paternity Leave", "Child Care Leave");
        LeaveType.setPlaceholder("Type of Leave");
        LeaveType.setLabel("Type of Leave");
        LeaveType.setRequired(true);
        LeaveType.setRequiredIndicatorVisible(true);
        LeaveType.setErrorMessage("Please choose a Leave Type");

        From.setPlaceholder("From");
        From.setLabel("From");
        From.setRequired(true);
        From.setRequiredIndicatorVisible(true);
        From.setErrorMessage("Please enter a Date");
        From.setValue(LocalDate.now().plusDays(1));

        To.setPlaceholder("To");
        To.setLabel("To");
        To.setRequired(true);
        To.setRequiredIndicatorVisible(true);
        To.setErrorMessage("Please enter a Date");
        To.setValue(LocalDate.now().plusDays(2));

        Reason.getStyle().set("maxHeight", "100px");
        Reason.setPlaceholder("Write here ...");
        

        Save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        Close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Save.addClickShortcut(Key.ENTER);
        Close.addClickShortcut(Key.ESCAPE);
        
    }
}