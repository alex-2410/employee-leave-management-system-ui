package com.vaadin.ELMS.views.dashboard;

import java.util.ArrayList;

import com.vaadin.ELMS.views.data.TypeOfLeave;
import com.vaadin.ELMS.views.data.TypeOfLeave.Type;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = com.vaadin.ELMS.ui.MainLayout.class)
@PageTitle("Dashboard | Employee Leave Management System")
public class DashboardView extends VerticalLayout {

    Grid<TypeOfLeave> grid = new Grid<>();
    ArrayList<TypeOfLeave> alltypes = new ArrayList<>();
    public DashboardView() {
        addClassNames("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
        configureGrid();
        HorizontalLayout defaulthorizontal = new HorizontalLayout();
        defaulthorizontal.setSizeFull();
        defaulthorizontal.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
        defaulthorizontal.setAlignItems(Alignment.STRETCH);
        defaulthorizontal.add(getCharts(), showinfo());
        add(new H2("Dashboard"),defaulthorizontal);
    }

    private Component showinfo() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.add(new H2("Your Leaves : "), grid);
        return layout;
    }

    private void configureGrid() {
        alltypes.add(new TypeOfLeave(Type.CL));
        alltypes.add(new TypeOfLeave(Type.EL));
        alltypes.add(new TypeOfLeave(Type.HPL));
        alltypes.add(new TypeOfLeave(Type.LND));
        alltypes.add(new TypeOfLeave(Type.ML));
        alltypes.add(new TypeOfLeave(Type.AL));
        alltypes.add(new TypeOfLeave(Type.WRIIL));
        alltypes.add(new TypeOfLeave(Type.ODL));
        alltypes.add(new TypeOfLeave(Type.SCL));
        alltypes.add(new TypeOfLeave(Type.V));
        alltypes.add(new TypeOfLeave(Type.CML));
        alltypes.add(new TypeOfLeave(Type.EOL));
        alltypes.add(new TypeOfLeave(Type.PL));
        alltypes.add(new TypeOfLeave(Type.CCL));
        grid.setItems(alltypes);
        grid.setSelectionMode(SelectionMode.SINGLE);
        grid.addColumn(TypeOfLeave::getTypeLong, "Type").setHeader("Leave").setFooter("Total : " + alltypes.size()).setSortable(false).setAutoWidth(false).setResizable(true);
        grid.addColumn(TypeOfLeave::getCount, "Count").setHeader("Number of Leaves").setAutoWidth(true);
        grid.addColumn(TypeOfLeave::getDays, "Days").setHeader("Total Days").setAutoWidth(true);
        grid.addColumn(TypeOfLeave::getLimit, "Limit").setHeader("Upper Limit").setAutoWidth(true);
        grid.addColumn(TypeOfLeave::getPercentage, "Percentage").setHeader("Percentage");
    }

    private Component getCharts() {

        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.setJustifyContentMode(JustifyContentMode.CENTER);
        layout.setAlignItems(Alignment.CENTER);
        layout.setSizeFull();

        Chart piechart = new Chart(ChartType.PIE);
        DataSeries dataseriespie = new DataSeries();
        TypeOfLeave tol = new TypeOfLeave();
        if(tol.getCount(Type.CL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.CL),tol.getCount(Type.CL)));
        if(tol.getCount(Type.EL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.CL),tol.getCount(Type.EL)));
        if(tol.getCount(Type.HPL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.HPL),tol.getCount(Type.HPL)));
        if(tol.getCount(Type.LND) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.LND),tol.getCount(Type.LND)));
        if(tol.getCount(Type.ML) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.ML),tol.getCount(Type.ML)));
        if(tol.getCount(Type.AL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.AL),tol.getCount(Type.AL)));
        if(tol.getCount(Type.WRIIL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.WRIIL),tol.getCount(Type.WRIIL)));
        if(tol.getCount(Type.ODL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.ODL),tol.getCount(Type.ODL)));
        if(tol.getCount(Type.SCL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.SCL),tol.getCount(Type.SCL)));
        if(tol.getCount(Type.V) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.V),tol.getCount(Type.V)));
        if(tol.getCount(Type.CML) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.CML),tol.getCount(Type.CML)));
        if(tol.getCount(Type.EOL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.EOL),tol.getCount(Type.EOL)));
        if(tol.getCount(Type.PL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.PL),tol.getCount(Type.PL)));
        if(tol.getCount(Type.CCL) != 0)
            dataseriespie.add(new DataSeriesItem(tol.getTypeLong(Type.CCL),tol.getCount(Type.CCL)));
        piechart.getConfiguration().setSeries(dataseriespie);
        layout.add(piechart);

        for(int i=0;i<alltypes.size();i++) {
            if(alltypes.get(i).getCount() > 0 && alltypes.get(i).getLimit() != "No limit") {
                ProgressBar progressbar = new ProgressBar();
                progressbar.setValue(Double.valueOf(alltypes.get(i).getDays())/Double.parseDouble(alltypes.get(i).getLimit()));
                layout.add(new Span(alltypes.get(i).getTypeLong()),progressbar);
            }
        }

        return layout;
    }

}