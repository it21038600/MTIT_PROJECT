package com.mtit.osgi.Appointment_Management.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {


	ServiceRegistration serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("=== Customer Notification service started.==");
		AppointmentService AppointmentSer = new AppomentServiceImpl();
		serviceRegisterer = context.registerService(
				AppointmentService.class.getName(), AppointmentSer, null); //registering the AppointmentService
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//Life cycle method-stop
		System.out.println("=== Customer Notification service closed.==");
		serviceRegisterer.unregister();
	}
}