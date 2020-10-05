package com.vaadin.ELMS.ui;

import com.vaadin.ELMS.views.dashboard.DashboardView;
import com.vaadin.ELMS.views.data.Employee;
import com.vaadin.ELMS.views.data.Employee.Designation;
import com.vaadin.ELMS.views.data.Employee.enDesignation;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./styles/styles.css")
public class MainLayout extends AppLayout {

    ComboBox<Designation> EmployeeType = new ComboBox<>();
    Employee em = new Employee();
    Dialog dialog = new Dialog();
    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Employee Leave Management System");
        logo.addClassNames("logo");
        Button logout = new Button("Log Out", click -> UI.getCurrent().navigate(com.vaadin.ELMS.views.login.LoginView.class));
        Button toggle = new Button("Switch",click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if(themeList.contains(Lumo.DARK))
                themeList.remove(Lumo.DARK);
            else
                themeList.add(Lumo.DARK);
        });

        EmployeeType.setItems(Designation.values());
        EmployeeType.setPlaceholder("Employee Type");
        EmployeeType.setRequired(true);
        EmployeeType.setErrorMessage("Please choose an Employee Type");
        EmployeeType.addValueChangeListener(click-> EmployeeType.setReadOnly(true));
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(),logo,EmployeeType,toggle,logout);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.expand(logo);
        addToNavbar(header);
    }
    
    private void createDrawer() {
        RouterLink listLink = new RouterLink("Dashboard",DashboardView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(Alignment.START);
        layout.setMaxWidth("100%");

        Icon dashboardicon = new Icon(VaadinIcon.DASHBOARD);
        Button dashboard = new Button("Dashboard",dashboardicon,click -> UI.getCurrent().navigate(DashboardView.class));
        dashboardicon.addClassName("drawer-icons");
        dashboard.addClassName("drawer-buttons");
        dashboard.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Icon profileicon = new Icon(VaadinIcon.EDIT);
        Button profile = new Button("Profile",profileicon,click -> UI.getCurrent().navigate(com.vaadin.ELMS.views.profile.Profile.class));
        profileicon.addClassName("drawer-icons");
        profile.addClassName("drawer-buttons");
        profile.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Icon leavesicon = new Icon(VaadinIcon.RECORDS);
        Button leaves = new Button("History",leavesicon,click -> {
            if(EmployeeType.isEmpty()) {
                dialog.removeAll();
				dialog.add("Please add an Employee Type");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_1)) {
                dialog.removeAll();
				dialog.add("You can't apply for leaves !");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_2) || em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_3)) {
                UI.getCurrent().navigate(com.vaadin.ELMS.views.history.History.class);
            }
        });
        leaves.addClassName("drawer-buttons");
        leavesicon.addClassName("drawer-icons");
        leaves.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Icon applyicon = new Icon(VaadinIcon.PAPERCLIP);
        Button apply = new Button("Apply for a leave",applyicon,click -> {
            if(EmployeeType.isEmpty()) {
                dialog.removeAll();
				dialog.add("Please add an Employee Type");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_1)) {
                dialog.removeAll();
				dialog.add("You can't apply for leaves !");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_2) || em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_3)) {
                UI.getCurrent().navigate(com.vaadin.ELMS.views.apply.ApplyData.class);
            }
        });
        apply.addClassName("drawer-buttons");
        applyicon.addClassName("drawer-icons");
        apply.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Icon stafficon = new Icon(VaadinIcon.MALE);
        Button staff = new Button("Staff Records",stafficon,click -> {
            if(EmployeeType.isEmpty()) {
                dialog.removeAll();
				dialog.add("Please add an Employee Type");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_3)) {
                dialog.removeAll();
				dialog.add("You don't have a staff !");
				dialog.open();
            }
            else if(em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_2) || em.getEndesignation(EmployeeType.getValue()).equals(enDesignation.Classifier_1)) {
                UI.getCurrent().navigate(com.vaadin.ELMS.views.staff.Staff.class);
            }
        });
        staff.addClassName("drawer-buttons");
        stafficon.addClassName("drawer-icons");
        staff.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Icon infoicon = new Icon(VaadinIcon.INFO);
        Button info = new Button("Information",infoicon,click -> UI.getCurrent().navigate(com.vaadin.ELMS.views.info.Info.class));
        info.addClassName("drawer-buttons");
        infoicon.addClassName("drawer-icons");
        info.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        layout.add(dashboard,profile,leaves,apply,staff,info);
        addToDrawer(layout);
    }

}