package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        long sum = 0L;
        long index = 0L;
        while (index <= 10_000_000) {
            sum = sum + index;
            index++;
        }
        System.out.println(sum);
    }
}
