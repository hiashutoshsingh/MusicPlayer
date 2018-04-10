package music.geet.com.SongsList;

import android.graphics.Bitmap;

public class SongsModel {
    private String Song_name;
    private String Artist_name;
    private Bitmap albumn_art;


    public SongsModel(String song_name, String artist_name, Bitmap albumn_art) {
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

    public Bitmap getAlbumn_art() {
        return albumn_art;
    }
}
