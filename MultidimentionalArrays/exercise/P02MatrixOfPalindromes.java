package MultidimentionalArrays.exercise;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            char symbol = (char) ('a' + i);
            for (int j = 0; j < cols; j++) {
                char currentSymbol = (char) (symbol + j);
                matrix[i][j] = ""+symbol + currentSymbol + symbol;
            }

        }
        printMatrix(rows, cols, matrix);

    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
