package kr.tangomike.sima_20170304_kik;

import android.app.Application;

/**
 * Created by shimaz on 2017-02-09.
 */

public class DataCollection extends Application {

    private int ticktime;
    private static final int RESET_TIME = 60;
    private boolean isTicking;


    public void onCreate(){
        super.onCreate();
        ticktime = 0;
        isTicking = false;

        // TODO: Use broadcast for timer function
    }



    public int getTicktime(){
        return ticktime;
    }

    public void resetTimer(){
        ticktime = 0;
    }

    public void stopTick(){
        isTicking = false;
    }

    public void startTick(){
        ticktime = 0;
        isTicking = true;
    }

}
