/**
 * ------------------------------------------------------------
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ------------------------------------------------------------
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithm
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 *
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

import java.util.Scanner;
import java.util.Stack;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input string: ");
        String input = sc.nextLine();

        // Inject strategy
        PalindromeStrategy strategy = new StackStrategy();

        // Execute strategy
        boolean result = strategy.isPalindrome(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}

/**
 * ============================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 */
interface PalindromeStrategy {

    boolean isPalindrome(String input);
}


/**
 * ============================================================
 * CLASS - StackStrategy
 * ============================================================
 *
 * This class implements palindrome checking using Stack.
 */
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare while popping
        for (int i = 0; i < normalized.length(); i++) {

            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}