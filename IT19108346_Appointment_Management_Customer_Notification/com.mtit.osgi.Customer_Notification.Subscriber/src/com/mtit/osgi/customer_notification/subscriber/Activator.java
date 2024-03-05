package com.mtit.osgi.customer_notification.subscriber;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.osgi.Appointment_Management.publisher.Appointment;
import com.mtit.osgi.Appointment_Management.publisher.AppointmentService;

public class Activator implements BundleActivator {

	
	ServiceReference Appointment_Service;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		
		System.out.println("==== Appointment Service started! ==");
		
		Appointment_Service = context.getServiceReference(AppointmentService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		AppointmentService  managerService = (AppointmentService) context.getService(Appointment_Service);//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println("--- Welcome to Car Service Senter --");
	
		System.out.println("Please Select an option to continue.....");
		System.out.println("Options");
		System.out.println("1.Add new Appointment ");
		System.out.println("2.Remove Appointment");
		System.out.println("3.List Of Current Appointment");
		System.out.println("4.Search  available Appointment by TiTle");
		System.out.println("5.Exit to Appointment Interface");
		
		System.out.println("Enter your selection...");
		 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please enter a valid selection");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding process of new items to the list
			do {
			System.out.println("Enter the Date..");
			int date = input.nextInt();

			System.out.println("Enter the time duration..");
			int timeDuration = input.nextInt();

			System.out.println("Enter The Title Of the Appointment..");
			String title = input.nextLine();
			title=input.nextLine();
			
			int result = AppointmentService.addItems(date, timeDuration, title);//Consumes the AppointmentService addItems()
			 String msg = (result == 1) ? "Successfully added the Appointment!" :"please enter a valid title";
			   System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the Title name need to remove..:");

			String title = input.nextLine();
			int result = AppointmentService.removeItems1(title);//Consumes the AppointmentService removeItems()
			   String msg = (result ==1) ? "Successfully Removed the  Appointment!" :"please enter a valid title";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Appointment> itemsList = Appointment.listItems1();//Consumes the AppointmentService listItems()
				System.out.println("-----------------------------------Phone Stock list--------------------------------------------");
				System.out.println("Quantity:"+"\t" +"Price:"+"\t"+"\t" +"ctgry:"+"\t"+"\t" +"Total Value:"+"\t" );
				
			for(Appointment tempItem: itemsList ) {
				System.out.println(tempItem.getDate()+"\t         "+tempItem.timeDuration()+"\t         "+tempItem.getTitle()+"\t		\n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the Appointment name to search");
			

			String ctgry = input.nextLine();
			int result =AppointmentService.searchitems1(ctgry);//Consumes the AppointmentService searchItems()
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the Manager consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("=== AppointmentService stopped.==");
		context.ungetService(Appointment_Service);
	}

}
