package day04;

import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    private PairFinder() {
    }

    public static int countPairs(int... numbers) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        for (int number : numbers) {
            if (!pairs.containsKey(number)) {
                pairs.put(number, 1);
            } else {
                pairs.put(number, pairs.get(number) + 1);
            }
        }
        return pairs.values().stream()
                .mapToInt(i -> i / 2)
                .sum();
    }
}
