import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Game {
    static void startHangmanGame() {
        // Define common game loop
        while (true) {
            // Define Scanner object for input
            Scanner scanner = new Scanner(System.in);
            // Print games title
            System.out.println("HANGMAN game welcomes you!");
            // Randomly choose one word from dictionary
            String secretWord = Word.chooseWord();
            int wordLength = secretWord.length();
            // Define hidden version of word (underscores instead letters)
            char[] hiddenWord = new char[wordLength];
            Arrays.fill(hiddenWord, '_');
            // Define counters for decreasing underscores and failed guesses
            int blanksCounter = wordLength;
            int failCounter = 0;
            int maxFailedAttempts = Art.hangmanPics.length - 1;
            // Define list of entered letters
            ArrayList<Character> enteredLetters = new ArrayList<>();
            // Define var for final game result
            String gameResult;
            // Define inner loop for specific word guessing
            while (true) {
                // Display game state: art, hidden word, fails
                System.out.println(Art.hangmanPics[failCounter]);
                System.out.println("Secret word: " + String.valueOf(hiddenWord));
                System.out.println("Entered letters: " + String.valueOf(enteredLetters));
                System.out.println("Failed attempts: " + failCounter + " from " + maxFailedAttempts);
                // Check if fails reach max amount
                if (failCounter == maxFailedAttempts) {
                    gameResult = "Game Over! Player was hanged!";
                    break;
                }
                // Check if blank letters not remain
                if (blanksCounter == 0) {
                    gameResult = "Player WIN the game!";
                    break;
                }
                // Take guess
                System.out.println("===============");
                System.out.print("Guess a letter: ");
                String guess = scanner.next();
                char guessedLetter = guess.charAt(0);
                enteredLetters.add(guessedLetter);
                // Replace underscores by letters if guess right
                boolean isGuessFail = true;
                for (int i = 0; i < wordLength; i++) {
                    if (secretWord.charAt(i) == guessedLetter) {
                        hiddenWord[i] = guessedLetter;
                        blanksCounter -= 1;
                        isGuessFail = false;
                    }
                }
                // Increase fails counter if guess failed
                if (isGuessFail) {
                    failCounter += 1;
                }
                // Clear console for displaying game status statically (not work in IDEs)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            // Display game's result
            System.out.println(gameResult);
            // Ask for starting new game or quiting
            System.out.print("Type 'start' for new game, type 'quit' for exit: ");
            String startGameOrQuit = scanner.next();
            if (startGameOrQuit.equals("quit")) {
                break;
            }
        }
    }
}
