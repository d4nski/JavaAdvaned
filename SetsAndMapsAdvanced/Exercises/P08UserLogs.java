package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> mapA = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String name = input.split("\\s+")[2].split("=")[1];
            if (!mapA.containsKey(name)) {
                mapA.put(name, new LinkedHashMap<>());
                mapA.get(name).put(ip, 1);

            } else {
                if (!mapA.get(name).containsKey(ip)) {
                    mapA.get(name).put(ip, 1);
                } else {
                    int current = mapA.get(name).get(ip);
                    mapA.get(name).put(ip, 1 + current);

                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : mapA.entrySet()) {
            System.out.println(entry.getKey() + ":");
            Map<String, Integer> dada = new LinkedHashMap<>();
            dada = entry.getValue();
            int count = entry.getValue().size();
            for (String s : dada.keySet()) {
                if (count != 1) {
                    System.out.print(s + " => " + dada.get(s) + "," + " ");

                } else {
                    System.out.print(s + " => " + dada.get(s) + "." + " ");

                }
                count--;
            }
            System.out.println();
        }
    }
}
