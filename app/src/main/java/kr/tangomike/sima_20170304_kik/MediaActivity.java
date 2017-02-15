package kr.tangomike.sima_20170304_kik;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MediaActivity extends Activity {


    private Button btnClose;
    private Button btnPlayPause;

    private DataCollection dc;

    private SeekBar sbVideo;
    private SeekBar sbAudio;



    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        super.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        dc = (DataCollection)getApplicationContext();
//        dc.startTick();


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                overridePendingTransition(R.anim.fade_in_short, R.anim.fade_out_short);

            }
        });



    }
}
