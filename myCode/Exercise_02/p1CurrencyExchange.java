// 2.1 金融：货币兑换

import java.util.Scanner;

public class p1CurrencyExchange {
    public static void main(String[] args) {

        double exchangeRate = 0; // 初始化为0
        // 输入兑换汇率
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the exchange rate from do1lars to RMB: ");
        if (scan.hasNext()) {
            exchangeRate = scan.nextDouble();
        } else
            System.out.println("Invalid Input");

        String strCurrency; // 持有货币类型
        boolean isUSD2CNY = true; // 初始化为true

        // 输入兑换目标货币
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        if (scan.hasNext()) {
            int input = scan.nextInt();
            isUSD2CNY = (input == 0) ? true : false; // 如果输入0则为USD转CNY
        } else
            System.out.println("Invalid Input");

        if (isUSD2CNY) { // 如果输入USD转CNY
            strCurrency = "dollar";
        } else {
            strCurrency = "RMB";
        }

        double targetNum; // 输出的数额
        // 输入兑换数额
        System.out.print("Enter the " + strCurrency + " amount: ");
        double sourceNmu = scan.nextDouble();
        // 控制输出格式 小数位数
        if (isUSD2CNY) { // 如果输入USD转CNY
            targetNum = sourceNmu * exchangeRate;
            System.out.println("$" + sourceNmu + " is " + String.format("%.2f", targetNum) + " yuan");
        } else {
            targetNum = sourceNmu / exchangeRate;
            System.out.println(sourceNmu + " yuan is $" + String.format("%.2f", targetNum));
        }
        scan.close();
        System.out.println("「转换结束」");
    }
}