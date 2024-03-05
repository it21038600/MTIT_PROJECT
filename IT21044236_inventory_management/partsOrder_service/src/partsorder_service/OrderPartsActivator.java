package partsorder_service;

import com.mtit.inventory.Inventory_interface;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class OrderPartsActivator implements BundleActivator {
	
	ServiceReference orderPartsReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("start order parts ");
		orderPartsReference = context.getServiceReference(Inventory_interface.class.getName());
		Inventory_interface inventoryinterface =(Inventory_interface)context.getService(orderPartsReference);
		System.out.println(inventoryinterface.inventory());
		
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
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("good bye");
		context.ungetService(orderPartsReference);
		
	}

}
