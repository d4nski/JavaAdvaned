package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] readLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        int counter = 0;
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(matrix[i][counter] + " ");
            counter++;
        }
    }
}
