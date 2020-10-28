// 2.3 判断一个字符串是否回文字符串，及"mom","noon"

import java.util.Scanner;

public class p3CheckPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个字符串：「输入!end以结束程序」");
        while (!scan.hasNext("!end")) {
            String data = scan.next();
            if (isPalindrome(data)) {
                System.out.println("是回文字符串");
            } else {
                System.out.println("不是回文字符串");
            }
        }
        System.out.println("「程序结束」");
        scan.close();
    }

    // 判断是否回文字符串
    public static boolean isPalindrome(String data) {
        int len = data.length();
        for (int i = 0; i < len / 2; i++) {
            if (data.charAt(i) != data.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}