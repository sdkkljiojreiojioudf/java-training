package org.example.dp;

import org.example.records.Fruit;

import java.util.ArrayList;
import java.util.List;

public class KnapsackFullSum {


    // example. the maximum weight is 1000g
    // we have banana 200g, apple 300g, orange 400g, watermelon 500g, pineapple 650g, mango 750g
    // most optimal is watermelon 500g, apple 300g, banana 200g => 1000g
    public static List<Fruit> getItemsMaximumWeight(int maxWeight,
                                                    List<Fruit> items) {

        int[] dp = new int[maxWeight + 1];

        Fruit[] traceItems = new Fruit[maxWeight + 1];

        for (Fruit item : items) {
            int fruitW = item.weight();
            for (int treshold = maxWeight; treshold >= item.weight(); treshold--) {
                int withoutItem = dp[treshold];
                int withItem = dp[treshold - fruitW] + fruitW;
                if (withItem > withoutItem) {
                    dp[treshold] = withItem;
                    traceItems[treshold] = item;
                }
            }
        }

        List<Fruit> bestList = new ArrayList<>();
        int treshold = maxWeight;
        while (treshold > 0) {
            Fruit bestFruitAtThreshold = traceItems[treshold];
            treshold -= bestFruitAtThreshold.weight();
            bestList.add(bestFruitAtThreshold);
        }

        return bestList;
    }

}
