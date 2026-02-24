/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy = new StackStrategy();

        // Start time
        long startTime = System.nanoTime();

        boolean result = strategy.isPalindrome(input);

        // End time
        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        System.out.println("Execution Time: " + duration + " nanoseconds");

        sc.close();
    }
}


/**
 * Strategy Interface
 */
interface PalindromeStrategy {

    boolean isPalindrome(String input);
}


/**
 * Stack Strategy Implementation
 */
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {

            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {

            if (normalized.charAt(i) != stack.pop()) {

                return false;
            }
        }

        return true;
    }
}