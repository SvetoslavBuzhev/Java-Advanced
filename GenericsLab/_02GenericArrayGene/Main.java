package GenericArrayGene;

public class Main {
    public static void main(String[] args) {
       Integer[] arr = ArrayCreator.create(13,69);

        for (Integer in: arr) {
            System.out.println(in);
        }
        Integer[] arr2 = ArrayCreator.create(3,13);

        for (Integer in: arr2) {
            System.out.println(in);
        }
    }
}
