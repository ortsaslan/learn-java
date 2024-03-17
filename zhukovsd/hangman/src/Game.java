/*
Алгоритм программы:
1. Запустить цикл
2. Вывести название игры
3. Вывести Виселицу
4. Спросить о начале игры: да/нет и сохранить выбор:
    4.1. Если выбор=выход завершить программу
    4.2. Если выбор=старт продолжить:
        4.2.1. Запустить цикл:
            1. Сохранить секретное слово
            2. Сохранить его скрытую версию из символов подчеркивания
            3.
*/

import java.util.Arrays;
import java.util.Scanner;

class Game {
    static void startHangmanGame() {
        System.out.println(Art.title);

        String secretWord = Word.chooseWord();
        int wordLength = secretWord.length();

        char[] hiddenWord = new char[wordLength];
        Arrays.fill(hiddenWord, '_');

        int blanksCounter = wordLength;
        int failCounter = 0;

        String gameResult;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Art.hangmanPics[failCounter]);
            System.out.println(hiddenWord);

            if (failCounter == Art.hangmanPics.length - 1) {
                gameResult = "Game Over! Player was hanged!";
                break;
            }

            if (blanksCounter == 0) {
                gameResult = "Player WIN the game!";
                break;
            }

            System.out.print("\nGuess a letter: ");
            String guess = scanner.next();
            char guessedLetter = guess.charAt(0);

            boolean isGuessFail = true;
            for (int i = 0; i < wordLength; i++) {
                if (secretWord.charAt(i) == guessedLetter) {
                    hiddenWord[i] = guessedLetter;
                    blanksCounter -= 1;
                    isGuessFail = false;
                }
            }
            if (isGuessFail) {
                failCounter += 1;
            }
        }

        System.out.println(gameResult);
    }
}
