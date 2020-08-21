package lesson17;

public class Solution {
    public static void main(String[] args) {
        String string = "as asd   aad123   ";
        System.out.println(countWords(string));

        System.out.println(maxWord(string));
        System.out.println(minWord(string));
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
            if (!hasSpecialChar(word) && !word.isBlank()) {
                count++;
            }
        }
        return count;
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
            if (!hasSpecialChar(word) && !word.isBlank() && word.length() > result.length()) {
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
            if (!hasSpecialChar(word) && !word.isBlank() && word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }

//    //the third task
//    public static String mostCountedWord(String input) {
//        if (input.isEmpty()) {
//            return null; //probably change for something
//        }
//
//        String[] words = input.trim().split(" ");
//        String result = words[0];
//
//        int[] wordsRepeats = new int[words.length]; //TODO: check up here for array length
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (words[i].equals(words[j])) {
//
//                }
//            }
//        }
//
//        return result;
//    }

    private static boolean hasSpecialChar(String word) {
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                return true;
            }
        }
        return false;
    }


//    //TODO: find out how to do this method
//    public static int countWords(String input) {
//        if (input.isEmpty()) {
//            return 0;
//        }
//
//        //indexes for substring method
//        int firstIndex = 0;
//        int secondIndex = 0;
//
//        char[] chars = input.trim().toCharArray();
//        ArrayList<String> words = new ArrayList<>();
//
//        for (char aChar : chars) {
//            if (aChar >= 'A' && aChar <= 'Z' || aChar >= 'a' && aChar <= 'z') {
//                secondIndex++;
//            }
//
//            if (secondIndex == chars.length) {
//                return 1;
//            }
//
//            if (aChar == ' ') {
//                words.add(input.substring(firstIndex, secondIndex));
//                firstIndex = secondIndex + 1;
//                secondIndex += 1;
//            }
//        }
//        return words.size();
//    }
}
