package DefiningClassesExercise._06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, PokemonTrainer> pokemonTrainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] pokeInfo = input.split("\\s+");
            String trainerName = pokeInfo[0];
            String pokeName = pokeInfo[1];
            String pokeElement = pokeInfo[2];
            int pokeHP = Integer.parseInt(pokeInfo[3]);

            Pokemon currentPokemon = new Pokemon(pokeName, pokeElement, pokeHP);
            if (pokemonTrainers.containsKey(trainerName)) {
                pokemonTrainers.get(trainerName).addPokemon(currentPokemon);
            } else {
                PokemonTrainer currentTrainer = new PokemonTrainer(trainerName, currentPokemon);
                pokemonTrainers.put(trainerName, currentTrainer);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();

        while (!input.equals("End")) {

            switch (input) {
                case "Fire":
                    pokemonElement("Fire", pokemonTrainers);
                    break;
                case "Electricity":
                    pokemonElement("Electricity", pokemonTrainers);
                    break;
                case "Water":
                    pokemonElement("Water", pokemonTrainers);
                    break;
            }
            input = scan.nextLine();
        }
        if (!pokemonTrainers.isEmpty()) {
            pokemonTrainers
                    .values()
                    .stream()
                    .sorted((e1, e2) -> e2.getNumberOfBadges() - e1.getNumberOfBadges())
                    .forEach(System.out::println);
        }
    }

    public static void pokemonElement(String element, Map<String, PokemonTrainer> pokemonTrainers) {
        pokemonTrainers.forEach((key, value) -> {
            boolean hasElement = value.hasElement(element);
            if (hasElement && !value.pokemonList.isEmpty()) {
                value.gainBadge();
            } else {
                List<Pokemon> pokemonList = value.pokemonList;
                pokemonList
                        .forEach(Pokemon::reduceHP);
                value.pokemonList = pokemonList
                        .stream()
                        .filter(Pokemon::isDead)
                        .collect(Collectors.toList());
            }
        });
    }
}
