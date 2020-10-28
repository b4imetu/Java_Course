// 3.3 书8.35（最大块）

import java.util.Scanner;

public class p3FindLargestBlock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        // 输入二维数组行数
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix row by row:");
        // 一行一行输入二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        // printArr(matrix); // 打印
        int[] Answer = findLargestBlock(matrix);
        System.out.print("The maximum square is at (" + Answer[0] + " , " + Answer[1] + ") with size " + Answer[2]);
        scan.close();
    }

    /** 打印int二维数组 */
    private static void printArr(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
            // 另一种打印方法
            // System.out.println(Arrays.toString(nums[i]));
        }
    }

    /**
     * 寻找最大块方法。返回值是一个包含三个值的数组
     * 
     * @param m       输入二维数组
     * @param 返回值前2个值 子方阵中的行和列的下标
     * @param 返回值第3个值 子方阵中的行数
     */
    public static int[] findLargestBlock(int[][] m) {
        int n = m.length;
        int[] ans = { 0, 0, 0 };
        // 寻找最大块，遍历所有元素
        // num递增，为最终子方阵中的行数
        for (int num = 1; num <= n; num++) {
            for (int i = 0; i <= n - num; i++) {
                for (int j = 0; j <= n - num; j++) {
                    boolean isOne = true;
                    // 判断是否全为1
                    for (int a = i; a < i + num && isOne; a++) {
                        for (int b = j; b < j + num && isOne; b++) {
                            if (m[a][b] == 0)
                                // 不全为1
                                isOne = false;
                        }
                    }
                    if (isOne && num > ans[2]) { // 如果全为1
                        ans[0] = i;
                        ans[1] = j;
                        ans[2] = num;
                    }
                }
            }
        }
        return ans;
    }
}