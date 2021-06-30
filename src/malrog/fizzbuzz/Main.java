package malrog.fizzbuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner usersMaxNumber = new Scanner(System.in);
        System.out.println("Enter the maximum number:");
        int maxValue = usersMaxNumber.nextInt();

        Scanner usersRules = new Scanner(System.in);
        System.out.println("Choose which rules you want to use by writing a sequence of six 0's and 1's (where 0 means 'don't apply', 1: 'apply') corresponding to 3, 5, 7, 11, 13, 17 (in this order).");
        System.out.println("[For example 001010 means: apply only rules of 7 and 13.]");
        String usersRulesInString = usersRules.nextLine();
        ArrayList<Boolean> rules = new ArrayList<>();
        for(int i=0;i<6;i++){
            if(usersRulesInString.charAt(i) == '0') rules.add(false);
            else rules.add(true);
        }

        int[] addWordToAddAtEnd_possibleDivisors = {3,5,7};
        String[] addWordToAddAtEnd_possibleWords = {"Fizz","Buzz","Bang"};
        ArrayList<Integer> addWordAtEnd_divisors = new ArrayList<>();
        ArrayList<String> addWordAtEnd_words = new ArrayList<>();
        for(int i=0;i<3;i++) {
            if(rules.get(i)) {
                addWordAtEnd_divisors.add(addWordToAddAtEnd_possibleDivisors[i]);
                addWordAtEnd_words.add(addWordToAddAtEnd_possibleWords[i]);
            }
        }

        for (int i = 1; i <= maxValue; i++) {
            List<String> words = new ArrayList<>();
            for(int j=0;j<addWordAtEnd_words.size();j++) addWordAtEndForIteratorDivisibleBy(i, addWordAtEnd_divisors.get(j), addWordAtEnd_words.get(j), words);
            if(rules.get(3)) substituteWordForIteratorDivisibleBy(i, 11, "Bong", words);
            if(rules.get(4)) addWordAtStartForIteratorDivisibleBy(i, 13, "Fezz", words);
            if(rules.get(5)) reverseOrderForIteratorDivisibleBy(i, 17, words);

            if (words.isEmpty()) System.out.print(i);
            else for (String word : words) System.out.print(word);
            System.out.print("\n");
        }
    }

    static void addWordAtEndForIteratorDivisibleBy(int iterator, int divisor, String wordToAdd, List<String> words) {
        if (iterator % divisor == 0) words.add(wordToAdd);
    }
    static void substituteWordForIteratorDivisibleBy(int iterator, int divisor, String wordToSubstitute, List<String> words) {
        if (iterator % divisor == 0){
            words.clear();
            words.add(wordToSubstitute);
        }
    }

    static void addWordAtStartForIteratorDivisibleBy(int iterator, int divisor, String wordToAdd, List<String> words) {
        if (iterator % divisor == 0) words.add(0, wordToAdd);
    }

    static void reverseOrderForIteratorDivisibleBy(int iterator, int divisor, List<String> words) {
        if (iterator % divisor == 0) Collections.reverse(words);
    }
}