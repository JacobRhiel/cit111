package net.technologyrediscovery.week5.authentication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jacob Rhiel <jacob.rhiel@gmail.com>
 * @created Mar 06, 2021
 */
public class Authentication {

    // matching keyphrase
    private static final String PASSWORD_TO_MATCH = "cit111";
    // oauth simulation code
    private static final int OAUTH_CODE = 12345;
    // maximum password attempts.
    private static final int PASSWORD_ATTEMPTS = 3;
    // password attempts for storage
    private static final List passwordAttempts = new ArrayList<String>(3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // while password attempts do not exceed.
        while (passwordAttempts.size() < 3) {
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();
            // check if password is correct.
            boolean correctPassword = attemptPassword(password);
            if (correctPassword) {
                System.out.print("Please enter your 2fa code (int format): ");
                int code = scanner.nextInt();
                // check 2fa input.
                boolean matches = check2fa(code);
                if (matches) {
                    System.out.println("Password is correct. You win a whole lot of nothing!");
                } else {
                    System.out.println("Invalid 2fa, your session has been rejected.");
                }
                break;
            }
        }
    }

    /**
     * Checks if the password attempts is exceeded.
     * @return True or False.
     */
    private static boolean exceedsAttempts() {
        return passwordAttempts.size() == 3;
    }

    /**
     * Checks the 2fa input code.
     * @param code The code for 2fa.
     * @return Whether the code matches.
     */
    private static boolean check2fa(int code) {
        return code == OAUTH_CODE;
    }

    /**
     * Attempts to verify password input.
     * @param password The user-input password.
     * @return Whether it is correct.
     */
    private static boolean attemptPassword(String password) {
        passwordAttempts.add(password);
        if (exceedsAttempts()) {
            System.out.println("You have exceeded the maximum number of password attempts.");
            System.out.println("The following passwords have been attempted: " + Arrays.toString(passwordAttempts.toArray()));
            return false;
        }
        if (password.equals(PASSWORD_TO_MATCH)) {
            return true;
        } else {
            System.out.println(
                    "Invalid password, please try again." +
                            "\nAttempts remaining: " + (PASSWORD_ATTEMPTS - passwordAttempts.size())
                            + "\nFailed attempts: " + passwordAttempts.size()
            );
            return false;
        }
    }

}
