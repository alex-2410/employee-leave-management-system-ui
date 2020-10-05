package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.util.ArrayList;

import com.vaadin.ELMS.views.data.TypeOfLeave.Type;

public class EmployeeData extends Employee {

    ArrayList<Employee> employeelist = new ArrayList<>();

    public EmployeeData(){}

    public void setEmployeeData() {
		employeelist.clear();
    employeelist.add(new Employee(1,"511761","Employee1","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
    employeelist.add(new Employee(2,"511762","Employee2","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
    employeelist.add(new Employee(3,"511763","Employee3","LastName",Designation.OtherNon_Teaching,"Laboratory",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
    employeelist.add(new Employee(4,"511764","Employee4","LastName",Designation.OtherNon_Teaching,"Non-Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
    employeelist.add(new Employee(5,"511765","Employee5","LastName",Designation.Faculty,"Teaching",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
    employeelist.add(new Employee(6,"511766","Employee6","LastName",Designation.OtherNon_Teaching,"PhD student",LocalDate.of(1999,10,24),"2017","8074637759","ritvikasonawane1234@gmail.com"));
	}
	
	public ArrayList<Employee> getEmployeeData() {
		return employeelist;
  }

  public ArrayList<Leave> getEmployeeData(int index) {
		ArrayList<Leave> leavelist = new ArrayList<>();
		leavelist.clear();
		leavelist.add(new Leave(1, LocalDate.of(2020,3,2),Type.CL, LocalDate.of(2020,3,5), LocalDate.of(2020,3,8),"Employee", true));
		leavelist.add(new Leave(2, LocalDate.of(2020,2,14),Type.EL, LocalDate.of(2020,3,2), LocalDate.of(2020,3,8),"Employee", false));
		leavelist.add(new Leave(3, LocalDate.of(2020,1,20),Type.HPL, LocalDate.of(2020,2,05), LocalDate.of(2020,2,06),"Employee", true));
		leavelist.add(new Leave(4, LocalDate.of(2020,1,27),Type.CL, LocalDate.of(2020,1,29), LocalDate.of(2020,1,30),"Employee", true));
    leavelist.add(new Leave(5, LocalDate.of(2020,1,5),Type.HPL, LocalDate.of(2020,1,20), LocalDate.of(2020,1,25),"Employee", false));
    return leavelist;
	}
}