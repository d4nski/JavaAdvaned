package MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n ; i++) {
            String[] readLine = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(readLine[j]);
                matrix[i][j] = num;
            }
        }
int sumFirst = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
               if(i == j){
                   sumFirst += matrix[i][j];
               }
            }
        }

        int sumSecond = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i + j == n-1){
                    sumSecond += matrix[i][j];
                }
            }
        }
        System.out.println(Math.abs(sumSecond - sumFirst));
    }

}
