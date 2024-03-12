import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class WordAnalyzerInJava {
    private List<String> wordList;
    private Map<String, Integer> wordSpawn;

    public WordAnalyzerInJava() {
        wordList = new ArrayList<>();
        wordSpawn = new HashMap<>();
    }

    public void addWord(String word) {
        word = word.trim().toLowerCase();
        wordList.add(word);
        wordSpawn.put(word, wordSpawn.getOrDefault(word, 0) + 1);
    }

    public List<String> getOriginalText() {
        return wordList;
    }

    public List<String> getUniqueWords() {
        return new ArrayList<>(wordSpawn.keySet());
    }

    public int getUniqueWordCount() {
        return wordSpawn.size();
    }

    public int getWordFrequency(String word) {
        word = word.toLowerCase();
        return wordSpawn.getOrDefault(word, 0);
    }

    public String getShortestWord() {
        String shortest = "";
        for (String word : wordList) {
            if (shortest.isEmpty() || word.length() < shortest.length()) {
                shortest = word;
            }
        }
        return shortest;
    }

    public String getLongestWord() {
        String longest = "";
        for (String word : wordList) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}

public class Main {
    public static void main(String[] args) {
        WordAnalyzerInJava analyzer = new WordAnalyzerInJava();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter words (type 'stop' to finish):");
        String word = scanner.nextLine();
        while (!word.equalsIgnoreCase("stop")) {
            analyzer.addWord(word);
            word = scanner.nextLine();
        }

        System.out.println("Original text: " + analyzer.getOriginalText());
        System.out.println("Unique words: " + analyzer.getUniqueWords());
        System.out.println("Number of unique words: " + analyzer.getUniqueWordCount());

        System.out.print("Enter a word to find its number of spawns: ");
        word = scanner.nextLine();
        System.out.println("This word \"" + word + "\" got spawned " + analyzer.getWordFrequency(word) + " times.");

        System.out.println("Shortest word: " + analyzer.getShortestWord());
        System.out.println("Longest word: " + analyzer.getLongestWord());

        scanner.close();
    }
}
