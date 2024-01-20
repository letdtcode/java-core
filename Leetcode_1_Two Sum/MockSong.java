import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 30/12/2023
 * Time      : 6:20 CH
 * Filename  : MockSong
 */
public class MockSong {
    public static List<Song> getSongsV2() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("somersault", "zero 7", 147));
        songs.add(new Song("cassidy", "grateful dead", 158));
        songs.add(new Song("$10", "hitchhiker", 140));
        songs.add(new Song("havana", "cabello", 105));
        songs.add(new Song("Cassidy", "grateful dead", 158));
        songs.add(new Song("50 ways", "simon", 102));
        return songs;
    }
}
