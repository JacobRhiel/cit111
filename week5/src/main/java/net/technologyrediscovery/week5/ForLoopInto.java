package net.technologyrediscovery.week5;

import java.util.Scanner;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class ForLoopInto {

    public static void main(String[] args) {
        int loopControl;
        Scanner userScanner = new Scanner(System.in);
        System.out.println("How many loops shall I print with for()?");
        loopControl = userScanner.nextInt();

        for(int numLoops = 0; numLoops <= loopControl; numLoops = numLoops++) {
            System.out.println("The value of numLoops: " + numLoops);
        }
    }

}
