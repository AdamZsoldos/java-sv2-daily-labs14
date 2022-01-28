package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    CharCounter charCounter = new CharCounter();
    Map<Character, Integer> expected = new TreeMap<>();

    @BeforeEach
    void setUp() {
        expected.put('a', 3);
        expected.put('l', 1);
        expected.put('m', 1);
        expected.put('f', 1);
    }

    @Test
    void testCountCharsWithIf() {
        assertEquals(expected, charCounter.countCharsWithIf("almafa"));
    }

    @Test
    void testCountCharsWithCompute() {
        assertEquals(expected, charCounter.countCharsWithCompute("almafa"));
    }
}
