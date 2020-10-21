// 2.2 100以内加减法进位退位Quiz程序

import java.util.*;

public class p2AddAndSubQuiz {
  static public int score = 0; // 定义全局变量纪录分数；

  public static void main(String[] args) {

    // Scanner scan = new Scanner(System.in);
    // System.out.println("请输入：「输入!end以结束程序」");

    Random rand = new Random(); // 新建一个Random的对象
    int num1;
    int num2;
    boolean isAdd; // 随机加减法

    int QuesAmount = 5; // 设置题量=5
    while (QuesAmount > 0) {
      num1 = rand.nextInt(100); // 100以内随机整数
      num2 = rand.nextInt(100);
      if (num1 + num2 < 100) {
        QuesAmount--; // 题数-1
        isAdd = rand.nextBoolean(); // 随机加减法
        if (isAdd)
          add(num1, num2); // 调用加法
        else
          sub(num1, num2); // 调用减法
      }
    }
    System.out.println("Congratulation! Your final score is " + score);
  }

  public static void add(int number1, int number2) {
    Scanner input = new Scanner(System.in);

    System.out.println("What is " + number1 + " + " + number2 + "? ");

    int answer = input.nextInt();

    if (number1 + number2 == answer) {
      System.out.println("You are correct!");
      score += 20; // 答对加20分
    } else {
      System.out.print("Your answer is wrong. ");
      System.out.println(number1 + " + " + number2 + " should be " + (number1 + number2));
    }
    // input.close();
  }

  public static void sub(int number1, int number2) {
    // 减法
    // 2. If number1 < number2, swap number1 with number2
    if (number1 < number2) {
      int temp = number1;
      number1 = number2;
      number2 = temp;
    }

    // 3. Prompt the student to answer what is number1 number2?
    System.out.println("What is " + number1 + " - " + number2 + "? ");
    Scanner input = new Scanner(System.in);
    int answer = input.nextInt();

    // 4. Grade the answer and display the result
    if (number1 - number2 == answer) {
      System.out.println("You are correct!");
      score += 20; // 答对加20分
    } else {
      System.out.print("Your answer is wrong. ");
      System.out.println(number1 + " - " + number2 + " should be " + (number1 - number2));
    }
    // input.close();
  }
}