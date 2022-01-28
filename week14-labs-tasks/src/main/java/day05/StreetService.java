package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetService {

    private final Map<String, List<Integer>> housesSold = new HashMap<>();

    public StreetService(Path path) {
        readFile(path);
    }

    public Map<String, List<Integer>> getHousesSold() {
        return housesSold;
    }

    public int getTotalSoldByStreetAndSide(String streetName, boolean evenSide) {
        List<Integer> houses = housesSold.get(streetName);
        if (houses == null) throw new NoSuchElementException();
        return (int) houses.stream()
                .filter(i -> (i % 2 == 0) == evenSide)
                .count();
    }

    private void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                parseLine(reader.readLine());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void parseLine(String line) {
        String[] fields = line.split(" ");
        String streetName = fields[0];
        boolean even = "0".equals(fields[1]);
        addNextHouseSold(streetName, even);
    }

    private void addNextHouseSold(String streetName, boolean even) {
        List<Integer> houseNumbers = housesSold.computeIfAbsent(streetName, k -> new ArrayList<>());
        int houseNumber = houseNumbers.stream()
                .filter(i -> (i % 2 == 0) == even)
                .max(Comparator.naturalOrder())
                .orElse(even ? 0 : -1) + 2;
        houseNumbers.add(houseNumber);
    }
}
