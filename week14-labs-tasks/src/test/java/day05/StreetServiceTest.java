package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StreetServiceTest {

    StreetService streetService = new StreetService(Path.of("src/test/resources/streets.txt"));

    @Test
    void testGetHousesSold() {
        Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("Kossuth", List.of(2,4,1,3,5,7));
        expected.put("Petofi", List.of(1,2,4,3,6));
        assertEquals(expected, streetService.getHousesSold());
    }

    @Test
    void testGetTotalSoldByStreetNameAndSide() {
        assertEquals(4, streetService.getTotalSoldByStreetNameAndSide("Kossuth", false));
        assertEquals(2, streetService.getTotalSoldByStreetNameAndSide("Kossuth", true));
        assertEquals(2, streetService.getTotalSoldByStreetNameAndSide("Petofi", false));
        assertEquals(3, streetService.getTotalSoldByStreetNameAndSide("Petofi", true));
    }

    @Test
    void testGetTotalSoldByStreetNameAndSideInvalidStreetName() {
        assertThrows(NoSuchElementException.class, () -> streetService.getTotalSoldByStreetNameAndSide("Kossuth_", false));
    }
}
