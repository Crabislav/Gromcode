package lesson17.homework3;

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
            return null; //probably change for something
        }

        String[] words = input.trim().split(" ");

        int[] wordsRepeats = countDuplicates(input, words);

        int maxRepeats = 0;
        int maxIndex = 0;
        for (int i = 0; i < wordsRepeats.length; i++) {
            if (wordsRepeats[i] > maxRepeats) {
                maxRepeats = wordsRepeats[i];
                maxIndex = i;
            }
        }

        if (maxRepeats == 0) {
            return null;
        }

        return words[maxIndex];
    }

    //used at the third task
    private static int[] countDuplicates(String input, String[] words) {
        String[] strings = input.split(" ");

        int[] res = new int[words.length];

        for (String string : strings) {
            if (!isWord(string)) {
                continue;
            }
            for (int i = 0; i < words.length; i++) {
                if (isWord(words[i]) && string.equals(words[i])) {
                    res[i]++;
                }
            }
        }

        return res;
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
