package Lab11;

public class testApplication {

    public static void main(String[] args) {
        SimpleGeneric<String> o1 = new SimpleGeneric<String>("Hello Generic");
        o1.print();
        o1.printType();
        SimpleGeneric<Double> o2 = new SimpleGeneric<Double>(5.5);
        o2.print();
        o2.printType();
    }

}
