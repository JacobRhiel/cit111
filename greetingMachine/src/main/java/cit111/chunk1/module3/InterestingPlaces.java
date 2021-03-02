/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit111.chunk1.module3;

/**
 *
 * @author jacob
 */
public class InterestingPlaces {
 
    public static void main(String[] args) {
        
        String placeOfInterest = "Cleveland Metroparks";
        
        int firstDistance = 137;
        
        boolean isDriveable = true;
        
        String description = "The Cleveland Metroparks is a funded and maintained park "
                + "with many ammentities and is commonly used as an area for weddings or gatherings.";
        
        String secondPlaceOfInterest = "Siesta Key, Florida";
        
        int secondDistance = 1156;       
        int totalDistance = firstDistance + secondDistance;
        
        System.out.println("First place of interest: " + placeOfInterest 
            + "\nThis location is " + (isDriveable ? "" : "not") + " driveable and the travel distance to " + placeOfInterest + " from Pittsburgh is " + firstDistance + " miles."
            + "\n" + description
            + "\nThe second place of interest is " + secondPlaceOfInterest + "."
            + "\n" + secondPlaceOfInterest + " is " + secondDistance + " miles from Pittsburgh and " + totalDistance + " miles from " + placeOfInterest + "."
        );
        
    }
    
}
