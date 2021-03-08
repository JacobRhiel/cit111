package net.technologyrediscovery.week5;

import java.util.Scanner;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class WhileWithScanner {

    public static void main(String[] args) {
        int numLoops = 0;
        int loopControl = 2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many loops shall I print?");
        loopControl = scanner.nextInt();
        while(numLoops <= loopControl) {
            System.out.println("The value of numLoops: " + numLoops);
            numLoops++;
        }
        System.out.println("...After the while loop");
    }
}
