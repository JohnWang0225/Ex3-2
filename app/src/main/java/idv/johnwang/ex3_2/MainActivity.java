package idv.johnwang.ex3_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView tvRun;
    private Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        tvRun = (TextView) findViewById(R.id.tvRun);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRun.startAnimation(getAnimationSet());
            }
        });
        
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRun.clearAnimation();
            }
        });
    }

    private TranslateAnimation getTranslateAnimation() {
        View parentView = (View) tvRun.getParent();
        float viewHeight = parentView.getHeight();
        float viewWidth = parentView.getWidth(); 
        TranslateAnimation translateAnimation = new TranslateAnimation(0, viewWidth, 0, viewHeight);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        return translateAnimation;
    }

    private RotateAnimation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(300);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        return rotateAnimation;
    }
    
    private AnimationSet getAnimationSet() {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = getRotateAnimation();
        animationSet.addAnimation(rotateAnimation);
        TranslateAnimation translateAnimation = getTranslateAnimation();
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
