package lesson31.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //возвращать Map, которая хранит количество повторей каждого буквенного символа в этом тексте
    static Map<Character, Integer> countSymbols(String text) throws Exception {
        validateInput(text);

        Map<Character, Integer> result = new HashMap<>();

        Character[] chars = text.chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new);

        for (Character aChar : chars) {
            if (!Character.isLetter(aChar) || result.containsKey(aChar)) {
                continue;
            }
            result.put(aChar, getRepeats(chars, aChar));
        }
        return result;
    }

    // Второй метод words, должен возвращать Map, которая содержит ко-во повторений слов во входящем тексте.
    // Словом считаем набор букв, длинной больше 2
    static Map<String, Integer> words(String text) throws Exception {
        validateInput(text);

        Map<String, Integer> result = new HashMap<>();

        String[] words = text.split(" ");

        for (String word : words) {
            if (!isWord(word) || result.containsKey(word)) {
                continue;
            }
            result.put(word, getRepeats(words, word));
        }
        return result;
    }

    private static <T> int getRepeats(T[] array, T element) {
        int count = 0;

        for (T t : array) {
            if (t.equals(element)) {
                count++;
            }
        }
        return count;
    }

    private static void validateInput(String text) throws Exception {
        if (text == null) {
            throw new Exception("null input");
        }

        if (text.isBlank()) {
            throw new Exception("input is blank");
        }
    }

    private static boolean isWord(String word) {
        return word.length() > 2;
    }
}
