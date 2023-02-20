package SetsAndMapsAdvanced.Exercises;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,Long>> mapA = new LinkedHashMap<>();
        Map<String, Long> mapPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("report")){
            String country = input.split("\\|")[1];
            String city = input.split("\\|")[0];
            long population = Integer.parseInt(input.split("\\|")[2]);

            if(!mapA.containsKey(country)){
                mapA.put(country, new LinkedHashMap<>());
                mapA.get(country).put(city,population);
            }else{
                if(!mapA.get(country).containsKey(city)){
                    mapA.get(country).put(city, population);
                }
            }
            if(!mapPopulation.containsKey(country)){
                mapPopulation.put(country, population);
            }else{
                long current = mapPopulation.get(country);
                mapPopulation.put(country, current + population);
            }


            input = scanner.nextLine();
        }


        mapPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed())
                .forEach(currentCountry -> {
                    System.out.printf("%s (total population: %d)%n",
                            currentCountry.getKey(), currentCountry.getValue());

                    mapA.get(currentCountry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed())
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });

    }
}
