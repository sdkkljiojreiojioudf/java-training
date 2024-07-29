import org.example.dp.KnapsackFullSum;
import org.example.records.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KnapsackFullSumTest {
    // example. the maximum weight is 1000g
    // we have banana 200g, apple 300g, orange 400g, watermelon 500g, pineapple 650g, mango 750g
    // most optimal is watermelon 500g, apple 300g, banana 200g => 1000g
    @Test
    public void simpleTest() {
        Fruit banana = new Fruit("banana", 200);
        Fruit apple = new Fruit("apple", 300);
        Fruit orange = new Fruit("orange", 400);
        Fruit watermelon = new Fruit("watermelon", 500);
        Fruit pineapple = new Fruit("pineapple", 650);
        Fruit mango = new Fruit("mango", 750);

        List<Fruit> items = List.of(banana, apple, orange, watermelon, pineapple, mango);
        List<Fruit> result = KnapsackFullSum.getItemsMaximumWeight(1000, items);
        Assertions.assertEquals(3, result.size());
    }
}
