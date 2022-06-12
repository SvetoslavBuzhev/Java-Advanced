package DefiningClassesExercise._06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;


public class PokemonTrainer {
    private String name;
    int numberOfBadges = 0;
    List<Pokemon> pokemonList = new ArrayList<>();


    public PokemonTrainer(String name, Pokemon currentPokemon) {
        setName(name);
        addPokemon(currentPokemon);
    }

    public boolean hasElement(String element) {
        return this.pokemonList.stream().anyMatch(s -> s.getElement().equals(element));
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPokemon(Pokemon currentPokemon) {
        pokemonList.add(currentPokemon);
    }

    public void isDying(Pokemon currentPokemon) {
        currentPokemon.reduceHP();
        pokemonList.removeIf(Pokemon::isDead);
    }

    public void gainBadge() {
        this.numberOfBadges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, numberOfBadges, pokemonList.size());
    }
}
