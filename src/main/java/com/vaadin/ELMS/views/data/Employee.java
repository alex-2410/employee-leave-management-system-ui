package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    public enum enDesignation {
        Classifier_1, Classifier_2, Classifier_3;
    }

    public enum Designation {
        Director, Dean, AssociateDean, Registrar, AssistantRegistrar, DeputyRegistrar, HoD, Faculty, ChiefWarden,
        Warden, OtherNon_Teaching;
    }

    private int SrNo;
    private String EmployeeID;
    private String FirstName;
    private String LastName;
    private Designation designation;
    private enDesignation endesignation;
    private String Branch;
    private LocalDate DOB;
    private String YOJ;
    private String PhoneNumber;
    private String Email;

    public int getSrNo() {
        return SrNo;
    }

    public void setSrNo(int srNo) {
        this.SrNo = srNo;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public enDesignation getEndesignation() {
        return endesignation;
    }

    public void setEndesignation() {
        this.endesignation = getEndesignation(this.designation);
    }

    public enDesignation getEndesignation(Designation designation) {
        switch(designation) {
            case Director:
            case Dean:
            case AssociateDean:
            case Registrar:
                return enDesignation.Classifier_1;
            case AssistantRegistrar:
            case DeputyRegistrar:
            case HoD:
            case ChiefWarden:
                return enDesignation.Classifier_2;
            case Warden:
            case OtherNon_Teaching:
                return enDesignation.Classifier_3;
            default:
               return enDesignation.Classifier_3;
        }
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        this.Branch = branch;
    }

    public String getDOB() {
        return DOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate getDateOB() {
        return this.DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getYOJ() {
        return YOJ;
    }

    public void setYOJ(String YOJ) {
        this.YOJ = YOJ;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Employee(){}

    public Employee(int SrNo,String EmployeeID,String FirstName,String LastName,Designation designation,String branch,LocalDate DOB,String YOJ,String PhoneNumber,String Email){
        this.SrNo = SrNo;
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.designation = designation;
        this.Branch = branch;
        this.DOB = DOB;
        this.YOJ = YOJ;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
    }
}
