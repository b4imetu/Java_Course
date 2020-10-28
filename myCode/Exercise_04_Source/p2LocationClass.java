// 4.2 9.13（位置类Location）

import java.util.Scanner;

class Location {
    public int row; // int型 下标row
    public int column; // int型 下标column
    public double maxValue; // double型 最大值maxValue
    // **默认Location构造 */

    Location() {
        row = 0;
        column = 0;
        // maxValue = 0;
    }
}

public class p2LocationClass {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows and columns in the array: ");
        Scanner scan = new Scanner(System.in);
        // 输入行数、列数
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        double[][] matrix = new double[rows][columns];
        System.out.println("Enter the array: ");
        // 输入二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                matrix[i][j] = scan.nextDouble();
        }
        // 定位二维数组中的最大值及其位置
        Location someWhereBig = locationLargest(matrix);
        System.out.println("The location of the largest element is " + someWhereBig.maxValue + " at ("
                + someWhereBig.row + ", " + someWhereBig.column + ")");
        scan.close();
    }

    // **定位二维数组中的最大值及其位置 */
    public static Location locationLargest(double[][] a) {
        Location someWhere = new Location();
        someWhere.maxValue = a[0][0];
        // 遍历，比较，寻找最大值
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] > someWhere.maxValue) {
                    someWhere.row = i;
                    someWhere.maxValue = a[i][j];
                    someWhere.column = j;
                }
            }
        }
        return someWhere;
    }
}