import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = {"java", "programming", "computer", "hangman", "algorithm", "developer"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = WORDS[random.nextInt(WORDS.length)]; 
        int wordLength = wordToGuess.length();
        char[] display = new char[wordLength];
        boolean[] guessed = new boolean[26];

       
        for (int i = 0; i < wordLength; i++) {
            display[i] = '_';
        }

        int incorrectGuesses = 0;
        int maxIncorrectGuesses = 6; 

       
        while (incorrectGuesses < maxIncorrectGuesses) {
            System.out.println("Current Word: " + String.valueOf(display));
            System.out.println("Incorrect Guesses: " + incorrectGuesses);
            System.out.println("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (guessed[guess - 'a']) {
                System.out.println("You already guessed this letter. Try again.");
                continue;
            }

            guessed[guess - 'a'] = true;

            boolean found = false;
            for (int i = 0; i < wordLength; i++) {
                if (wordToGuess.charAt(i) == guess) {
                    display[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                incorrectGuesses++;
                displayHangman(incorrectGuesses);
            }

           
            if (String.valueOf(display).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println("Sorry, you ran out of guesses. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static void displayHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 1:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 2:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |     |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 3:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 4:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 5:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    /");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 6:
                System.out.println("   _____");
                System.out.println("  |     |");
                System.out.println("  |     O");
                System.out.println("  |    /|\\");
                System.out.println("  |    / \\");
                System.out.println("  |");
                System.out.println("  |");
                break;
        }
    }
}
