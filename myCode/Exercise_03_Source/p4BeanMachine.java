// 3.4 书7.37（游戏：豆机）

// The bean machine, also known as the Galton Board or quincunx, is a device invented by Sir Francis Galton.

import java.util.Arrays;
import java.util.Scanner;

public class p4BeanMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        // 输入球的数量
        int ballsNum = scan.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        // 输入槽的数量
        int slotsNum = scan.nextInt();
        // 定义数组slots中的每个元素存储的是一个槽中球的个数
        int[] slots = new int[slotsNum];
        for (int i = 0; i < ballsNum; i++)
            // 发生碰撞，并打印每个球的碰撞情况
            collision(slotsNum, slots);
        // 打印球的分布情况图
        for (int i = max(slots); i >= 1; i--) {
            for (int j = 0; j < slotsNum; j++) {
                if (slots[j] < i)
                    System.out.print(" ");
                else
                    System.out.print("0");
            }
            System.out.print('\n');
        }
        // 打印所有slots（以S为标记）
        for (int i = 0; i < slotsNum; i++) {
            System.out.print("S");
        }
        scan.close();
    }

    /**
     * 球每次碰到钉子的碰撞情况，并打印
     * 
     * @param slotsNum 输入槽的数量
     * @param slots    每个槽中球的个数
     */
    public static void collision(int slotsNum, int[] slots) {
        // 定义球向右的偏移量
        double toRight = 0;
        // 打印每个球的碰撞轨迹
        for (int i = 0; i < slotsNum - 1; i++) {
            // 观察可知：球的碰撞路径次数 = 槽的个数 - 1
            // 50%的机会落下右边
            if (Math.random() > 0.5) {
                toRight += 0.5;
                System.out.print('R');
            } // 50%的机会落下左边
            else {
                toRight -= 0.5;
                System.out.print('L');
            }
        }
        System.out.print('\n');
        // 判定「落入槽的标号」与「偏移量」的关系，增加相应槽内的球数
        // 如果槽的数量是单数
        if (slotsNum % 2 == 1)
            slots[(int) (slotsNum / 2 + toRight)]++; // 抹去小数
        else { // 如果槽的数量是双数
            if (toRight > 0)
                slots[(int) (slotsNum / 2 - 0.5 + toRight)]++;
            else
                slots[(int) (slotsNum / 2 + toRight)]++;
        }
    }

    /**
     * 找出数组中最大元素
     * 
     * @param arr 输入的数组
     */
    public static int max(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}