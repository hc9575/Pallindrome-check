public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {

            reversed = reversed + input.charAt(i);

        }

        if (input.equals(reversed)) {

            System.out.println("Original String: " + input);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Result: Palindrome");

        } else {

            System.out.println("Original String: " + input);
            System.out.println("Reversed String: " + reversed);
            System.out.println("Result: Not a Palindrome");

        }

    }

}
