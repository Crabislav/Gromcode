package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int oddSum = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 2 != 0) {
                System.out.println("Found");
                oddSum += i;
            }
        }

        if ((oddSum *= 5) > 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
