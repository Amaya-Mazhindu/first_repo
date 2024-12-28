import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Initialize random number generator
        Random random = new Random();

        // Display mode selection using JOptionPane
        String[] options = {"Survival", "Leisure"};
        int modeChoice = JOptionPane.showOptionDialog(
                null, 
                "Choose your mode:", 
                "Guess the Number Game", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]
        );

        // Validate mode choice
        if (modeChoice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Game closed. Exiting...");
            return;
        }

        // Generate a random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;
        boolean guessedCorrectly = false;
        int number = numberToGuess + 5;
        if (modeChoice == 0) { // Survival mode
            // Set max attempts for Survival mode
            int maxAttempts = 5;
            String message = "Survival mode selected! You have " + maxAttempts + " attempts to guess the number.";
            JOptionPane.showMessageDialog(null, message);

            // Loop for the number of attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                String input = JOptionPane.showInputDialog(null, "Enter your guess (1-100):");
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    guessedCorrectly = true;
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

        } else { // Leisure mode
            // Inform the user about Leisure mode
            JOptionPane.showMessageDialog(null, "Leisure mode selected! You can keep guessing until you find the correct number.");

            // Loop until the correct number is guessed
            while (!guessedCorrectly) {
                String input = JOptionPane.showInputDialog(null, "Enter your guess (1-100):");
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                    continue;
                }

                if (numberToGuess < guess && guess > number ) {
                    JOptionPane.showMessageDialog(null, "Real Close,Try again.");
                }

                if (guess == numberToGuess) {
                    guessedCorrectly = true;
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.");
        }
    }
}
