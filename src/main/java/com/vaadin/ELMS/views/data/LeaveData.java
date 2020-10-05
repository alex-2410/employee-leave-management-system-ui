package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.util.ArrayList;

public class LeaveData extends Leave {

	ArrayList<Leave> leavelist = new ArrayList<>();

    public LeaveData() {}

    public void setLeaveData() {
		leavelist.clear();
		leavelist.add(new Leave(1, LocalDate.of(2020,3,2),Type.CL, LocalDate.of(2020,3,5), LocalDate.of(2020,3,8),"Casual", true));
		leavelist.add(new Leave(2, LocalDate.of(2020,2,14),Type.EL, LocalDate.of(2020,3,2), LocalDate.of(2020,3,8),"Health issue", false));
		leavelist.add(new Leave(3, LocalDate.of(2020,1,20),Type.HPL, LocalDate.of(2020,2,05), LocalDate.of(2020,2,06),"Emergency", true));
		leavelist.add(new Leave(4, LocalDate.of(2020,1,27),Type.CL, LocalDate.of(2020,1,29), LocalDate.of(2020,1,30),"Conference", true));
		leavelist.add(new Leave(5, LocalDate.of(2020,1,5),Type.HPL, LocalDate.of(2020,1,20), LocalDate.of(2020,1,25),"Medical reasons", false));
	}
	
	public ArrayList<Leave> getLeaveData() {
		return leavelist;
	}
}