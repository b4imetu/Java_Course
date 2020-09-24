package myCode.ch02;

public class Calculator {
    private static int result; // 静态变量，用于存储运行结果

    public void add(int n) {
        result = result + n;
    }

    public void substract(int n) {
        result = result - n;
    }

    public void multiply(int n) {
        result = result * n;
    }

    public void divide(int n) {
        result = result / n;
    }

    public void square() {
        result = result * result;
    }

    public void power(int n) {
        result = (int) Math.pow(result, n);

    }

    public void clear() { // 将结果清零
        result = 0;
    }

    public int getResult() {
        return result;
    }
}