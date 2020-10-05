package com.vaadin.ELMS.views.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TypeOfLeave {
    public enum Type {
        CL,EL,HPL,LND,ML,AL,WRIIL,ODL,SCL,V,CML,EOL,PL,CCL;
    }
    private Type type;
    private int Count;
    private int Days;
    private String Limit = "No limit";
    private Map<Type,String> typeforms = new HashMap<>();

    public Type getType() {
        return type;
    }

    public void setType(Type Type) {
        this.type = Type;
    }

    public String getTypeLong() {
        return typeforms.get(this.type);
    }

    public String getTypeLong(Type Type) {
        configureMap();
        return typeforms.get(Type);
    }

    public int getCount(Type type) {
        LeaveData data = new LeaveData();
        data.setLeaveData();
        ArrayList<Leave> leavelist = data.getLeaveData();
        AtomicInteger count = new AtomicInteger(0);
        leavelist.forEach((leave) -> {
            if(leave.getType().toString().equals(type.toString()))
                count.getAndIncrement();
        });
        return count.intValue();
    }

    public int getCount() {
        return Count;
    }

    public int getDays() {
        return Days;
    }

    public void setDays() {
        LeaveData data = new LeaveData();
        data.setLeaveData();
        ArrayList<Leave> leavelist = data.getLeaveData();
        AtomicInteger days = new AtomicInteger(0);
        leavelist.forEach((leave) -> {
            if(leave.getType().toString().equals(type.toString()))
                days.set(days.addAndGet(leave.getTotalDays()));
        });
        this.Days = days.intValue();
    }

    public String getLimit(Type Type) {
        setLimit(Type);
        return getLimit();
    }

    public String getLimit() {
        return Limit;
    }

    public String getTypeShort(String type) {
        String typeshort = "";
        for(int i = 0;i < type.length();i++) {
            if(type.charAt(i) >= 65 && type.charAt(i) <= 90)
                typeshort += type.charAt(i);
        }
        return typeshort;
    }

    public void setLimit(Type Type) {
        switch (Type) {
            case CL:
                this.Limit = "8";
                break;
            case EL:
                this.Limit = "30";
                break;    
            case HPL:
                this.Limit = "20";
                break;
            case LND:
                this.Limit = "360";
                break;
            case ML:
                this.Limit = "180";
                break;    
            case AL:
                this.Limit = "180";
                break;
            case ODL:
                this.Limit = "15";
                break;
            case SCL:
                this.Limit = "15";
                break;    
            case PL:
                this.Limit = "15";
                break;    
            case CCL:
                this.Limit = "730";
                break;     
            default:
                this.Limit = "No limit";
                break;
        }
    }

    public String getAuthority(Type Type) {
        switch (Type) {
            case CL:
            case SCL:
                return "Dean(FW) or HoD or Head of Dept./ Centre/ Section";
            case V:
            case EL:
            case HPL:
            case CML:
            case ML:  
            case AL:   
            case PL:
                return "Registrar";
            case CCL:
                return "Director/ Registrar";
            case ODL:
            case EOL:
            case LND:
                return "Director";
            default:
                return "";
        }
    }

    public String getPercentage() {
        if(this.Limit != "No limit")
            return String.valueOf((int)((Double.valueOf(this.Days)/Double.parseDouble(this.Limit))*100))+"%";
        else
            return "No limit";
    }

    public TypeOfLeave() {}

    public TypeOfLeave(Type Type) {
        configureMap();
        this.type = Type;
        this.Count = getCount(Type);
        setDays();
        setLimit(Type);
    }

    private void configureMap() {
        typeforms.put(Type.CL,"Casual Leave");
        typeforms.put(Type.EL,"Earned Leave");
        typeforms.put(Type.HPL,"Half Pay Leave");
        typeforms.put(Type.LND,"Leave Not Due");
        typeforms.put(Type.ML,"Maternity Leave");
        typeforms.put(Type.AL,"Adoption Leave");
        typeforms.put(Type.WRIIL,"Work Related Injury or Illness Leave");
        typeforms.put(Type.ODL,"On Duty Leave");
        typeforms.put(Type.SCL,"Special Case Leave");
        typeforms.put(Type.V,"Vacation");
        typeforms.put(Type.CML,"Commuted Leave");
        typeforms.put(Type.EOL,"Extra Ordinary Leave");
        typeforms.put(Type.PL,"Paternity Leave");
        typeforms.put(Type.CCL,"Child Care Leave");
    }

}