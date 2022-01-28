package day04;

import java.util.Map;
import java.util.TreeMap;

public class CharCounter {

    public Map<Character, Integer> countCharsWithIf(String s) {
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : s.toCharArray()) {
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }

    public Map<Character, Integer> countCharsWithCompute(String s) {
        Map<Character, Integer> result = new TreeMap<>();
        for (char c : s.toCharArray()) {
            result.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        return result;
    }
}
