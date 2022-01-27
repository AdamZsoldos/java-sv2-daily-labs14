package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testCountPairs() {
        assertEquals(1, PairFinder.countPairs(5, 1, 4, 5, 5));
        assertEquals(4, PairFinder.countPairs(7, 1, 5, 7, 3, 3, 5, 7, 6, 7));
    }
}
