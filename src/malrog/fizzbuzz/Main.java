package malrog.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int maxValue = 200;
        for (int i = 1; i <= maxValue; i++) {
            List<String> words = new ArrayList<>();
            addWordAtEndForIteratorDivisibleBy(i, 3, "Fizz", words);
            addWordAtEndForIteratorDivisibleBy(i, 5, "Buzz", words);
            addWordAtEndForIteratorDivisibleBy(i, 7, "Bang", words);
            substituteWordForIteratorDivisibleBy(i, 11, "Bong", words);
            addWordAtStartForIteratorDivisibleBy(i, 13, "Fezz", words);
            if (words.isEmpty()) System.out.print(i);
            else for (String word : words) System.out.print(word);
            System.out.print("\n");
        }
    }

    static void addWordAtEndForIteratorDivisibleBy(int iterator, int divisor, String wordToAdd, List<String> words) {
        if (iterator % divisor == 0) words.add(wordToAdd);
    }
    static void substituteWordForIteratorDivisibleBy(int iterator, int divisor, String wordToAdd, List<String> words) {
        if (iterator % divisor == 0){
            words.clear();
            words.add(wordToAdd);
        }
    }

    static void addWordAtStartForIteratorDivisibleBy(int iterator, int divisor, String wordToAdd, List<String> words) {
        if (iterator % divisor == 0) words.add(0, wordToAdd);
    }
}