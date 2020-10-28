import java.util.Random;
import java.util.Scanner;

// 3.1 书7.35（猜字游戏）

public class p1WordGuess {
    // 定义一个字符串数组
    // Add any words you wish in this array
    public static String[] words = { "life", "is", "is", "short", "I", "use", "Python" };
    // 随机获取一个单词
    public static String word;
    // 创建一个状态数组进行判断
    public static boolean[] status;
    // 定义一个输错的次数
    public static int mistakes = 0;

    public static void main(String[] agre) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        word = words[rand.nextInt(words.length)]; // 随机抽取字符串
        status = new boolean[word.length()];
        // 判断用户是否猜对输入其中的一个字符
        while (true) {
            String password = guessPass(); // 获取现在的状态
            System.out.print("(Guess)Enter a letter in word " + password + " > ");
            String thisGuess = scan.nextLine(); // 把用户猜测的单词放入letter进行判断
            changeWord(thisGuess); // 通过thisGuess，判断是否改变现有状态
            if (isEnd()) {
                // 显示猜错的次数
                System.out.println("The word is " + word + " . You missed " + mistakes + " times");
                // 询问用户是否继续对另外一个单词进行游戏
                System.out.println("Do you want to guess another word? Enter y or n>");
                if (scan.nextLine().equals("y")) { // 判断是否要重新来一局
                    // 随机获取一个单词
                    word = words[rand.nextInt(words.length)];
                    // 创建一个状态数组进行判断
                    status = new boolean[word.length()];
                    // 定义一个输错的次数
                    mistakes = 0;
                } else {
                    break;
                }
            }
        }
    }

    /** 获取当前状态的函数 */
    public static String guessPass() {
        String password = "";
        for (int i = 0; i < word.length(); i++) { // 依次遍历判断状态，并进行是否显示
            // 若为true则为已经显示的密码，若为false则为没有显示的密码
            if (status[i] == true) {
                password += word.charAt(i);
            } else {
                password += "*";
            }
        }
        return password;
    }

    /** 判断是否改变状态 */
    public static void changeWord(String letter) {
        // 拿到输入单词，遍历当前状态，判断是否存在
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) + "").equals(letter)) {
                flag = true;
                if (status[i] == false) {
                    status[i] = true;
                } else {
                    System.out.println("\t" + letter + " is already in the word"); // 提示用户已经猜过一次，但是不增加猜错的次数
                    return;
                }
            }
        }
        if (!flag) {
            mistakes++; // 增加猜错的次数，并提示
            System.out.println("\t" + letter + " is not in the word");
        }
    }

    /** 进行终止条件的判断 */
    public static boolean isEnd() {
        // 依次遍历，若均为true，则猜测完毕
        for (int i = 0; i < status.length; i++) {
            if (status[i] == false) {
                return false;
            }
        }
        return true;
    }
}