package net.technologyrediscovery.week5.math;

import java.util.*;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 08, 2021
 */
public class MathematicalAnalysis {

    // our problems array list.
    private static final List<IMathProblem> PROBLEMS = new ArrayList<>();

    // ascii character color coding.
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String YELLOW_BOLD = "\033[1;33m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String RESET = "\033[0m";

    static {
        // add an enum set of our Enumeration to a list. You have to love Collections!
        PROBLEMS.addAll(EnumSet.allOf(MathEquations.class));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Java offers string literals, use them!
        System.out.println("""
                Welcome to MathChecker, where we check your math!
                The rules are simple, answer the following questions in order, they will become harder as you proceed.
                Hint: All answers should be in numeric format.""");

        StringBuilder builder;

        // exclusive index, this is the problem number or loop index, 'exclusive' of 0.
        int index = 1;
        int attempts = 0;
        // let's randomize our problems.
        Collections.shuffle(PROBLEMS);
        // loop all of the possible problems.
        for (IMathProblem problem : PROBLEMS) {
            builder = new StringBuilder();
            builder.append(GREEN_BOLD).append("Question #").append(index).append(": ")
                    .append(YELLOW_BOLD).append(problem.problem()).append(":").append(RESET);
            System.out.print(builder.toString());
            int answer = scanner.nextInt();
            // check the solution each loop.
            while(!checkSolution(problem, answer, attempts)) {
                // increase attempts since of course the first is counted.
                attempts++;
                // in this case attempts is 'exclusive' of 0.
                // break out of the while loop since we used all attempts.
                if(attempts == 3)
                    break;
                // reprint if the solution is invalid.
                System.out.println(builder.toString());
                // next answer.
                answer = scanner.nextInt();
            }
            // in this case attempts is 'exclusive' of 0.
            // break out of the for loop since we used all attempts.
            if(attempts == 3)
                break;
            // reset attempts.
            attempts = 0;
        }

    }

    /**
     * Checks the solution for correctness and displays the steps after 3 consecutive failed attempts.
     * @param problem The problem we are checking the solution for.
     * @param answer The answer given via prompt.
     * @param attempt The attempt number.
     * @return Whether the solution given is correct.
     */
    private static boolean checkSolution(IMathProblem problem, int answer, int attempt) {
        int solution = problem.solution();
        if(solution == answer)
        {
            System.out.println("That is the " + GREEN_BOLD + "correct" + RESET + " answer! Next Question.");
            return true;
        }
        else {
            System.out.println("Your answer is too " + RED_BOLD + ((solution > answer) ? "low" : "high") + RESET + ", please try again.");
            // in this case attempt is 'inclusive' of 0.
            if(attempt == 2) {
                System.out.println("\nThis is the third attempt at the above solution, here is how it was calculated." +
                        "\n" + problem.displaySteps());
            }
            return false;
        }
    }

}
