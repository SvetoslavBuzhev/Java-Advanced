package SetsandMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class _07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfInputs = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continentMap = new LinkedHashMap<>();


        for (int i = 0; i < countOfInputs; i++) {
            String input = scan.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            continentMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentMap.get(continent).putIfAbsent(country,new ArrayList<>());
            continentMap.get(continent).get(country).add(city);


        }
        continentMap.entrySet()
                .stream()
                .forEach(continent->{
                    System.out.printf("%s:%n",continent.getKey()); //принтиране на всеки континент
                    continent.getValue()
                            .entrySet()
                            .forEach(country->{
                                System.out.printf("%s -> %s%n",country.getKey(),country.getValue()
                                        .stream()
                                        .map(e -> String.format("%s",e))
                                        .collect(Collectors.joining(", ")));
                            });
                });
    }
}
