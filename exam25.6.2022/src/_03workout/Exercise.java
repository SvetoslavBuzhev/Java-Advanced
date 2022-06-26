package _03workout;

public class Exercise {
    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise(String name,String muscle,int burnedCalories){
        this.name=name;
        this.muscle=muscle;
        this.burnedCalories=burnedCalories;
    }
    public String getName() {
        return name;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public String toString(){
        return String.format("Exercise: %s, %s, %d",getName(),getMuscle(),getBurnedCalories());
    }
}
