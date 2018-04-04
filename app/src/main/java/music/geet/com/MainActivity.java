package music.geet.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String current_status = "Paused";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignButtons();  // assign buttons on click listeners
    }

    private void assignButtons(){

        //Prev button


        // Play/Pause button
        final Button play_pause_btn = (Button)findViewById(R.id.play_btnview);
        play_pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current_status == "Playing"){
                    play_pause_btn.setText("Play");  // change text on button
                    pauseCurrentSong();
                }else{
                    play_pause_btn.setText("Pause"); // change text on button
                    playCurrentSong();
                }
            }
        });


        // next button


    }
    private void playCurrentSong() {
        //update status
        updateStatus("Playing");


        //select and play the first song from all tracks list
        // write code here
    }

    private void pauseCurrentSong() {
        //update status
        updateStatus("Paused");

        //pause the current track
        //write code here
    }

    private void updateStatus(String newstatus){
        TextView status_textview = (TextView)findViewById(R.id.status_textview);
        current_status = newstatus;
        status_textview.setText("status : " + newstatus);
    }
}
