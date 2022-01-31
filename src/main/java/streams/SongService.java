package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongService {

    private List<Song> songs=new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
    }
    public Optional<Song> shortestSong(){
       return songs
                .stream()
               .min(Comparator.comparing(Song::getLength));
    }

    public List<Song> findSongByTitle(String title){
        return songs.stream().filter(song->song.getTitle().equals(title)).collect(Collectors.toList());
    }

    public boolean isPerformerInSong(Song song,String performer){
        return song.getPerformers().stream().anyMatch(p->p.contains(performer));
    }

    public List<String> titlesBeforeDate(LocalDate date){
        return songs.stream().filter(song->song.getRelease().isBefore(date))
                .map(i->i.getTitle()).collect(Collectors.toList());
    }
}
