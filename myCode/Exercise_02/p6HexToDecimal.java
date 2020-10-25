// 2.6 写程序将键盘输入的16进制数转化为10进制数，并输出到屏幕上
// Part 1
// 转化算法作为某个类的静态方法函数提供

import java.util.*;

public class p6HexToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("HEX转DEC运算，请输入一个十六进制数:");
        String x = scan.next();
        p6HexToDecTransform.hex2DecFun(x);
        // 转化算法——作为静态方法函数提供
        scan.close();
    }
}