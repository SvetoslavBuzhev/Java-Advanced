package _03workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new LinkedList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise toRemove = null;
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                toRemove = ex;
                break;
            }
        }
        if (exercises.size()!=0&&toRemove!=null){
            exercises.remove(toRemove);
            return true;
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise ex : exercises) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                return ex;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
       return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Workout type: ").append(type).append("\n");
        for (Exercise ex :
                exercises) {
            stringBuilder.append(ex).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}

