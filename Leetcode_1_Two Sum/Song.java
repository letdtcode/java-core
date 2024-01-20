/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 30/12/2023
 * Time      : 6:11 CH
 * Filename  : Song
 */
public class Song {
    private String title;
    private String artist;
    private int bpm;

    Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
