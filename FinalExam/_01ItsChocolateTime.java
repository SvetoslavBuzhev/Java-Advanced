import java.util.*;
import java.util.stream.Collectors;

public class _01ItsChocolateTime {
    public static Map<String, Integer> chocolates = new TreeMap<>();

    public static void main(String[] args) {
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        Scanner scan = new Scanner(System.in);

        List<Double> milkQuantities = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> cacaoPowder = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        ArrayDeque<Double> milk = new ArrayDeque<>();
        initializeQueue(milkQuantities, milk);
        ArrayDeque<Double> cacao = new ArrayDeque<>();
        initialize(cacao, cacaoPowder);

        boolean jobFinished = false;

        while (!milk.isEmpty() && !cacao.isEmpty()) {
            double firstMilk = milk.poll();
            double lastCacao = cacao.pop();
            double percent = (lastCacao / (firstMilk + lastCacao)) * 100;
            if (percent == 100) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else if (percent == 50) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (percent == 30) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else {
                milk.offer(firstMilk+10);
            }

        }
        if (chocolates.get("Baking Chocolate")>=1 && chocolates.get("Dark Chocolate")>=1 &&
                chocolates.get("Milk Chocolate")>=1){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        System.out.println(chocolates
                .entrySet()
                .stream().filter(e->e.getValue()>0)
                .map(e->String.format("# %s --> %d",e.getKey(),e.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void initializeQueue(List<Double> cacaoPowder, ArrayDeque<Double> cacao) {
        for (Double cacaoQ : cacaoPowder) {
            cacao.offer(cacaoQ);
        }
    }

    private static void initialize(ArrayDeque<Double> milk, List<Double> milkQuantities) {
        for (Double milkQ : milkQuantities) {
            milk.push(milkQ);
        }
    }
}
