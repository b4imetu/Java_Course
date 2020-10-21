package myCode.ch02;

public class p3TestCalculator {
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        final Calculator cal = new Calculator();
        System.out.println(cal.getResult());
        cal.add(6); // +6
        System.out.println(cal.getResult());
        cal.substract(4); // -4
        System.out.println(cal.getResult());
        cal.multiply(3); // *3
        System.out.println(cal.getResult());
        cal.divide(2); // /2
        System.out.println(cal.getResult());
        cal.power(2); // ^2
        System.out.println(cal.getResult());
        cal.clear(); // =0
        System.out.println(cal.getResult());
    }
}