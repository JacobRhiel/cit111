package net.technologyrediscovery.week5;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class NotAsSimpleWhile {

    public static void main(String[] args) {
        int numLoops = 0;
        while(numLoops <= 10) {
            System.out.println("The value of numLoops: " + numLoops);
            numLoops++;
        }
        System.out.println("...After the while loop");
    }

}
