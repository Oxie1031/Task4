import java.util.*;
import java.util.stream.*;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 10));
        fruits.add(new Fruit("Banana", 20));
        fruits.add(new Fruit("Orange", 30));
        fruits.add(new Fruit("Peach", 40));
        fruits.add(new Fruit("Melon", 50));

        // とりあえず全部print
        System.out.println("Original list:");
        fruits.forEach(fruit -> System.out.println("Fruit: " + fruit.getName() + ", Count: " + fruit.getCount()));

        // 25以上のitemをprint
        System.out.println("\nFiltered list (count more than 25):");
        fruits.stream()
                .filter(fruit -> fruit.getCount() > 25)
                .forEach(fruit -> System.out.println("Fruit: " + fruit.getName() + ", Count: " + fruit.getCount()));

        // streamを用いた平均の算出
        OptionalDouble average = fruits.stream()
                .mapToInt(Fruit::getCount)
                .average();

        //一応nullチェック
        if (average.isPresent()) {
            System.out.println("\nAverage count: " + average.getAsDouble());
        } else {
            System.out.println("\nAverage cannot be calculated.");
        }

        // streamを用いた合計の算出
        int sum = fruits.stream()
                .mapToInt(Fruit::getCount)
                .sum();

        System.out.println("\nSum count: " + sum);
    }
}

