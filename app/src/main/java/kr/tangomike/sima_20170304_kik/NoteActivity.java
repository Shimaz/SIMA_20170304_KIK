package kr.tangomike.sima_20170304_kik;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoteActivity extends Activity {

    private DataCollection dc;
    private Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        dc = (DataCollection)getApplicationContext();
        dc.startTick();

        btnClose = (Button)findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.fade_in_short, R.anim.fade_out_short);

            }
        });

    }
}
