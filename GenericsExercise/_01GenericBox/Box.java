package GenericsExercise._01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box <E> {
    private List<E> box = new ArrayList<>();

    public void addToBox(E input){
        box.add(input);
    }
    @Override
    public String toString(){
       StringBuilder stringBuilder = new StringBuilder();
        for (E e : box) {
            stringBuilder.append(String.format("%s: %s\n",e.getClass().getName(),e));
        }
        return stringBuilder.toString();
    }
}
