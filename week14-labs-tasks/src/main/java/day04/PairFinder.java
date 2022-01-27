package day04;

import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    private PairFinder() {
    }

    public static int countPairs(int... numbers) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        for (int number : numbers) {
            pairs.compute(number, (k, v) -> v == null ? 1 : v + 1);
        }
        return pairs.values().stream()
                .mapToInt(i -> i / 2)
                .sum();
    }
}
