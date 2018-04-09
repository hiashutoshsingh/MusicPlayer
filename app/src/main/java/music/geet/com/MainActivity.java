package music.geet.com;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import music.geet.com.SongsList.SongsFragment;

public class MainActivity extends AppCompatActivity {
    private static final int My_Permission_Request=1;

    private String current_status = "Paused";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code for verifing that user has given the permission to access the storage
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},My_Permission_Request);
            } else
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},My_Permission_Request);
            }
        }
        contextOfApplication = getApplicationContext();

      //  assignButtons();  // assign buttons on click listeners
        SongsFragment frag=new SongsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.my__layout,frag,"songsFragment");
        fragmentTransaction.commit();
    }
    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        switch (requestCode){
            case My_Permission_Request: {
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }


        }

    }

//    private void assignButtons(){
//
//        //Prev button
//
//
//        // Play/Pause button
//        final Button play_pause_btn = (Button)findViewById(R.id.play_btnview);
//        play_pause_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(current_status == "Playing"){
//                    play_pause_btn.setText("Play");  // change text on button
//                    pauseCurrentSong();
//                }else{
//                    play_pause_btn.setText("Pause"); // change text on button
//                    playCurrentSong();
//                }
//            }
//        });
//
//
//        // next button
//
//
//    }
//    private void playCurrentSong() {
//        //update status
//        updateStatus("Playing");
//
//
//        //select and play the first song from all tracks list
//        // write code here
//    }
//
//    private void pauseCurrentSong() {
//        //update status
//        updateStatus("Paused");
//
//        //pause the current track
//        //write code here
//    }
//
//    private void updateStatus(String newstatus){
//        TextView status_textview = (TextView)findViewById(R.id.status_textview);
//        current_status = newstatus;
//        status_textview.setText("status : " + newstatus);
//    }
}
