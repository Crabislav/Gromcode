package lesson17.homework2;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";
        String string1 = "another word  another word another word";
        String string2 = "";
        String string3 = null;
        String string4 = ".... ..";
        String string5 = " ";

        String[] strings = new String[]{string, string1, string2, string3, string4, string5};

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
        String result = words[0];

        for (String word : words) {
            if (isWord(word) && word.length() > result.length()) {
                result = word;
            }
        }
        return isWord(result) ? result : null;
    }

    //finds the shortest word
    public static String minWord(String input) {
        if (input == null || input.isBlank()) {
            return null;
        }
        String[] words = input.trim().split(" ");
        String result = words[0];

        for (String word : words) {
            if (isWord(word) && word.length() < result.length()) {
                result = word;
            }
        }
        return isWord(result) ? result : null;
    }

    private static boolean isWord(String input) {
        return isWordValid(input) && !input.isBlank();
    }

    private static boolean isWordValid(String word) {
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                return false;
            }
        }
        return true;
    }
}
