package kr.tangomike.sima_20170304_kik;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MediaActivity extends Activity {


    private Button btnClose;
    private Button btnPlayPause;
    private Button btnVideo1;
    private Button btnVideo2;

    private DataCollection dc;

    private SeekBar sbVideo;
    private SeekBar sbAudio;


    private ImageView ivTitle;

    private VideoView vv;

    private int videoNumber;

    private Thread videoThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        super.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        dc = (DataCollection)getApplicationContext();
//        dc.startTick();

        videoNumber = 1;

        btnClose = (Button)findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                overridePendingTransition(R.anim.fade_in_short, R.anim.fade_out_short);

            }
        });

        btnPlayPause = (Button)findViewById(R.id.btn_play_pause);
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(vv.isPlaying()){
                    btnPlayPause.setBackgroundResource(R.drawable.media_btn_play);
                    vv.pause();
                    dc.startTick();

                }else{
                    btnPlayPause.setBackgroundResource(R.drawable.media_btn_pause);
                    vv.start();
                    dc.stopTick();

                }


            }
        });

        btnVideo1 = (Button)findViewById(R.id.btn_video1);
        btnVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(videoNumber == 2){
                    setVideo(1);
                }

            }
        });


        btnVideo2 = (Button)findViewById(R.id.btn_video2);
        btnVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(videoNumber == 1){
                    setVideo(2);
                }

            }
        });



        sbAudio = (SeekBar)findViewById(R.id.sb_audio);
        sbVideo = (SeekBar)findViewById(R.id.sb_video);


        vv = (VideoView)findViewById(R.id.vv_media);

        ivTitle = (ImageView)findViewById(R.id.iv_video_title);
        setVideo(1);
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                dc.stopTick();
                vv.start();
                btnPlayPause.setBackgroundResource(R.drawable.media_btn_pause);
            }
        });

        vv.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                return false;
            }
        });

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sbVideo.setProgress(0);
                btnPlayPause.setBackgroundResource(R.drawable.media_btn_play);
                dc.startTick();
            }
        });

//        vv.start();



    }


    private void setVideo(int number){
        videoNumber = number;

        ivTitle.setBackgroundResource(getResources().getIdentifier("media_img_title_" + number, "drawable", getPackageName()));

        String path = "android.resource://" + getPackageName() + "/raw/media_mov_" + number;

        if(vv.isPlaying()) vv.stopPlayback();
        vv.setVideoURI(Uri.parse(path));

        if(number == 1){

            btnVideo1.setBackgroundResource(R.drawable.media_btn_1_push);
            btnVideo2.setBackgroundResource(R.drawable.media_btn_video_2);
        }else{
            btnVideo1.setBackgroundResource(R.drawable.media_btn_video_1);
            btnVideo2.setBackgroundResource(R.drawable.media_btn_2_push);


        }


    }
}
