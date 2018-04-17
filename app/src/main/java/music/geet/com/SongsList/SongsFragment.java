package music.geet.com.SongsList;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import music.geet.com.MainActivity;
import music.geet.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
    public RecyclerView songsrcv;
    public TextView songs_name, artist_name;
    public ImageView album_art;
    private SongsAdapter adapter;
    public List<SongsModel> list;


    public SongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_songs, container);
        songsrcv = v.findViewById(R.id.songslistRecycler);

        artist_name = (TextView) v.findViewById(R.id.artist_name);
        songs_name = (TextView) v.findViewById(R.id.song_name);
        album_art = (ImageView) v.findViewById(R.id.albumb_art);
        songsrcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        getMusic();
        adapter = new SongsAdapter(list, getContext());
        songsrcv.setAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public List getMusic() {

        Context applicationContext = MainActivity.getContextOfApplication();
        ContentResolver resolver = applicationContext.getContentResolver();
        Uri albumuri=MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songsCursor = resolver.query(uri, null, null, null, null);
        Cursor AlbumCursor=resolver.query(albumuri,null,null,null,null);

        if (songsCursor != null && songsCursor.moveToFirst()&&AlbumCursor !=null&&AlbumCursor.moveToFirst()) {
            int SongsIndex = songsCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int ArtistIndex = songsCursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST);
            int AlbumArtIndex = AlbumCursor.getColumnIndexOrThrow(MediaStore.Audio.Albums.ALBUM_ART);


            do {
                String currentSong_Name = songsCursor.getString(SongsIndex);
                String currentArtist_Name = songsCursor.getString(ArtistIndex);
                String currentAlbum_Art = AlbumCursor.getString(AlbumArtIndex);
                Bitmap bm=BitmapFactory.decodeFile(currentAlbum_Art);


                SongsModel model = new SongsModel(currentSong_Name, currentArtist_Name, bm);
                list.add(model);

            }
            while (songsCursor.moveToNext()&&AlbumCursor.moveToNext());
        }

        return list;


    }


}
