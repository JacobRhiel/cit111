/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.technologyrediscovery.cit111.week3;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Determines if a rider's height is valid to ride a potential ride.
 * @author jacob
 */
public class RideHeight {
    
    public static void main(String[] args) {
        
        // const height
        final int MIN_HEIGHT_CM = 80;
        
        // dynamic height
        int riderHeight;
        
        // regex Pattern.
        Pattern digitPattern = Pattern.compile("\\d+");
        
        // scanner with sin as input.
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter height in centimeters: ");
       
        // do we meet the regex pattern?
        if(scanner.hasNext(digitPattern))
            riderHeight = scanner.nextInt();
        else // we do not meet the pattern..
        {
            System.out.println("Invalid input for [" + scanner.next() + "].");
            // return as we do not meet criteria.
            return;
        }
               
        // is the rider able to ride.
        if(riderHeight < MIN_HEIGHT_CM)
            System.out.println("Sorry, you are too short to ride.");
        else
            System.out.println("Your height of " + riderHeight + "cm means you can ride!");     
    } 
}