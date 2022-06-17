package _06GenericCountMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Count<E extends Comparable<E>> {
    private List<E> values;

    public Count(){
        values = new ArrayList<>();
    }

    public void addMethods (E element){
        values.add(element);
    }
    public List<E> countGreaterItems(E element){
        return values.stream().filter(x->x.compareTo(element)>0).collect(Collectors.toList());
    }
}
