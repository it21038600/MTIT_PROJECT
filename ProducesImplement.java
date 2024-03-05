package com.mtit.service;

import java.util.Scanner;

public class ProducesImplement implements Produce {

    @Override
    public String Produces() {
        Scanner scanner = new Scanner(System.in);
        String service;

        while (true) {
            System.out.println("Select a service:");
            System.out.println("A = Make Appointment");
            System.out.println("D = Vehicle Diagnosis");
            System.out.println("I = Inventory Management");
            System.out.println("S = Service Update");
            System.out.print("Enter your choice: ");

            service = scanner.nextLine().toUpperCase();

            if (service.equals("A") || service.equals("I") || service.equals("S")) {
                break;
            } else if (service.equals("D")) {
                System.out.print("Enter vehicle brand name: ");
                String brand = scanner.nextLine();
                
                System.out.print("Enter vehicle model name: ");
                String model = scanner.nextLine();
                
                System.out.print("Enter fuel type: ");
                String fuelType = scanner.nextLine();
                
                System.out.print("Enter mileage: ");
                int mileage = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                System.out.print("Enter tyre condition: ");
                String tyreCondition = scanner.nextLine();
                
                System.out.print("Enter Engine Condition: ");
                int engPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character 
                
                System.out.print("Enter oil level percentage: ");
                int oilPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                System.out.print("Enter battery level percentage: ");
                int batteryPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                
                System.out.print("Enter Electrical system level percentage: ");
                int ElectricPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                System.out.print("Enter Emission system level percentage: ");
                int EmissionPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character
                
                
                // Displaying the report
                System.out.println("\nService Status Update Service:");
                System.out.println("Vehicle Brand: " + brand);
                System.out.println("Vehicle Model: " + model);
                System.out.println("Fuel Type: " + fuelType);
                System.out.println("Mileage: " + mileage);
                System.out.println("Tyre Condition: " + tyreCondition);
                System.out.println("Engine Condition: " + engPercentage);
                System.out.println("Oil level percentage: " + oilPercentage);
                System.out.println("battery level percentage: " + batteryPercentage);
                System.out.println("battery level percentage: " + ElectricPercentage);
                System.out.println("battery level percentage: " + EmissionPercentage);
                
                
                
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        return "Thank You! ";
    }
}
