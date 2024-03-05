package com.mtit.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProducesImplement implements Produce {

    private Map<String, String> appointments;
    private String referenceNumber;

    public ProducesImplement() {
        this.appointments = new HashMap<>();
    }

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
            System.out.println("U = Update Appointment");
            System.out.println("R = Delete Appointment");
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

                System.out.print("Enter OBD tool report percentage: ");
                int obdPercentage = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                System.out.print("Enter reference number: ");
                referenceNumber = scanner.nextLine();

                // Displaying the report
                System.out.println("\nVehicle Diagnosis Report:");
                System.out.println("Vehicle Brand: " + brand);
                System.out.println("Vehicle Model: " + model);
                System.out.println("Fuel Type: " + fuelType);
                System.out.println("Mileage: " + mileage);
                System.out.println("Tyre Condition: " + tyreCondition);
                System.out.println("OBD Tool Report Percentage: " + obdPercentage);
                System.out.println("Reference Number: " + referenceNumber);

                break;
            } else if (service.equals("U")) {
                updateAppointment();
                break;
            } else if (service.equals("R")) {
                deleteAppointment();
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        return "Thank You! ";
    }

    private void updateAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter existing appointment details to update:");
        System.out.print("Enter vehicle brand name: ");
        String brand = scanner.nextLine();

        // Check if the appointment exists
        if (appointments.containsKey(brand)) {
            System.out.print("Enter updated vehicle model name: ");
            String updatedModel = scanner.nextLine();
            appointments.put(brand, updatedModel);
            System.out.println("Appointment updated successfully!");
        } else {
            System.out.println("Appointment not found!");
        }
    }

    private void deleteAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle brand name to delete appointment:");
        String brand = scanner.nextLine();

        // Check if the appointment exists
        if (appointments.containsKey(brand)) {
            appointments.remove(brand);
            System.out.println("Appointment deleted successfully!");
        } else {
            System.out.println("Appointment not found!");
        }
    }
}

