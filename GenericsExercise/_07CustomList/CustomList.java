package _07CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<E extends Comparable<E>> {
    private List<E> CustomList;

    public CustomList() {
        CustomList = new ArrayList<>();
    }

    public void Add(E element) {
        CustomList.add(element);
    }

    public void Remove(int index) {
        CustomList.remove(index);
    }

    public boolean Contains(E element) {
        for (E el : CustomList) {
            if (el.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void Swap(int index1, int index2) {
        E temp = CustomList.get(index1);
        CustomList.set(index1, CustomList.get(index2));
        CustomList.set(index2, temp);
    }

    public long Greater(E element) {
        return CustomList.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public void Max() {
        E element = Collections.max(CustomList);
        System.out.println(element);
    }

    public void Min() {
        E element = Collections.min(CustomList);
        System.out.println(element);
    }

    public void print() {
        System.out.println(CustomList.stream()
                .map(e -> String.format("%s", e))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
