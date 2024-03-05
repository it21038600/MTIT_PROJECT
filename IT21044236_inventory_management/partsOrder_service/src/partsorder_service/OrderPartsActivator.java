package partsorder_service;

import com.mtit.inventory.Inventory_interface;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OrderPartsActivator implements BundleActivator {
	
	OrderPartsReference orderPartsReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("start order parts ");
		orderPartsReference = context.ServiceReferences(Inventory_interface.class.getName());
		Inventory_interface inventoryinterface =(Inventory_interface)context.getAllServiceReferences(orderPartsReference, null);
		System.out.println(inventoryinterface.inventory());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("good bye");
		context.ungetService(orderPartsReference);
		
	}

}
