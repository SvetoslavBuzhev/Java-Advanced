package DefiningClassesExercise._06PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        setName(name);
        setElement(element);
        setHealth(health);
    }
    public void reduceHP(){
        health-=10;
    }
    public static boolean isDead(Pokemon currentPokemon){
        return currentPokemon.health >0;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public String getName() {
        return name;
    }
}
