package lesson18.homework2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] text = {"asdasdasd 222s 333", null, "222 22222"};

        for (String textItem : text) {
            System.out.println(Arrays.toString(findNumbers(textItem)));
        }
    }

    public static int[] findNumbers(String text) {
        if (text == null) {
            return new int[0];
        }

        String[] words = text.split(" ");

        int count = 0; //used for counting a result array length

        //used to find out a future array length
        for (String word : words) {
            if (hasOnlyDigits(word)) {
                count++;
            }
        }

        int[] resultArray = new int[count];
        int index = 0;

        //result array filling
        for (String word : words) {
            if (hasOnlyDigits(word)) {
                resultArray[index] = Integer.parseInt(word);
                index++;
            } else {
                System.err.println(word + " not a number");
            }
        }

        return resultArray;
    }

    private static boolean hasOnlyDigits(String word) {
        if (word.isBlank()) {
            return false;
        }

        for (char aChar : word.toCharArray()) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }
}
