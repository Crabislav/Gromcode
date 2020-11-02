package gromcode.main.lesson32.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String[] input = null;
        int attemptsAmount = 3;

        while (attemptsAmount >= 0) {
            if (attemptsAmount == 0) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
                return -1;
            }

            System.out.println("Enter numbers");
            input = br.readLine().trim().split("\\s+");

            if (!isValid(input)) {
                attemptsAmount--;
                System.out.println("Your numbers are wrong. You have " + attemptsAmount + " attempts to try again\n");
            } else {
                break;
            }
        }

        return calcSum(input);
    }

    private static int calcSum(String[] input) {
        int sum = 0;

        for (String number : input) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static boolean isValid(String[] input) {
        //numbers amount
        if (input.length != 10) {
            return false;
        }

        return isInputValuesValid(input);
    }

    private static boolean isInputValuesValid(String[] input) {
        for (String number : input) {
            if (!hasOnlyDigitsAndSpaces(number.toCharArray()) || Integer.parseInt(number) > 100) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasOnlyDigitsAndSpaces(char[] chars) {
        for (char aChar : chars) {
            if (!Character.isDigit(aChar) && !Character.isSpaceChar(aChar)) {
                return false;
            }
        }

        return true;
    }
}