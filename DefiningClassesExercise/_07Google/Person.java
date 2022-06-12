package DefiningClassesExercise._07Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private Car car;

    public Person(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private List<Parent> parentList = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private List<Pokemon> pokemonList = new ArrayList<>();

    public void addParent(Parent parent) {
        parentList.add(parent);
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    @Override
    public String toString() {
        return this.name + "\n" +
                "Company: \n" +
                ((this.company == null) ? "" : this.company + "\n") +
                "Car:\n" +
                ((this.car == null) ? "" : this.car + "\n") +
                "Pokemon:\n" +
                ((this.pokemonList.isEmpty()) ? "" : this.pokemonList
                        .stream().map(Pokemon::toString).collect(Collectors.joining("\n")) + "\n") +
                "Parents: \n" +
                ((this.parentList.isEmpty()) ? "" : this.parentList
                        .stream().map(Parent::toString).collect(Collectors.joining("\n")) + "\n") +
                "Children: \n" +
                ((this.children.isEmpty()) ? "" : this.children
                        .stream().map(Child::toString).collect(Collectors.joining("\n")) + "\n");
    }
}
