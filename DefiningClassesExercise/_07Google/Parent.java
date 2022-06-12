package DefiningClassesExercise._07Google;

public class Parent {
    private String name;
    private String parentBirthdate;

    public Parent (String name,String parentBirthdate){
        setName(name);
        setParentBirthdate(parentBirthdate);
    }

    public String getName() {
        return name;
    }

    public String getParentBirthdate() {
        return parentBirthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentBirthdate(String parentBirthdate) {
        this.parentBirthdate = parentBirthdate;
    }
    @Override
    public String toString(){
        return String.format("%s %s",name,parentBirthdate);
    }
}
