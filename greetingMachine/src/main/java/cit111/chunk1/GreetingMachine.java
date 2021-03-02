/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit111.chunk1;

import java.util.Scanner;

/**
 * Simple greeting class displaying an input and response with input arguments.
 * @author jacob
 */
public class GreetingMachine {

    public static void main(String[] args) {
        System.out.println("Please enter your name and press enter");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Whoa, " + name + " What an interesting name card you have!");
    } // close main()
}
// close class GreetingMachine
