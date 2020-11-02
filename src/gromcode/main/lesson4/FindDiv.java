package gromcode.main.lesson4;

public class FindDiv {
    public static void main(String[] args) {
        short a = 1;
        short b = 10;
        int n = 2;

        System.out.println(findDivCount(a, b, n));
//        System.out.println(findDivCount((short) 1, (short) 10, 2);
    }

    //n > 0, 0 <= a <= b
    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        if (n > 0 && a >= 0 && b >= a) {
            for (int i = a; i <= b; i++) {
                if (i % n == 0)
                    count++;
            }
        } else
            System.out.println("Wrong input");
        return count;
    }
}
