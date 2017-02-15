package kr.tangomike.sima_20170304_kik;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;


public class ArtworkActivity extends Activity {

    private DataCollection dc;

    private ViewPager pager;
    private SimaPagerAdapter adapter;
    private Button btnHome;
    private Button btnCaption;

    private ImageView ivCaption;

    private LayoutParams captionLP;

    private boolean isCaptionOn;
    private boolean isPageSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork);
        super.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        dc = (DataCollection)getApplicationContext();
        dc.startTick();


        isPageSet = true;

        btnHome = (Button)findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                overridePendingTransition(R.anim.fade_in_short, R.anim.fade_out_short);

            }
        });

        isCaptionOn = false;

        btnCaption = (Button)findViewById(R.id.btn_caption);
        btnCaption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPageSet){
                    if(isCaptionOn){
                        HideCaption();
                    }else{
                        ShowCaption();
                    }
                }




            }
        });






        adapter = new SimaPagerAdapter();



        pager = (ViewPager)findViewById(R.id.vp_artwork);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);

        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                android.util.Log.i("shimaz", "" + state);

                switch (state){
                    case 0: // page set
                        isPageSet = true;
                        if(isCaptionOn) UndimCaption();

                        break;

                    case 1: // start scroll
                        isPageSet = false;
                        if(isCaptionOn) DimCaption();

                        break;

                    case 2: // on scroll
                        isPageSet = false;

                        break;


                    default:
                        break;

                }



            }
        };

        pager.addOnPageChangeListener(listener);


        ViewPager.OnDragListener dragListener = new ViewPager.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {

                if(isCaptionOn){

                }

                return false;
            }
        };

        pager.setOnDragListener(dragListener);


        captionLP = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ivCaption = new ImageView(this);
        ivCaption.setPivotX(1.0f);
        ivCaption.setPivotY(1.0f);

        ivCaption.setLayoutParams(captionLP);




    }


    private void ShowCaption(){
        isCaptionOn = true;
    }

    private void HideCaption(){
        isCaptionOn = false;
    }

    private void DimCaption(){

        btnCaption.setAlpha(0.5f);

    }

    private void UndimCaption(){

        btnCaption.setAlpha(1.0f);
    }

    public class SimaPagerAdapter extends PagerAdapter{


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = getLayoutInflater().inflate(R.layout.layout_page, container, false);
            ImageView iv = (ImageView)page.findViewById(R.id.iv_page);
            iv.setImageResource(getResources().getIdentifier("artwork_img_" + position + "_bg", "drawable", getPackageName()));



            container.addView(page);

            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }



        //        @Override
//        public int getCount() {
//            return 10;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return false;
//         }
//
//        public Object instantiateItem(View collection, int position) {
//
//
//            ImageView imgview = new ImageView(getBaseContext());
//            imgview.setImageResource(getResources().getIdentifier("artwork_img_"+position, "drawable", getPackageName()));
//
//            ((ViewPager)collection).addView(imgview, 0);
//
//
//
//
//            return imgview;
//        }

    }
}
