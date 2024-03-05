package com.mtit.inventory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class inventory_Activator implements BundleActivator {

    ServiceRegistration manageInventoryRegistration;
    
    public void start(BundleContext context) throws Exception {
        System.out.println("start");
        Inventory_interface inventory = new inventory_management();
        manageInventoryRegistration = context.registerService(Inventory_interface.class.getName(), inventory, null);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("stop");
        manageInventoryRegistration.unregister();
    }

}

