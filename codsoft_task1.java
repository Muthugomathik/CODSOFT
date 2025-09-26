import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRoundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\n--- New Round ---");
            if (playSingleRound(scanner)) {
                totalRoundsWon++;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\nThanks for playing! You won " + totalRoundsWon + " rounds.");
        scanner.close();
    }

    public static boolean playSingleRound(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int userGuess;
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        System.out.println("I have generated a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return true; // Round won
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low, try again.");
            } else { // userGuess > randomNumber
                System.out.println("Your guess is too high, try again.");
            }
        }

        System.out.println("Sorry, you ran out of attempts! The correct number was " + randomNumber + ".");
        return false; 
    }
}
