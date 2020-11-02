package gromcode.main.lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int index = 0;
        int sum = 0;
        int wholePart = 0;
        float fractionalPart = 0.0f;

        //sum
        while (index <= 1000) {
            sum += index;
            index++;
        }

        //division
        wholePart = sum / 1234;
        fractionalPart = sum % 1234;

        //sout
        System.out.println(wholePart < fractionalPart);


    }
}
