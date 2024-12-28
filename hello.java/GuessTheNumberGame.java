import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
      
        Random random = new Random();

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

      
        if (modeChoice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Game closed. Exiting...");
            return;
        }

        
        int numberToGuess = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;
        boolean guessedCorrectly = false;
        int number = numberToGuess + 5;
        if (modeChoice == 0) { 
            
            int maxAttempts = 5;
            String message = "Survival mode selected! You have " + maxAttempts + " attempts to guess the number.";
            JOptionPane.showMessageDialog(null, message);

           
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

        } else { 
            JOptionPane.showMessageDialog(null, "Leisure mode selected! You can keep guessing until you find the correct number.");

            
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
