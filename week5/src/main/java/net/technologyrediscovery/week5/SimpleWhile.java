package net.technologyrediscovery.week5;

import java.util.Scanner;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class SimpleWhile {

    public static void main(String[] args) {
        int numLoops = 0;
        int loopControl;
        String printable;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many loops shall I print?");
        loopControl = scanner.nextInt();
        System.out.println("What would you like it to print?");
        printable = scanner.nextLine();
        while(numLoops <= loopControl) {
            System.out.println(numLoops + " " + printable);
            numLoops++;
        }
        System.out.println("...After the while loop.");
    }

}
