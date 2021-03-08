package net.technologyrediscovery.week5.mfg;

import java.util.Random;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class QualityControlOnMyOwn {

    private static final int THRESHOLD = 70;
    private static final int MAX_QUALITY = 100;
    private static final int UNITS_TO_CREATE = 1000;
    private static final int MAX_CONSECUTIVE_FAILURES = 8;
    private static final int CONSECUTIVE_FAILURE_THRESHOLD = 3;
    public static void main(String[] args) {
        // random is a lot more efficient using a float value, maybe in the future.
        Random random = new Random();
        int unitsCreated = 0;
        int quality;
        int failed = 0;
        int consecutiveFailures = 0;
        // the status of the machine.
        String status = "Functional.";
        StringBuilder builder;
        // loop units until we reach created or a break point.
        while(unitsCreated < UNITS_TO_CREATE) {
            // random quality level
            quality = random.nextInt(MAX_QUALITY);
            unitsCreated++;
            builder = new StringBuilder();
            // display the quality.
            builder.append("Quality: ").append(quality);
            // check if the quality meets our threshold.
            if(quality < THRESHOLD) {
                builder.append("\nUnit does not meet the quality requirement.");
                // mark failed unit.
                failed++;
                // increase consecutive failures.
                consecutiveFailures++;
                // check if we exceed machine limits.
                if(consecutiveFailures > MAX_CONSECUTIVE_FAILURES) {
                    System.out.println("Ey Phil, the dang machines messed up again.");
                    status = "Maintenance required.";
                    break;
                }
            }
            else {
                builder.append("\nUnit passes the quality check.");
                // reset the failures.
                if(consecutiveFailures > CONSECUTIVE_FAILURE_THRESHOLD)
                    consecutiveFailures = 0;
            }
            System.out.println(builder.toString());
        }
        // produce our floating point ratio (converts to percentage out of 100, not decimal)
        double productionRatio = ((double)failed / (double)unitsCreated) * 100;
        builder = new StringBuilder();
        builder.append("\nUnit report: ")
                .append("\n\tMachine status: ").append(status)
                .append("\n\tCreated units: ").append(unitsCreated)
                .append("\n\tFailed quality control: ").append(failed)
                .append("\n\tFailure ratio: ").append(productionRatio).append("%");
        System.out.println(builder.toString());
    }

}
