package gromcode.main.lesson15.cast;

//submit code
public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();
        System.out.println(provider);

    }

    private static Provider test() {
        //logic
        return new InternetProvider();
    }

    private static Provider testFood() {
        //logic
        return new InternetProvider();
    }
}
