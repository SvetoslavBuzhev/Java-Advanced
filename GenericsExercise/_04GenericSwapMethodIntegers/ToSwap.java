package _04GenericSwapMethodIntegers;

import java.util.List;

public class ToSwap<E> {
    private E element ;

    public ToSwap(E element){
        this.element = element;
    }
    @Override
    public String toString(){
        return  element.getClass().getName() + ": " + element;
    }
    public static void swap(int first,int second, List<ToSwap> toSwap){
        ToSwap tempSwap = toSwap.get(first);
        toSwap.set(first,toSwap.get(second));
        toSwap.set(second,tempSwap);
    }
}
