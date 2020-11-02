package gromcode.main.lesson24.firstexample;

public class Demo<T> {
    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());


    }

//    private void printUser(User user){
//        //print
//    }

//    private void printSolution(Solution solution){
//        //print
//    }

//    private void printChannel(Channel channel){
//        //print
//    }

    public void print(T t) {
        System.out.println(t);
    }

    //if we have inheritance
    private static void calculatePrice(AbstractOrder abstractOrder) {
        System.out.println(abstractOrder.getPrice());
    }


}
