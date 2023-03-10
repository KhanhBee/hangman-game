import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int guessRemain = 6;
        WordChoose WordChoose = new WordChoose();
        String word = WordChoose.getNextWord().toLowerCase();   // Picking a word from the words.txt file
        String ongoingGuess;
        String usedLetters = "";
        System.out.println("");
        System.out.println("====================================");
        System.out.println("The computer has chosen a word!");
        
        char[] wordArray = word.toCharArray();  // Dividing the word into chars
        char[] guessArray = new char[wordArray.length];
        for (int i = 0; i < guessArray.length; i++) {
            guessArray[i] = '_';    // 
        }

        while (guessRemain > 0) {   // As long as there are still guesses left, the game will keep playing
            
            String guess = "";

            while (true) {  // Stop player from inputting more than one letter at a time and make it lower case
                System.out.print("Guess a letter: ");
                String playerInput = in.nextLine();
                if (playerInput.length() == 1) {
                    guess = playerInput.toLowerCase();
                    break;
                }else {
                    System.out.println("Please enter one letter!");
                }
            }

            if (usedLetters.indexOf(guess) != -1) {     // Preventing duplicate guess
                System.out.println("Duplicate guess!");
                continue;
            }
            usedLetters += guess;
            boolean correctLetters = false;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess.charAt(0)) {
                    guessArray[i] = guess.charAt(0);
                    correctLetters = true;
                    System.out.println("");
                    System.out.println("The letter '" + guess + "' exists in this word!");
                }
            }
            if (!correctLetters) {  // Every time there's a wrong answer, the program will print the figure with another limb drawn
                guessRemain--;
                System.out.println("");
                System.out.println("The letter '" + guess + "' does not exist in this word!");
                System.out.println("Guesses remaining: " + guessRemain);
                drawHangman(guessRemain);
            }else {
                drawHangman(guessRemain);
            }
            
            ongoingGuess = new String(guessArray);
            System.out.println("");
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

    public static void drawHangman(int guessRemain) {   // Hangman drawing function
        switch (guessRemain) {
            case 5:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 4:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |      |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 3:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 2:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 1:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |     /");
                System.out.println(" _|_");
                break;
            case 0:
                System.out.println("");
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      O");
                System.out.println("  |     /|\\");
                System.out.println("  |     / \\");
                System.out.println(" _|_");
                break;
        }
    }
}
