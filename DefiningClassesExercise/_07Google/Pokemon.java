package DefiningClassesExercise._07Google;

public class Pokemon {
    private String name;
    private String element;

    public Pokemon(String name,String element){
        setName(name);
        setElement(element);
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElement(String element) {
        this.element = element;
    }
    @Override
    public String toString(){
        return String.format("%s %s",name,element);
    }
}
