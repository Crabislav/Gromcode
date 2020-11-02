package gromcode.main.lesson32.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException {
//        readKeyboardWithScanner();

        readKeyboardWithIOStream();
    }

    private static void readKeyboardWithScanner() {
        //using scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name");
        System.out.println("Hello, " + scanner.nextLine());

//        int n = 2;
//        while (scanner.hasNext() && n > 0) {
//            System.out.println(scanner.next() + "!");
//            n--;
//
//            if (n == 0) {
//                break;
//            }
//        }

        scanner.close();
    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);


        System.out.println("Please enter your name");
        String input = br.readLine();
        try {
            validateInput(input);
            System.out.println("Hello, " + input + "!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.out.println("\nTry again");
            readKeyboardWithIOStream();
        }
    }

    private static void validateInput(String input) throws IOException {
        if (input == null || input.isEmpty()) {
            throw new IOException("Invalid input");
        }

        validateWordsAmount(input);
        checkForSpecCharAndDigits(input);
    }

    private static void validateWordsAmount(String input) throws IOException {
        //check amount of words
        String[] words = input.split("\\s+");

        int wordsAmount = words.length;
        if (wordsAmount > 1) {
            throw new IOException("Invalid input words amount (amount = " + wordsAmount + ")");
        }
    }

    private static void checkForSpecCharAndDigits(String input) throws IOException {
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (!Character.isLetter(aChar)) {
                throw new IOException("Input must have only letters");
            }
        }
    }
}

