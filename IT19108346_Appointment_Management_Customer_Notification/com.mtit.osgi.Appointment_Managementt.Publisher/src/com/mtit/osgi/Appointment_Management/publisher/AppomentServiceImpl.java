package com.mtit.osgi.Appointment_Management.publisher;

import java.util.List;

public class AppomentServiceImpl implements AppointmentService {


	public synchronized int addItems(float date, float timeDuration, String title) {
		Appointment newItem = new Appointment( date, timeDuration, title);
		AppointmentDataStore.itemsList.add(newItem);
		
		return 1;
	}

	@Override
	public synchronized int removeItems(String title) {
		boolean invalid = true;
		int count = -1;
		for (Appointment tempItem :AppointmentDataStore.itemsList) {
			count++;
			if (tempItem.getTitle().equalsIgnoreCase(title)) {
				invalid = false;
				break;
			}
		}
		if (!invalid) {
			AppointmentDataStore.itemsList.remove(count);
			return 1;
		} else {
			return -1;
		}
	}

	public int searchitems(String title) {
		boolean valid = false;
		
		for (Appointment tempItem : AppointmentDataStore.itemsList) {
			if (tempItem.getTitle().equalsIgnoreCase(title)) {
				valid = true;
				break;
			}			
		}
		if(valid) {
			return 1;	
		}
		else {
			return -1;
		}
	}

	@Override
	public List<Appointment> listItems1() {
		return null;
	}

	@Override
	public List<Appointment> listItems() {
		return AppointmentDataStore.itemsList;
	}
	
}
