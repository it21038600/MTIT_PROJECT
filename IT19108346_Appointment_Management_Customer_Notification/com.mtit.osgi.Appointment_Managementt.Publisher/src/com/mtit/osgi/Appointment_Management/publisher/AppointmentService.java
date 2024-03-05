package com.mtit.osgi.Appointment_Management.publisher;

import java.util.List;

public interface AppointmentService {

List<Appointment> listItems();
	
	public static  int  addItems(float date,float timeDuration, String title) {
		return 0;
	}//Adds the new items to the item list
	
	public   int removeItems(String title);//Removes the items from the list
	
	public static   int searchitems1(String title) {
		// TODO Auto-generated method stub
		return 0;
	}//Searches and item by name
	
	public   List<Appointment> listItems1();//Returns the item list

	static int removeItems1(String title) {
		return 0;
	}
	
}
