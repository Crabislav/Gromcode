package gromcode.main.lesson17.homework2;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";
        String string1 = "another word  another word another word";
        String string2 = "  another word another word";
        String string3 = null;
        String string4 = ".... ..";
        String string5 = " ";
        String string6 = ".. another word  another word another word";

        String[] strings = new String[]{string, string1, string2, string3, string4, string5, string6};

        System.out.println("Max word");
        for (String str : strings) {
            System.out.println(maxWord(str));
        }
        System.out.println();

        System.out.println("Min word");
        for (String str : strings) {
            System.out.println(minWord(str));
        }
    }

    //the second task
    //finds the longest word
    public static String maxWord(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        String[] words = input.trim().split(" ");
        String result = "";

        for (String word : words) {
            if (isWord(word) && word.length() > result.length()) {
                result = word;
            }
        }
        return /*isWord(result) && */!result.isEmpty() ? result : null;
    }

    //finds the shortest word
    public static String minWord(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }

        String[] words = input.trim().split(" ");
        String result = "";

        for (String word : words) {
            if (isWord(word) && (word.length() < result.length() || result.isEmpty())) {
                result = word;
            }
        }

        return !result.isEmpty() ? result : null;
    }

    private static boolean isWord(String input) {
        return isWordValid(input) && !input.isBlank();
    }

    private static boolean isWordValid(String word) {
        if (word.isBlank()) {
            return false;
        }

        for (char aChar : word.toCharArray()) {
            if (!Character.isLetter(aChar)) {
                return false;
            }
        }
        return true;
    }
}
