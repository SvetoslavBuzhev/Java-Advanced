package _05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Count<E extends Comparable<E>> {
    private List<E> values;

    public Count(){
        values = new ArrayList<>();
    }

    public void addMethods (E element){
        values.add(element);
    }
    public long countGreaterItems(E element){
        return values.stream().filter(itemOutside -> itemOutside.compareTo(element)>0).count();
    }
}
