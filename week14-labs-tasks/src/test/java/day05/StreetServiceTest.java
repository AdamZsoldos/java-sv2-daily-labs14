package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void testGetTotalSoldByStreetAndSide() {
        assertEquals(4, streetService.getTotalSoldByStreetAndSide("Kossuth", false));
        assertEquals(2, streetService.getTotalSoldByStreetAndSide("Kossuth", true));
        assertEquals(2, streetService.getTotalSoldByStreetAndSide("Petofi", false));
        assertEquals(3, streetService.getTotalSoldByStreetAndSide("Petofi", true));
    }
}
