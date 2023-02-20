package SetsAndMapsAdvanced.lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeMap<String, List<String>>> mapa = new TreeMap<>();

        for (int i = 0; i < 7 ; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            if(!mapa.containsKey(continent)){
                mapa.put(continent, new TreeMap<>())
                .put(country, new ArrayList<>())
                        .add(city);
            }else{
                if(!mapa.get(continent).containsKey(country)){
                    mapa.get(continent).put(country, new ArrayList<>()).add(city);
                }else{
                    mapa.get(continent).get(country).add(city);
                }
            }

        }
        for (Map.Entry<String, TreeMap<String, List<String>>> entry : mapa.entrySet()) {
            System.out.println(entry.getKey()+ ":");
            System.out.printf("%s -> ", entry.getValue());
            System.out.println(entry.getValue().get(entry.getValue()).toString().replaceAll("[\\[\\],]", ", "));
        }
    }
}
