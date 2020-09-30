package lesson24.firstexample;

public class Main {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        User user = new User(2);
        Solution solution = new Solution("test1");

        Demo<User> demo = new Demo<>();
        demo.print(user);

        Demo<Solution> demo1 = new Demo<>();
        demo1.print(solution);
    }
}
