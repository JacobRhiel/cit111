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
public class Comparisons {
    
    public static void main(String[] args) {
        
        // create an initialize two int-type variables
        int correctPasscode = 5934;
        int attemptedPasscode = 1234;
        
        // compare correctPasscode to attemptedPasscode
        if(attemptedPasscode == correctPasscode){
            System.out.println("Codes Match! You're in!");
        } else {
            System.out.println("Codes don't match -- no soup for you!");
        } // close if/else blocks
    } // close main method
} // close class Comparisons