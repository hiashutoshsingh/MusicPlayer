package music.geet.com.SongsList;

public class SongsModel {
    private String Song_name;
    private String Artist_name;
    private int albumn_art;


    public SongsModel(String song_name, String artist_name, int albumn_art) {
        Song_name = song_name;
        Artist_name = artist_name;
        this.albumn_art = albumn_art;
    }

    public String getSong_name() {
        return Song_name;
    }

    public String getArtist_name() {
        return Artist_name;
    }

    public int getAlbumn_art() {
        return albumn_art;
    }
}
