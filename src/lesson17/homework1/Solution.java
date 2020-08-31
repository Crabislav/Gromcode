package lesson17.homework1;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";
        System.out.println(countWords(string));
    }

    //the first task
    //a word consists of letters only
    public static int countWords(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        int count = 0;
        String[] words = input.trim().split(" ");

        for (String word : words) {
            if (isWord(word)) {
                count++;
            }
        }
        return count;
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
