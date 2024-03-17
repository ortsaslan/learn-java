import java.util.Arrays;
import java.util.Scanner;

class Game {
    static void startHangmanGame() {
        // Print games title
        System.out.println(Art.title);
        // Randomly choose one word from dictionary
        String secretWord = Word.chooseWord();
        int wordLength = secretWord.length();
        // Define hidden version of word (underscores instead letters)
        char[] hiddenWord = new char[wordLength];
        Arrays.fill(hiddenWord, '_');
        // Define counters for decreasing underscores and failed guesses
        int blanksCounter = wordLength;
        int failCounter = 0;
        // Define var for final game result
        String gameResult;
        // Define Scanner object for input
        Scanner scanner = new Scanner(System.in);
        // Define main game loop
        while (true) {
            // Display game state art and hidden word
            System.out.println(Art.hangmanPics[failCounter]);
            System.out.println(hiddenWord);
            // Check if fails reach max amount
            if (failCounter == Art.hangmanPics.length - 1) {
                gameResult = "Game Over! Player was hanged!";
                break;
            }
            // Check if blank letters not remain
            if (blanksCounter == 0) {
                gameResult = "Player WIN the game!";
                break;
            }
            // Take guess
            System.out.print("\nGuess a letter: ");
            String guess = scanner.next();
            char guessedLetter = guess.charAt(0);
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
        }
        // Display game's result
        System.out.println(gameResult);
    }
}
