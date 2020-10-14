package lesson31.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Словом считаем набор букв, длинной больше 2

    //возвращать Map, которая хранит количество повторей каждого буквенного символа в этом тексте
    static Map<Character, Integer> countSymbols(String text) throws Exception {
        validateInput(text);

        Map<Character, Integer> result = new HashMap<>();

        char[] chars = text.trim().toCharArray();

        for (char aChar : chars) {
            if (!Character.isLetter(aChar) || result.containsKey(aChar)) {
                continue;
            }

            int count = 0;

            for (char ch : chars) {
                if (aChar == ch) {
                    count++;
                }
            }
            result.put(aChar, count);
        }
        return result;
    }


    // Второй метод words, должен возвращать Map, которая содержить ко-во повторений слов во входящем тексте.

    Map<String, Integer> words(String text) throws Exception {
        validateInput(text);


        Map<String, Integer> result = new HashMap<>();


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
