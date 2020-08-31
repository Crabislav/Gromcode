package lesson17.homework2;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";

        System.out.println(maxWord(string));
        System.out.println(minWord(string));
    }

    //the second task
    //finds the longest word
    public static String maxWord(String input) {
        if (input.isEmpty()) {
            return null; //probably change for something
        }
        String[] words = input.trim().split(" ");
        String result = words[0];

        for (String word : words) {
            if (isWord(word) && word.length() > result.length()) {
                result = word;
            }
        }
        return result;
    }

    //finds the shortest word
    public static String minWord(String input) {
        if (input.isEmpty()) {
            return null; //probably change for something
        }
        String[] words = input.trim().split(" ");
        String result = words[0];

        for (String word : words) {
            if (isWord(word) && word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }

    private static boolean isWord(String input) {
        return !isWordValid(input) && !input.isBlank() && !input.isEmpty();
    }

    private static boolean isWordValid(String word) {
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                return true;
            }
        }
        return false;
    }
}
