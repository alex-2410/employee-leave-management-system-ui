package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.vaadin.ELMS.views.data.Employee.Designation;
import com.vaadin.ELMS.views.data.TypeOfLeave.Type;

public class Application {

    private int SrNo;
    
	private Type type;
	private LocalDate ApplicationDate;
	public LocalDate From;
	public LocalDate To;
	private String Reason;
    public boolean ApprovedUnapproved;
    
    private String EmployeeID;
    private String FirstName;
    private String LastName;
    private Designation designation;
    private String Branch;
    private LocalDate DOB;
    private String YOJ;
    private String PhoneNumber;
    private String Email;

    public int getSrNo() {
		return this.SrNo;
	}

	public void setSrNo(int SrNo) {
		this.SrNo = SrNo;
    }
    
    // Leave

	public Type getType() {
		return this.type;
	}

	public void setType(Type Type) {
		this.type = Type;
	}

	public String getApplicationDate() {
		return this.ApplicationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public LocalDate getDateApplicationDate() {
		return this.ApplicationDate;
	}

	public void setApplicationDate(LocalDate ApplicationDate) {
		this.ApplicationDate = ApplicationDate;
	}

	public int getDaysPrior() {
		return Period.between(this.ApplicationDate,this.From).getDays();
	}

	public String getFrom() {
		return this.From.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setFrom(LocalDate From) {
		this.From = From;
	}

	public String getTo() {
		return this.To.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setTo(LocalDate To) {
		this.To = To;
	}

	public int getTotalDays() {
		return Period.between(this.From,this.To).getDays();
	}

	public String getReason() {
		return this.Reason;
	}

	public void setReason(String Reason) {
		this.Reason = Reason;
	}

	public String isApprovedUnapproved() {
		return this.ApprovedUnapproved ? "Approved" : "Unapproved";
	}

	public void setApprovedUnapproved(boolean ApprovedUnapproved) {
		this.ApprovedUnapproved = ApprovedUnapproved;
	}

    // Employee

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
    public Application () {}

    public Application (int SrNo,LocalDate ApplicationDate,Type Type,LocalDate From,LocalDate To,String Reason,boolean ApprovedUnapproved,String EmployeeID,String FirstName,String LastName,Designation designation,String branch,LocalDate DOB,String YOJ,String PhoneNumber,String Email) {
        
        this.SrNo = SrNo;
		this.ApplicationDate = ApplicationDate;
		this.type = Type;
		this.From = From;
		this.To = To;
		this.Reason = Reason;
        this.ApprovedUnapproved = ApprovedUnapproved;

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