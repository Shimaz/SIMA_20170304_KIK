package kr.tangomike.sima_20170304_kik;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

    private DataCollection dc;

    private Button btnInfo;
    private Button btnArtwork;
    private Button btnNote;
    private Button btnMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        dc = (DataCollection)getApplicationContext();


        btnInfo = (Button)findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnArtwork = (Button)findViewById(R.id.btn_artwork);
        btnArtwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnNote = (Button)findViewById(R.id.btn_note);
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnMedia = (Button)findViewById(R.id.btn_media);
        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    @Override
    public void onResume(){
        dc.stopTick();
        super.onResume();

    }
}
