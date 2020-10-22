package lesson31.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //возвращать Map, которая хранит количество повторей каждого буквенного символа в этом тексте
    static Map<Character, Integer> countSymbols(String text) throws Exception {
        validateInput(text);

        Map<Character, Integer> result = new HashMap<>();

        char[] chars = text.toCharArray();

        for (char aChar : chars) {
            //calcs repeats
            if (result.containsKey(aChar)) {
                result.put(aChar, result.get(aChar) + 1);
            }

            //sets the first repeat for proper element
            if (Character.isLetter(aChar)) {
                result.putIfAbsent(aChar, 1);
            }
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
            //calcs repeats
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            }

            //sets the first repeat for proper element
            if ((word.length() > 2)) {
                result.putIfAbsent(word, 1);
            }
        }
        return result;
    }


    private static void validateInput(String text) throws Exception {
        if (text == null) {
            throw new Exception("null input");
        }

        if (text.isBlank()) {
            throw new Exception("input is blank");
        }
    }
}
