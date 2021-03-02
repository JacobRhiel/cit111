/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.technologyrediscovery.cit111.week3;

import java.util.Scanner;

/**
 * Computes and displays distance to a destination with fuel information and 
 * vehicle statistics as a user input.
 * @author jacob
 */
public class GasExcersize {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // conventions state if the object naming is understandable
        // commenting should not be required. OOP**
        int avgMpg;
        double remainingFuel;
        double remainingMiles;
        
        System.out.print("Before we begin, let's get some information.. "
                + "\nPlease enter the average MPG of your vehicle: ");
        avgMpg = (int)numericValue(scanner);
        if(avgMpg == -1) return;
        
        System.out.print("How many gallons of gas remain in your tank? ");
        remainingFuel = numericValue(scanner);
        if(remainingFuel == -1) return;
        
        System.out.print("How many miles remain to the next service station? ");
        remainingMiles = numericValue(scanner);
        if(remainingMiles == -1) return;
        
        double remainingFuelMileage = remainingFuel * avgMpg;
        double projectedFuelDistance = remainingMiles - remainingFuelMileage;
        double requiredFuel = remainingMiles / avgMpg;
        double fuelFactor = (remainingFuel - requiredFuel);
        
        System.out.println(fuelMetrics(avgMpg, remainingMiles, remainingFuelMileage, projectedFuelDistance, fuelFactor));
        
    }
    
    /**
     * Formats a value to the tenth power.
     * @param value The value of a double.
     * @return The value rounded to a tenth power.
     */
    private static double formatDouble(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
    /**
     * Displays the fuel metrics of this application.
     * @param avgMpg The average miles per gallon.
     * @param totalDistance The distance traveling.
     * @param remainingFuelMileage The remaining mileage available for consumption.
     * @param projectedFuelDistance The projected distance available.
     * @param fuelFactor The difference of reserve versus required fuel.
     * @return The metrics to string formatted.
     */
    private static String fuelMetrics(int avgMpg, double totalDistance, double remainingFuelMileage, double projectedFuelDistance, double fuelFactor) {
        StringBuilder builder =  new StringBuilder();
        boolean willMakeIt = fuelFactor > 0.0;
        if(willMakeIt) {
            boolean barely = fuelFactor > 0.0 && fuelFactor < 0.100;
            builder.append("Looks like you're going to make it.")
                    .append(barely ? ".. barely." : "")
                    .append("\n\tYou have ")
                    .append(formatDouble(fuelFactor))
                    .append(" gallons remaining, which is approximately ")
                    .append(formatDouble(remainingFuelMileage))
                    .append(" miles.");
        } else {
            var requiredFuel = totalDistance / avgMpg;
            builder.append("Welp, looks like you're calling a tow truck, you are still ")
                    .append(formatDouble(projectedFuelDistance))
                    .append(" miles away, which is also ")
                    .append(formatDouble(requiredFuel - fuelFactor))
                    .append(" gallons short.");
        }
        return builder.toString();
    }
    
    /**
     * Checks the next scanned value for accuracy and validation.
     * @param scanner The java Scanner object. @see Scanner
     * @return a double numeric value of the entry.
     */
    private static double numericValue(Scanner scanner) {
        double value = -1;
        if(scanner.hasNextDouble())
            value = scanner.nextDouble();
        else if(scanner.hasNextInt())
            value = scanner.nextInt();
        if(value < 0)
            System.out.println("You entered an invalid value, please try again..");
        return value;
    }
}
