package streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Song {

    private String title;
    private int length;
    List<String> performers;
    LocalDate release;

    public Song(String title, int length, List<String> performers, LocalDate release) {
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.release = release;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public LocalDate getRelease() {
        return release;
    }
}
