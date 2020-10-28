// 3.2 书8.27（列排序）

import java.util.Arrays;
import java.util.Scanner;

public class p2SortColumns {
    public static void main(String[] args) {
        System.out.println("Enter a 3-by-3 matrix row by row:");
        double[][] nums = initArray(3, 3); // 定义一个3*3的数组
        // printArr(nums); // 打印自身 #Debug
        System.out.println("The column-sorted array is:");
        double[][] sortedArr = sortColumns(nums);
        printArr(sortedArr); // 打印新的数组，并且原数组保持不变
    }

    /** 打印double二维数组 */
    private static void printArr(double[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.print("\n");
            // 另一种打印方法
            // System.out.println(Arrays.toString(nums[i]));
        }
    }

    /** 构造一个row * col的double二维数组 */
    private static double[][] initArray(int row, int col) {
        double[][] arr = new double[row][col];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scan.nextDouble();
            }
        }
        scan.close();
        return arr;
    }

    /** 通用的二维数组的列排序函数 */
    public static double[][] sortColumns(double[][] m) {
        double[][] sortedArr = m; // 定义排序后数组
        // Sort each colum.
        for (int col = 0; col < sortedArr[0].length; col++) {
            // Pull the column out.
            double[] thisCol = new double[sortedArr.length];
            for (int i = 0; i < sortedArr.length; i++) {
                thisCol[i] = sortedArr[i][col];
            }
            // Sort it.
            Arrays.sort(thisCol);
            // Push it back in.
            for (int i = 0; i < sortedArr.length; i++) {
                sortedArr[i][col] = thisCol[i];
            }
        }
        return sortedArr;
    }
}