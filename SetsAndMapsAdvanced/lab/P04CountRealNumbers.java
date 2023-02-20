package SetsAndMapsAdvanced.lab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> mapa = new LinkedHashMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            double currentNum = inputArr[i];
            if (mapa.containsKey(currentNum)) {
                int currentCount = mapa.get(currentNum);
                mapa.put(currentNum, currentCount + 1);
            } else {
                mapa.put(currentNum, 1);
            }
        }
        for (Double aDouble : mapa.keySet()) {
            System.out.printf("%.1f -> %d\n", aDouble, mapa.get(aDouble));
        }
    }
}
