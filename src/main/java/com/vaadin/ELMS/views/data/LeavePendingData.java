package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.util.ArrayList;

public class LeavePendingData extends Leave {

	ArrayList<Leave> pendinglist = new ArrayList<>();

    public LeavePendingData() {}
    
    public void setPendingData() {
		pendinglist.clear();
        pendinglist.add(new Leave(1, LocalDate.of(2020,5,17),Type.HPL, LocalDate.of(2020,6,3), LocalDate.of(2020,6,6),"Health", false));
        pendinglist.add(new Leave(2, LocalDate.of(2020,5,19),Type.CL, LocalDate.of(2020,6,20), LocalDate.of(2020,6,21),"Casual", false));
	}

	public ArrayList<Leave> getPendingData() {
		return pendinglist;
	}

}