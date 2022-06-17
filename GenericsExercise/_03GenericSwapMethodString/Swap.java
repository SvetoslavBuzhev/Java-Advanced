package _03GenericSwapMethodString;


import java.util.List;

public class Swap<E> {
    private E element ;

    public Swap(E element){
        this.element = element;
    }
@Override
    public String toString(){
        return  element.getClass().getName() + ": " + element;
    }
    public static void swap(int first,int second, List<Swap> toSwap){
        Swap tempSwap = toSwap.get(first);
        toSwap.set(first,toSwap.get(second));
        toSwap.set(second,tempSwap);
    }
}
