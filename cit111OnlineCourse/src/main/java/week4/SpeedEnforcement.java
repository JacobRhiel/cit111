/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SpeedEnforcement {
    
    public static void main(String[] args) {
        
        // const variables.
        final int MIN_SPEED = 35;
        final int MAX_SPEED = 70;
        
        // dynamic speed.
        int movingSpeed;
               
        System.out.print("Enter speed of vehicle in mph and press enter: ");
        
        // regex Pattern.
        Pattern digitPattern = Pattern.compile("\\d+");
        
        // scanner with sin as input.
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter height in centimeters: ");
       
        // do we meet the regex pattern?
        if(scanner.hasNext(digitPattern))
            movingSpeed = scanner.nextInt();
        else // we do not meet the pattern..
        {
            System.out.println("Invalid input for [" + scanner.next() + "].");
            // return as we do not meet criteria.
            return;
        }
                
        // idle check
        if(movingSpeed == 0)
            System.out.println("Car is idle, where ya going there bud?");
        else if(movingSpeed < 0) // negative speed is impossible in this situation, we aren't measuring velocity.
            System.out.println("Welp, we found a time traveler, or we are doing a physics experiement.");
        else if(movingSpeed < MIN_SPEED) // are we a grandpa?
            System.out.println("Car is moving too slowly");
        else if(movingSpeed > MAX_SPEED) // roadrunner over here..
            System.out.println("Car is traveling over the limit");
        else // all edge cases have been avoided.. for now..
            System.out.println("Car is within appropriate speed range");
    } 
}