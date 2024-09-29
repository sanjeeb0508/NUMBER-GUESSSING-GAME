import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int totalRounds = 3; // Number of rounds
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10; // Limit number of attempts

            JOptionPane.showMessageDialog(null, "Round " + round + ": Guess the number between 1 and 100!");

            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog("Enter your guess (Attempt " + (attempts + 1) + "):");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game exited.");
                    return; // Exit if the user cancels
                }

                try {
                    int guess = Integer.parseInt(input);
                    attempts++;

                    if (guess < 1 || guess > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                    } else if (guess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Higher! Try again.");
                    } else if (guess > numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Lower! Try again.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed it right.");
                        score += (maxAttempts - attempts + 1); // Calculate score based on remaining attempts
                        break; // Exit the loop if guessed correctly
                    }

                    if (attempts == maxAttempts) {
                        JOptionPane.showMessageDialog(null, "Sorry! You've used all your attempts. The number was: " + numberToGuess);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                }
            }
        }

        // Display final score
        JOptionPane.showMessageDialog(null, "Game Over! Your total score is: " + score);
    }
}
