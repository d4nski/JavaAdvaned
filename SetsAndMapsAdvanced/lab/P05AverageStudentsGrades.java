package SetsAndMapsAdvanced.lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> mapa = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!mapa.containsKey(name)) {
                mapa.put(name, new ArrayList<>());

            }
            mapa.get(name).add(grade);

        }
        for (Map.Entry<String, List<Double>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double sum = 0;
            int length = entry.getValue().size();
            for (Double dada : entry.getValue()) {
                sum += dada;
                String toString = dada + "";
                if (toString.length() < 4) {
                    toString += "0";
                }
                System.out.print(toString.replaceAll("[\\[\\],]", "") + " ");
            }
            System.out.printf("(avg: %.2f)\n", sum / length);
        }
    }
}
