import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
//导入必要的组件

public class p2EquationCramer {
    public static void Cramer22() {
        // 2*2的Cramer法则函数
        System.out.println("请按照顺序输入a、b、c、d、e、f的值：");
        // 3.4 50.2 2.1 0.55 44.5 5.9
        Scanner sn = new Scanner(System.in);
        try {
            // 读取双精度浮点数
            double a = sn.nextDouble();
            double b = sn.nextDouble();
            double c = sn.nextDouble();
            double d = sn.nextDouble();
            double e = sn.nextDouble();
            double f = sn.nextDouble();
            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - e * c) / (a * d - b * c);
            System.out.println("解得：\n" + "x=" + x + "\n" + "y=" + y);
        } catch (InputMismatchException err) {
            // 异常处理
            System.out.println("必须输入数值！");
        }
    }

    public static void main(String[] args) {
        // main
        System.out.println("求解2*2线性方程组，使用Cramer规则");
        Cramer22(); // 调用
    }
}