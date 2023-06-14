import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 30);
        items.put("Peach", 40);
        items.put("Melon", 50);

        // とりあえず全部print
        System.out.println("Original map:");
        items.forEach((k,v)->System.out.println("Item: " + k + ", Count: " + v));

        // 25以上のitemをprint
        System.out.println("\nFiltered map (count more than 25):");
        items.entrySet().stream()
                .filter(entry -> entry.getValue() > 25)
                .forEach(entry -> System.out.println("Item: " + entry.getKey() + ", Count: " + entry.getValue()));

        // streamを用いた平均の算出
        OptionalDouble average = items.values().stream()
                .mapToInt(Integer::intValue)
                .average();

        //一応nullチェック
        if (average.isPresent()) {
            System.out.println("\nAverage count: " + average.getAsDouble());
        } else {
            System.out.println("\nAverage cannot be calculated.");
        }

        // streamを用いた合計の算出
        int sum = items.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nSum count: " + sum);

    }
}

