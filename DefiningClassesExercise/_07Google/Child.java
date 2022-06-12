package DefiningClassesExercise._07Google;

public class Child {
    private String name;
    private String birthdate;

    public Child (String name,String birthdate){
        setName(name);
        setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    @Override
    public String toString(){
        return String.format("%s %s",name,birthdate);
    }
}
