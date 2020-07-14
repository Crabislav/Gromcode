package lesson4;

public class CompareSums {
    public static void main(String[] args) {
//        System.out.println("Sum from 1 to 5 = " + sum(1,5)); // 1+2+3+4+5 = 15
//        System.out.println("Sum from 6 to 10 = " + sum(6,10)); //6+7+8+9+10 = 40

        System.out.println(compareSums(1, 10, 11, 20));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return (sum(a, b) > sum(c, d));
    }

    public static int sum(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }
}
