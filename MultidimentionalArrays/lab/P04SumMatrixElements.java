package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] readLine = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(readLine[j]);
                sum += matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
