package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.util.ArrayList;

import com.vaadin.ELMS.views.data.Employee.Designation;
import com.vaadin.ELMS.views.data.TypeOfLeave.Type;

public class ApplicationData extends Application {

    ArrayList<Application> applicationslist = new ArrayList<>();

    public void setApplicationData() {
		applicationslist.clear();
		applicationslist.add(new Application(1, LocalDate.of(2020,3,2),Type.CL, LocalDate.of(2020,3,5), LocalDate.of(2020,3,8),"Casual", false,"511761","Employee1","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
		applicationslist.add(new Application(2, LocalDate.of(2020,2,14),Type.EL, LocalDate.of(2020,3,2), LocalDate.of(2020,3,8),"Health issue", false,"511762","Employee2","LastName",Designation.OtherNon_Teaching,"Non-Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
		applicationslist.add(new Application(3, LocalDate.of(2020,1,20),Type.HPL, LocalDate.of(2020,2,05), LocalDate.of(2020,2,06),"Reason 1", false,"511763","Employee3","LastName",Designation.OtherNon_Teaching,"Non-Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
		applicationslist.add(new Application(4, LocalDate.of(2020,1,27),Type.CL, LocalDate.of(2020,1,29), LocalDate.of(2020,1,30),"Reason 2",false,"511764","Employee4","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
        applicationslist.add(new Application(5, LocalDate.of(2020,1,5),Type.HPL, LocalDate.of(2020,1,20), LocalDate.of(2020,1,25),"Reason 3", false,"511765","Employee5","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
        applicationslist.add(new Application(6, LocalDate.of(2020,1,5),Type.HPL, LocalDate.of(2020,1,20), LocalDate.of(2020,1,25),"Reason 4", false,"511766","Employee6","LastName",Designation.OtherNon_Teaching,"Non-Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
	}
	
	public ArrayList<Application> getApplicationData() {
		return applicationslist;
	}
}