import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // 1. Define the range for the number
        int lowerBound = 1;
        int upperBound = 100;

        //2. Generate a random number within the range
        int randomNumber = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;

        // 3.Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've chosen a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess it?");

        //4. Loop until the user guesses the correct number
        while (userGuess != randomNumber) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number!");
            }
        }

        // 5.Close the scanner
        scanner.close();
    }
}
