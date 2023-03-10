import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordChoose {
    private List<String> words;

    public WordChoose() {
        this.words = new ArrayList<>();
        try {
            this.words = Files.readAllLines(Paths.get("words.txt"));
        } catch (IOException e) {   // Could not manage to make the program read this file without this error catcher
            System.err.println("Error reading words file: " + e.getMessage());
        }
    }

    public String getNextWord() {   // This is the main method to get a random word from the word bank
        Random random = new Random();
        int index = random.nextInt(this.words.size());
        return this.words.get(index);
    }

    public static void main(String[] args) {
        WordChoose choose = new WordChoose();
        System.out.println("Random word: " + choose.getNextWord()); // This line is used as a test
    }
}
