package day02;

import java.util.List;

public class Movie {

    private final String title;
    private final int lengthInMinutes;
    private final List<String> actors;

    public Movie(String title, int lengthInMinutes, List<String> actors) {
        this.title = title;
        this.lengthInMinutes = lengthInMinutes;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public List<String> getActors() {
        return actors;
    }
}
