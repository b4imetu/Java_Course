// 3.2 书8.27（列排序）

import java.util.*;

public class p2SortColumns {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[i].length; i++) {
                matrix[i][j] = scan.nextDouble();
            }
        }
        System.out.println("Enter a 3-by-3 matrix row by row:");

        System.out.println("The column-sorted array is");

    }

    public static double[][] sortColumns(double[][] m) {
        return m;
    }
}
