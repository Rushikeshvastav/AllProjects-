import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Shuffle an array
        Integer[] arrayToShuffle = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> list = Arrays.asList(arrayToShuffle);
        Collections.shuffle(list);
        System.out.println("Shuffled Array: " + Arrays.toString(arrayToShuffle));

        //Convert Roman Number to Integer
        Scanner objs = new Scanner(System.in);
        System.out.println("Enter Roman No.");
        String romanInput = objs.nextLine();
        int integerResult = romanToInteger(romanInput);
        System.out.println("Converted to Integer: " + integerResult);

        //Check for Pangram
        String sentenceInput = "The quick brown fox jumps over the lazy dog";
        if (isPangram(sentenceInput)) {
            System.out.println("The input is a Pangram.");
        } else {
            System.out.println("The input is not a Pangram.");
        }
    }

    //Convert Roman Number to Integer
    private static int romanToInteger(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char numeral = roman.charAt(i);
            int value = getValue(numeral);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }

    private static int getValue(char numeral) {
        switch (numeral) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral: " + numeral);
        }
    }

    //Check for Pangram
    private static boolean isPangram(String sentence) {
        String lowerCaseSentence = sentence.toLowerCase();
        return lowerCaseSentence.chars().filter(Character::isLetter).distinct().count() == 26;
    }
}