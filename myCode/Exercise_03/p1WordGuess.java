// 3.1 书7.35（猜字游戏）

// （主函数）解题思路：
// 1.创建随机猜测的字符串数组
// 2.随机抽取字符串，用户进行猜测
// 3.判断用户是否猜对其中的一个字符
// 创建状态数组 0 1
// 判断是否猜对，或者重复猜测
// 若是第一次猜对————改变其值；
// 若是第二次猜对————提示用户已经猜过一次，但是不增加猜错的次数；
// 若是没有猜对————提示猜过，并且增加猜错的次数
// 4.判断用户是否猜对（完），进行终止条件的判断，并进行下一次猜测

// 该函数中一个主函数main，调用了三个函数
// 1.public static String Guesspassword()【获取当前状态】
// 依次遍历状态函数，若为true则为已经显示的密码，若为false则为没有显示的密码
// 2.public static void changeword(String letter)【判断是否改变当前现状】
// 注意该函数因为有三种情况，有三种返回值，但是由于一个函数只能返回一个值，所以运用void，把输出语句写在函数里
// 3.public static boolean TheEnd()【判断是否终止】
// 依次遍历状态函数，看其是否均为true，若全为true则结束猜测

import java.util.*;

public class p1WordGuess {
    // 定义一个字符串数组
    // Add any words you wish in this array
    public static String[] words = { "write", "that", "code", "in", "your", "dream" };
    // 随机获取一个单词
    public static String word = null;
    // 创建一个状态数组进行判断
    public static boolean[] sta = null;
    // 定义一个输错的次数
    public static int missed = 0;

    public static void main(String[] agre) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        word = words[rand.nextInt(words.length)];
        sta = new boolean[word.length()];
        // 用户输入字母，判断是否猜对
        while (true) {
            String password = Guesspassword(); // 获取现在的状态
            System.out.print("(Guess)Enter a letter in word " + password + " > ");
            String letter = scan.nextLine(); // 把用户猜测的单词放入letter进行判断
            changeword(letter); // 通过letter，判断是否改变现有状态
            if (TheEnd()) {
                System.out.println("The word is " + word + " . You missed " + missed + " times");
                System.out.println("Do you want to guess another word? Enter y or n>");
                if (scan.nextLine().equals("y")) { // 判断是否要重新来一局
                    // 随机获取一个单词
                    word = words[rand.nextInt(words.length)];
                    // 创建一个状态数组进行判断
                    sta = new boolean[word.length()];
                    // 定义一个输错的次数
                    missed = 0;
                } else {
                    break;
                }
            }
        }
    }

    // 获取当前状态的函数
    public static String Guesspassword() {
        String password = "";
        for (int i = 0; i < word.length(); i++) { // 依次遍历判断状态，并进行是否显示
            if (sta[i] == true) {
                password += word.charAt(i);
            } else {
                password += "*";
            }
        }
        return password;
    }

    // 判断是否改变状态
    public static void changeword(String letter) {
        // 拿到输入单词，遍历当前状态，判断是否存在
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) + "").equals(letter)) {
                flag = true;
                if (sta[i] == false) {
                    sta[i] = true;
                } else {
                    System.out.println("\t" + letter + " is already in the word");
                    return;
                }
            }
        }
        if (!flag) {
            missed++;
            System.out.println("\t" + letter + " is not in the word");
        }
    }

    // 判断是否终止，是否猜完
    public static boolean TheEnd() {
        // 依次遍历，若均为true，则猜测完毕
        for (int i = 0; i < sta.length; i++) {
            if (sta[i] == false) {
                return false;
            }
        }
        return true;
    }
}