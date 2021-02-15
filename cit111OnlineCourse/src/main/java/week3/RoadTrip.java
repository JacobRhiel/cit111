/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

/**
 *
 * @author jacob
 */
public class RoadTrip {
    
    public static void main(String[] args) {
        
        final double NEDS_MILES_PER_GALLON = 32.0;
        final double AVERAGE_GAS_PRICE = 2.65;
        
        // declaring and initializing variables
        String carMake = "1996 Mazda Protege";
        String carName = "Nedfry";
        int maxPassengers = 5; // primitive type variable
        int currentNumberOfPassengers = 1;
        boolean carFull = false;
        double tripOdometer = 0.0;
        double cashOnHand = 300.00;
        double distanceToMoabUtah = 1806.0;
        boolean destinationReached = false;
        
        double legDistance; // delcaring this variable but not initalizing
        
        // simulation of the roadtrip
        System.out.println("***Road trip simulator***");
        // print out initial stats
        System.out.println("--> Beginning of trip stats <--");
        System.out.println("Make of car: " + carMake + " that can carry: " + maxPassengers);
        System.out.println("The car's name is " + carName);
        System.out.println(gatherStatistics(0, distanceToMoabUtah, carFull, 
            tripOdometer, cashOnHand, currentNumberOfPassengers, 
            destinationReached));
        System.out.println("********************************************************\n");
        
        System.out.println("Beginning leg 1:");
        
        
        // Calculate leg distance: 25% of total trip, store in legDistance
        double decimalOfOneQuarter = .25;
        legDistance = distanceToMoabUtah * decimalOfOneQuarter;
        System.out.println("CHECK LEG DISTANCE: " + legDistance);
        
        // increment trip odomoeter by leg distance, over-write odometer
        tripOdometer = tripOdometer + legDistance;
        
        // subtract leg distance from distanceTo destination, over-write distance
        distanceToMoabUtah = distanceToMoabUtah - legDistance;
        
        // "see" hitch hiker heading West 
        System.out.println("Oh, look! A person who wants to go west, too!");
        
        // Check if there is room in the car, if so, pick up hitch hiker
        if(carFull == false){
            System.out.println("Car is not full, picking up hitcher");
            currentNumberOfPassengers = currentNumberOfPassengers + 1;
            // alternative shorter version: currentNumberOfPassengers++
        } // closes if()
        
        // calculate price of gas for first leg and store in temp variable
        // gas price = (distance / milesPerGallon) * price per gallon
        double gasPriceForLeg = (legDistance / NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        // deduct $ spent on gas from money remaining and over-write cashOnHand
        cashOnHand = cashOnHand - gasPriceForLeg;
        
        // reprint the variables that I adjusted
        System.out.println(gatherStatistics(1, distanceToMoabUtah, carFull, 
            tripOdometer, cashOnHand, currentNumberOfPassengers, 
            destinationReached));
        
        /* We've made it a quarter of the way. 
        Keep coding after our print lines showing the updated variables after leg 1 by calculating 
        a leg distance of 500 miles. 
        This means we will hard code the value of "500.0" as our leg distance 
        and do calculations with that.*/
        legDistance = 500.00;
        
        // Simulate finding a pair of hitchhikers to pick up and add to the car. 
        // Use our if(){...} controlled block to decide if they can be picked up.
        // Copy text from console on page.
        System.out.println("Oh, Two more WestBound travelers! Check car sta");
        if(carFull == false){
            System.out.println("Car is not full--picking up hitchers");
            currentNumberOfPassengers = currentNumberOfPassengers + 2;
        }
        
        // Calculate our fuel price of our 500 mile leg and update our budget, 
        // assuming we purchased our fuel :)
        gasPriceForLeg = (legDistance / NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        
        cashOnHand = cashOnHand - gasPriceForLeg;
        
        // copy text from console
        System.out.println("Amount spent on gas leg 2: " + gasPriceForLeg);
        
        // Print out all of our stats after leg 2 is complete
        System.out.println(gatherStatistics(2, distanceToMoabUtah, carFull, 
            tripOdometer, cashOnHand, currentNumberOfPassengers, 
            destinationReached));
        
        // Finish the trip with leg 3 that is the remaining distance to MoabUtah. 
        // Use operators to get us there by manipulating the variables as needed.
        legDistance = distanceToMoabUtah - legDistance;
        
        // You see another hitch hiking couple and you stop to see if you can pick them up.
        // You should find that you cannot fit two more folks, 
        // and they decide they don't want to split up, so you pass them by. 
        // Use your if() logic to test this.
        // Copy text from console..
        System.out.println("More hitchers: another pair! Can we fit them?");
        
        int numHitchers = 2;
        
        // See if current + added would exceed maximum.
        if(currentNumberOfPassengers + numHitchers <= maxPassengers){
            System.out.println("Unable to pickup hitchikers.");
            currentNumberOfPassengers = currentNumberOfPassengers + numHitchers;
        } else  {
            // copy text from console
            System.out.println("Too many folks--can't take ya, sorry!");
        }
        
        // Pay for gas through the end of the trip and adjust your cash on hand
        gasPriceForLeg = (legDistance / NEDS_MILES_PER_GALLON) * AVERAGE_GAS_PRICE;
        
        cashOnHand = cashOnHand - gasPriceForLeg;
        
        // copy text from console..
        System.out.println("Cash paid for gas on final leg: " + gasPriceForLeg);
        
        // Arrive at your destination, toggling our boolean variable to represent arriving at that destination
        destinationReached = true;
        
        // Print out final stats! Then go look at some photos online of the "Fiery Furnace" 
        // in Arches national park and celebrate your efforts.
        // copy text from console.
        System.out.println(gatherStatistics(3, distanceToMoabUtah, carFull, 
            tripOdometer, cashOnHand, currentNumberOfPassengers, 
            destinationReached));
        
        
    } 
    
    private static String gatherStatistics(int legNumber, double distanceToMoabUtah, boolean carFull, 
            double tripOdometer, double cashOnHand, int currentNumberOfPassengers, 
            boolean destinationReached) {
        return ((legNumber == 0 ? "" : "\n****Variable stats at end of the leg " + legNumber + "****")
                + "\nDistance To Destination: " + distanceToMoabUtah
                + "\nFull Car? " + carFull + "; Current odometer: " + tripOdometer
                + "\nI have $" + cashOnHand + " to spend on this trip"
                + "\n" + currentNumberOfPassengers + " passengers in car"
                + "\nDestination Reached? " + destinationReached);
    }
    
}