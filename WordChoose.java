import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordList {
    private List<String> words;

    public WordList() {
        this.words = new ArrayList<>();
        try {
            this.words = Files.readAllLines(Paths.get("words.txt"));
        } catch (IOException e) {
            System.err.println("Error reading words file: " + e.getMessage());
        }
    }

    public String getNextWord() {
        Random random = new Random();
        int index = random.nextInt(this.words.size());
        return this.words.get(index);
    }

    public static void main(String[] args) {
        WordList choose = new WordList();
        System.out.println("Random word: " + choose.getNextWord());
    }
}
