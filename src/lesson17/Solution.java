package lesson17;

public class Solution {
    public static void main(String[] args) {
        String string = "word  another word another word";
        String string1 = "word another another";
        String string2 = "word word another another";
        String string3 = "word word f f f another another";

        System.out.println(countWords(string));

        System.out.println(maxWord(string));
        System.out.println(minWord(string));

        System.out.println();
        System.out.println(mostCountedWord(string));
        System.out.println(mostCountedWord(string1));
        System.out.println(mostCountedWord(string2));
        System.out.println(mostCountedWord(string3));


        System.out.println(validate("https://sd.org//"));
        System.out.println(validate("http://sd.org"));
        System.out.println(validate("https://sd.org"));
        System.out.println(validate("sd.org"));
        System.out.println(validate("sd"));
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

    //the 4th task
    public static boolean validate(String address) {
        if (address == null || address.isEmpty() || address.isBlank()) {
            return false;
        }

        String[] validProtocols = {"https://", "http://"};
        String[] validDomains = {".com", ".org", ".net"};

        boolean hasSpecChar = false;

        int protocolLength = calculateInputLength(validProtocols, address, true);

        if (protocolLength == -1) {
            return false;
        }

        int domainLength = calculateInputLength(validDomains, address, false);

        if (domainLength == -1) {
            return false;
        }

        //special char checking
        char[] addressChars = address.substring(protocolLength, address.length() - domainLength).toCharArray();
        for (char aChar : addressChars) {
            if (!Character.isLetterOrDigit(aChar)) {
                hasSpecChar = true;
            }
        }

        return !hasSpecChar;
    }

    //used at the fourth task
    private static int calculateInputLength(String[] validWords, String address, boolean isProtocol) {
        if (validWords == null || address == null) {
            return -1;
        }

        for (String validWord : validWords) {
            if (isProtocol && address.startsWith(validWord)) {
                return validWord.length();
            }

            if (!isProtocol && address.endsWith(validWord)) {
                return validWord.length();
            }

        }
        return -1;
    }

    //used at first task
    private static boolean isWordValid(String word) {
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                return true;
            }
        }
        return false;
    }

    //used at the first task
    private static boolean isWord(String input) {
        return !isWordValid(input) && !input.isBlank() && !input.isEmpty();
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
