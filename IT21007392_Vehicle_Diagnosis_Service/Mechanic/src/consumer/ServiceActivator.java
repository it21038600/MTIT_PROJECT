package consumer;

import com.mtit.service.Produce;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;




	public void start(BundleContext context) throws Exception {
	    System.out.println("Welcome To vehicle Diagnosis");
	    serviceReference = context.getServiceReference(Produce.class.getName());
	    if (serviceReference != null) {
	        Produce produce = (Produce) context.getService(serviceReference);
	        System.out.println(produce.Produces());
	    } else {
	        System.err.println("Failed to retrieve service reference for Produce.");
	    }
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Good Bye");
		context.ungetService(serviceReference);

	}

}
