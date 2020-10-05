package com.vaadin.ELMS.views.login;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Login | Employee Leave Management System")
public class LoginView extends VerticalLayout{

    Dialog dialog = new Dialog();
    public LoginView(){
        addClassName("login-view");
        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("30%");
        layout.setAlignItems(Alignment.STRETCH);

        EmailField Username = new EmailField();
        Username.setLabel("User Name");
        Username.setRequiredIndicatorVisible(true);
        Username.setErrorMessage("Please enter a valid email address");
        Username.setValue("user@gmail.com");

        PasswordField Password = new PasswordField();
        Password.setLabel("Password");
        Password.setRequired(true);
        Password.setErrorMessage("Can't be empty");
        Password.setValue("password");

        layout.add( new H2("Log in"),Username,Password);

        Button login = new Button("Log in",click -> {
            if(Username.getValue() == "user@gmail.com" && Password.getValue() == "password") {
                UI.getCurrent().navigate(com.vaadin.ELMS.views.dashboard.DashboardView.class);
            }
            else if(Username.isEmpty() == true || Password.isEmpty() == true ) {
                dialog.removeAll();
				dialog.add("Please enter valid information");
				dialog.open();
            }
            else {
                dialog.removeAll();
				dialog.add("Check login credentials");
				dialog.open();
            }
        });

        layout.add(login);
        add(
            new H1("Employee Leave Management System"),
            layout
        );
    }
}