package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";
        //frequently used String methods
        //isEmpty
        System.out.println(test.isEmpty());

        //isEmpty
        System.out.println("".isEmpty());

        //length
        System.out.println(test.length());

        //charAt
        System.out.println(test.charAt(2));

        //replace
        String res = test.replace("me", "T");
        System.out.println(res);

        //replaceAll
        System.out.println(test.replaceAll("me", "T"));
        //String regex ="{a-Z}";

        //contains
        System.out.println(test);
        System.out.println(test.contains("mes"));

        //split
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));

        //trim - deletes spaces at the beginning and at the end of string
        System.out.println(" test a".trim());

        //substring
        System.out.println(phrase.substring(5));
        //includes the first param and the second - doesn't
        System.out.println(phrase.substring(5, 10).trim());

        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());


    }
}
