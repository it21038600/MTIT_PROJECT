package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProductActivator implements BundleActivator {
	
	ServiceRegistration publicServiceRegistration;



	public void start(BundleContext context) throws Exception {
		
		System.out.println("Producer Start");
		Produce Produces = new ProducesImplement();
		
		publicServiceRegistration = context.registerService(Produce.class.getName(), Produces, null);

	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Producer Stop");
		publicServiceRegistration.unregister();

	}

}
