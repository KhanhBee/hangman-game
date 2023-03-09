import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int guessRemain = 6;
        String ongoingGuess;
        String usedLetters = "";
        System.out.println("");
        System.out.println("====================================");
        System.out.print("Enter the goal word: ");  //A way for the goal word to be chosen randomly from a word bank will be added later.
        String word = in.nextLine().toLowerCase();
        char[] wordArray = word.toCharArray();
        char[] guessArray = new char[wordArray.length];
        for (int i = 0; i < guessArray.length; i++) {
            guessArray[i] = '_';
        }

        while (guessRemain > 0) {
            System.out.print("Guess a letter: ");
            char guess = in.nextLine().toLowerCase().charAt(0);
            if (usedLetters.indexOf(guess) != -1) {
                System.out.println("Duplicate guess!");
                continue;
            }
            usedLetters += guess;
            boolean correctLetters = false;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess) {
                    guessArray[i] = guess;
                    correctLetters = true;
                }
            }
            if (!correctLetters) {
                guessRemain--;
                drawHangman(guessRemain);
            }else {
                drawHangman(guessRemain);
            }
            
            ongoingGuess = new String(guessArray);
            System.out.println(ongoingGuess);
            System.out.println("");
            System.out.println("====================================");
            System.out.println("Already used letters: " + usedLetters);
            if (ongoingGuess.indexOf('_') == -1) {
                System.out.println("You win! The word was '" + word + "'.");
                System.out.println("");
                System.out.println("====================================");
                return;
            }
        }
        System.out.println("You lose! The word was '" + word + "'.");
    }

    public static void drawHangman(int guessRemain) {
        switch (guessRemain) {
            case 5:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |      |");
                System.out.println("  |");
                System.out.println(" _|_");
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|");
                System.out.println("  |");
                System.out.println(" _|_");
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |");
                System.out.println(" _|_");
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |     /");
                System.out.println(" _|_");
                System.out.println("");
                break;
            case 0:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |     / \\");
                System.out.println(" _|_");
                System.out.println("");
                break;
        }
    }
}

