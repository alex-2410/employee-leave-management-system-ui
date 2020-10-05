package com.vaadin.ELMS.views.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Leave extends TypeOfLeave{

	private int SrNo;
	private Type type;
	private LocalDate ApplicationDate;
	public LocalDate From;
	public LocalDate To;
	private String Reason;
	public boolean ApprovedUnapproved;

	public int getSrNo() {
		return this.SrNo;
	}

	public void setSrNo(int SrNo) {
		this.SrNo = SrNo;
	}

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

	public Leave(){}

	public Leave(int SrNo,LocalDate ApplicationDate,Type Type,LocalDate From,LocalDate To,String Reason,boolean ApprovedUnapproved) {
		this.SrNo = SrNo;
		this.ApplicationDate = ApplicationDate;
		this.type = Type;
		this.From = From;
		this.To = To;
		this.Reason = Reason;
		this.ApprovedUnapproved = ApprovedUnapproved;
	}

	public LocalDate getvalidfromdate(Type type) {
        if(daysbefore(type) != 0)
            return LocalDate.now().plusDays(daysbefore(type));
        return LocalDate.now().plusDays(1);
    }

    public long daysbefore(Type type) {
        switch (type) {
            case V:
            case EL:
            case HPL:
            case CML:
            case ML:  
            case AL:   
            case PL:
            case CCL:
            case LND:
            case ODL:
            case EOL:
                return 15;
            default:
                return 0;
        }
    }
}