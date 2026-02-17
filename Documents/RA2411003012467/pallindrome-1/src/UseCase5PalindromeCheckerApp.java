import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        // Declare and initialize input
        String input = "noon";

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push each character into stack
        for (char c : input.toCharArray()) {

            stack.push(c);

        }

        boolean isPalindrome = true;

        // Compare with popped characters
        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {

                isPalindrome = false;
                break;

            }

        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

    }

}
