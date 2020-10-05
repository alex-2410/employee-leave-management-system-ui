package com.vaadin.ELMS.views.profile;

import com.vaadin.ELMS.views.data.Employee;
import com.vaadin.ELMS.views.data.Employee.Designation;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

@PreserveOnRefresh
@Route(value = "profile", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("Profile | Employee Leave Management System")
public class Profile extends HorizontalLayout {
    
    VerticalLayout leftlayout = new VerticalLayout();
    Dialog dialog = new Dialog();
    public Profile() {

        //dialog.add(new Combo);
        TextField EmployeeID = new TextField();
        TextField FirstName = new TextField();
        TextField LastName = new TextField();
        DatePicker DOB = new DatePicker();
        ComboBox<String> YOJ = new ComboBox<>();
        YOJ.setItems("2020", "2019", "2018", "2017", "2016", "2015");
        NumberField PhoneNumber = new NumberField();
        EmailField Email = new EmailField();
        Employee me = new Employee(1,"511760", "Employee Name", "Last Name",Designation.Faculty,"Electrical and Electronics Engineering", LocalDate.of(1999,10,24), "2017", "7387122337","ritvikasonawane1234@gmail.com");
        EmployeeID.setValue(me.getEmployeeID());
        FirstName.setValue(me.getFirstName());
        LastName.setValue(me.getLastName());
        DOB.setValue(me.getDateOB());
        YOJ.setValue(me.getYOJ());
        PhoneNumber.setValue(Double.valueOf(me.getPhoneNumber()));
        Email.setValue(me.getEmail());
        
        leftlayout.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        EmployeeID.setLabel("EmployeeID");
        EmployeeID.setPlaceholder("EmployeeID");
        EmployeeID.setRequired(true);
        EmployeeID.setRequiredIndicatorVisible(true);
        EmployeeID.setErrorMessage("Please enter an EmployeeID");
        EmployeeID.setReadOnly(true);

        FirstName.setLabel("First Name");
        FirstName.setPlaceholder("First Name");
        FirstName.setRequired(true);
        FirstName.setRequiredIndicatorVisible(true);
        FirstName.setErrorMessage("Please enter your First Name");
        FirstName.setReadOnly(true);

        LastName.setLabel("Last Name");
        LastName.setPlaceholder("Last Name");
        LastName.setRequired(true);
        LastName.setRequiredIndicatorVisible(true);
        LastName.setErrorMessage("Please enter your Last Name");
        LastName.setReadOnly(true);

        DOB.setPlaceholder("Date of Birth");
        DOB.setLabel("Date of Birth");
        DOB.setRequired(true);
        DOB.setRequiredIndicatorVisible(true);
        DOB.setErrorMessage("Please enter your Date of Birth");
        DOB.setReadOnly(true);

        YOJ.setPlaceholder("Year of Joining");
        YOJ.setLabel("Year of Joining");
        YOJ.setRequired(true);
        YOJ.setRequiredIndicatorVisible(true);
        YOJ.setErrorMessage("Please choose a Year of Joining");
        YOJ.setReadOnly(true);

        PhoneNumber.setPlaceholder("Phone Number");
        PhoneNumber.setLabel("Phone Number");
        PhoneNumber.setRequiredIndicatorVisible(true);
        PhoneNumber.setReadOnly(true);

        Email.setPlaceholder("Email Id");
        Email.setLabel("Email Id");
        Email.setRequiredIndicatorVisible(true);
        Email.setErrorMessage("Please enter a valid Email id");
        Email.setReadOnly(true);

        VerticalLayout rightlayout = new VerticalLayout();
        rightlayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        rightlayout.setJustifyContentMode(JustifyContentMode.CENTER);

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFiles(1);
        upload.setMaxFileSize(900);
        upload.setAcceptedFileTypes("image/*");
        upload.addSucceededListener(e -> {
            // Component component =
            // createComponent(e.getMIMEType(),e.getFileName(),buffer.getInputStream());
            // showOutput(e.getFileName(),component,output);
            InputStream inputStream = buffer.getInputStream();
            try {
                inputStream.read();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        upload.addFileRejectedListener(e -> {
            Notification.show("File too big");
        });

        AtomicInteger clickcount =  new AtomicInteger(0);
        Button update = new Button("Edit Profile");
        update.addClickListener(e -> {
            if(clickcount.incrementAndGet()%2 == 1){
                update.setText("Update Profile");
                EmployeeID.setReadOnly(false);
                FirstName.setReadOnly(false);
                LastName.setReadOnly(false);
                DOB.setReadOnly(false);
                YOJ.setReadOnly(false);
                PhoneNumber.setReadOnly(false);
                Email.setReadOnly(false);
            }
            else {
                if(EmployeeID.isInvalid() || FirstName.isInvalid() || LastName.isInvalid()  || DOB.isInvalid() || YOJ.isInvalid() || PhoneNumber.isInvalid() || Email.isInvalid()) {
                    dialog.removeAll();
                    dialog.add("Please enter valid information");
                    dialog.open();
                }
                else {
                    update.setText("Edit Profile");
                    EmployeeID.setReadOnly(true);
                    FirstName.setReadOnly(true);
                    LastName.setReadOnly(true);
                    DOB.setReadOnly(true);
                    YOJ.setReadOnly(true);
                    PhoneNumber.setReadOnly(true);
                    Email.setReadOnly(true);
                }
            }
        });
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        rightlayout.add(new H3("No Profile Picture Uploaded"),upload,update);

        leftlayout.add(new H2("Profile Information"),EmployeeID,FirstName,LastName,DOB,YOJ,PhoneNumber,Email);
        add(leftlayout,rightlayout);
    }
}