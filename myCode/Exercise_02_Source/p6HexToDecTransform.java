// 2.6 写程序将键盘输入的16进制数转化为10进制数，并输出到屏幕上
// Part 2
// 转化算法——作为静态方法函数提供
public class p6HexToDecTransform {
    public static void hex2DecFun(String data_in) {
        int n;
        try {
            n = Integer.parseInt(data_in, 16); // 解析一个字符串，并返回一个整数
            // 输出16进制数data_in在十进制下的数
            System.out.println("转化为10进制数：" + n);
        } catch (Exception err) {
            err.printStackTrace();
            System.out.println(data_in + "不是一个有效的十六进制数");
            n = 0;
        }
    }
}