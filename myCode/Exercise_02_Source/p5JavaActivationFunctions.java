// 2.5 自己调研深度神经网络的几种激活函数（Activation Functions）并用java实现

import java.util.Scanner;

public class p5JavaActivationFunctions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            double input = scan.nextDouble();
            System.out.println("Sigmoid(" + input + ") = " + Sigmoid(input));
        }
        System.out.println("~此处仅测试Sigmoid，其他函数省略~");
        scan.close();
    }

    public static double Sigmoid(double x_in) {
        // $S(x)=\frac{1}{1+e^{-x}}$
        double output = 1 / (1 + Math.pow(Math.E, -x_in));
        return output;
    }

    public static double Tanh(double x_in) {
        // $\tanh x=\frac{\sinh x}{\cosh x}=\frac{e^x-e^{-x}}{e^x+e^{-x}}$
        double output = (Math.exp(x_in) - Math.exp(-x_in)) / (Math.exp(x_in) + Math.exp(-x_in));
        return output;
    }

    public static double ReLU(double x_in) {
        // $f(x)=max(0,x)$
        double output = Math.max(0, x_in);
        return output;
    }

    public static double Leaky_ReLU(double x_in) {
        double lambda = 0.1; // 定义 λ=0.1
        double output = (x_in > 0) ? x_in : x_in * lambda; // 三目运算符
        return output;
    }

    public static double Swish(double x_in) {
        // Swish, which is simply f(x) = x·sigmoid(x)
        return x_in * Sigmoid(x_in);
    }
}