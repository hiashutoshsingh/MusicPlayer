package music.geet.com.SongsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import music.geet.com.R;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {
    private List<SongsModel> songsList;
    private Context context;

    public SongsAdapter(List<SongsModel> songsList, Context context) {
        this.songsList = songsList;
        this.context = context;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.songsrow_model, parent, false);
        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        SongsModel model = songsList.get(position);
        holder.Songname.setText(model.getSong_name());
        holder.Artistname.setText(model.getArtist_name());
         holder.album_art.setImageResource(model.getAlbumn_art());

    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder {
        private TextView Songname, Artistname;
        private ImageView album_art;


        public SongsViewHolder(View itemView) {
            super(itemView);
            Songname = (TextView) itemView.findViewById(R.id.song_name);
            Artistname = (TextView) itemView.findViewById(R.id.artist_name);
            album_art=(ImageView) itemView.findViewById(R.id.albumb_art);
        }
    }
}
