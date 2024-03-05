package com.mtit.osgi.Appointment_Management.publisher;

import java.util.List;

public class Appointment {

	private float date;
	private float timeDuration;
	private String title;
	private float totalvalue;
	
	
	public Appointment(float date, float timeDuration,String title) {
		super();
		this.date=date;
		this.timeDuration= timeDuration;
		this.title = title;
		caltotalValue();	
	}
	
	public float getDate() {
		return date;
	}
	public void setDate(float date) {
		this.date = date;
	}
	public float timeDuration() {
		return timeDuration;
	}
	public void timeDuration(float timeDuration) {
		this.timeDuration = timeDuration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(float totalvalue) {
		this.totalvalue = totalvalue;
	}
	private void caltotalValue() {
		this.totalvalue = this.timeDuration*this.date;
	}

	public static List<Appointment> listItems1() {
		return null;
	}

	
}

