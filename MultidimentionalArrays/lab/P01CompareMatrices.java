package MultidimentionalArrays.lab;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputOne = scanner.nextLine().split("\\s+");
        int rowsOne = Integer.parseInt(inputOne[0]);
        int colsOne = Integer.parseInt(inputOne[1]);
        int[][] matrixOne = new int[rowsOne][colsOne];

        for (int i = 0; i < rowsOne; i++) {
            String[] coming = scanner.nextLine().split("\\s+");
            for (int j = 0; j < colsOne; j++) {
                matrixOne[i][j] = Integer.parseInt(coming[j]);
            }
        }
        boolean isEqual = true;
        String[] inputTwo = scanner.nextLine().split("\\s+");
        int rowsTwo = Integer.parseInt(inputTwo[0]);
        int colsTwo = Integer.parseInt(inputTwo[1]);
        int[][] matrixTwo = new int[rowsTwo][colsTwo];
        if (rowsOne != rowsTwo || colsOne != colsTwo) {
            isEqual = false;
        } else {

            for (int i = 0; i < rowsTwo; i++) {
                String[] comingTwo = scanner.nextLine().split("\\s+");
                for (int j = 0; j < colsTwo; j++) {
                    matrixTwo[i][j] = Integer.parseInt(comingTwo[j]);
                    if (matrixTwo[i][j] != matrixOne[i][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
        }
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
