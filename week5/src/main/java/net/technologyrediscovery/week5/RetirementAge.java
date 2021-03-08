package net.technologyrediscovery.week5;

import java.util.Scanner;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class RetirementAge {

    public static void main(String[] args) {
        int age;
        Scanner inputScanner = new Scanner(System.in);

        while(true) {
            System.out.print("Enter your age to see if you can retire: ");
            age = inputScanner.nextInt();
            if(age > 65.5) {
                System.out.println("Wahoo! Grab the newspaper and martini!");
            } else if(age > 0) {
                System.out.println("Sorry, Keep working...");
            } else {
                System.out.println("Thanks for checking your retirement status.");
                break;
            }
        }
    }

}
