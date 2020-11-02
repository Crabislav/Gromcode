package gromcode.main.lesson17.homework3;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";
        String string1 = "word another another";
        String string2 = "word word another another";
        String string3 = "word word f f f another another";

        System.out.println(mostCountedWord(string));
        System.out.println(mostCountedWord(string1));
        System.out.println(mostCountedWord(string2));
        System.out.println(mostCountedWord(string3));

    }

    //the third task
    public static String mostCountedWord(String input) {
        if (input.isEmpty()) {
            return null;
        }

        int tempCount = 0;
        int finalCount = 0;
        String mostCountedWord = "";

        String[] words = input.trim().split(" ");

        for (String word : words) {
            tempCount = 0;

            for (String w : words) {
                if (isWord(word) && isWord(w) && word.equals(w)) {
                    tempCount++;
                }
            }

            if (tempCount >= finalCount) {
                finalCount = tempCount;
                mostCountedWord = word;
            }
        }

        return mostCountedWord;
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
