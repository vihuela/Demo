package worldgo.animator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.tumblr.backboard.Actor;
import com.tumblr.backboard.MotionProperty;
import com.tumblr.backboard.imitator.Imitator;
import com.tumblr.backboard.imitator.MotionImitator;
import com.tumblr.backboard.performer.Performer;

public class MainActivity extends AppCompatActivity {

    private View view, rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.tv);
        rootView = findViewById(R.id.rootView);


        final SpringSystem springSystem = SpringSystem.create();

        final Spring spring = springSystem.createSpring();
        spring.setCurrentValue(100, false);//第二个参数为是否将值设置为终点，false为每次都会还原回去，但是第一次未设置为0
    }

    private void move() {
        new Actor.Builder(SpringSystem.create(), view)
                .addTranslateMotion(Imitator.TRACK_DELTA, Imitator.FOLLOW_EXACT, MotionProperty.X)
                .addTranslateMotion(Imitator.TRACK_DELTA, Imitator.FOLLOW_EXACT, MotionProperty.Y)
                .build();
    }

    private void scale() {
        final SpringSystem springSystem = SpringSystem.create();

        final Spring spring = springSystem.createSpring();

        spring.addListener(new Performer(view, View.SCALE_X));
        spring.addListener(new Performer(view, View.SCALE_Y));

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        spring.setVelocity(0);

                    case MotionEvent.ACTION_MOVE:

                        // can't use Imitation here because there is no nice mapping from
                        // an event property to a Spring
                        float scaleX, scaleY;

                        float delta = event.getX() - (view.getX() + view.getMeasuredWidth() / 2);
                        scaleX = Math.abs(delta) / (view.getMeasuredWidth() / 2);

                        delta = event.getY() - (view.getY() + view.getMeasuredHeight() / 2);
                        scaleY = Math.abs(delta) / (view.getMeasuredHeight() / 2);

                        float scale = Math.max(scaleX, scaleY);

                        spring.setEndValue(scale);

                        break;
                    case MotionEvent.ACTION_UP:
                        spring.setEndValue(1f);

                        break;
                }

                return true;
            }
        });
    }

    private void snap() {
        new Actor.Builder(SpringSystem.create(), view)
                .addTranslateMotion(MotionProperty.Y)
                .addMotion(
                        new MotionImitator(MotionProperty.X) {
                            @Override
                            public void release(MotionEvent event) {

                                // snap to left or right depending on current location
                                if (mSpring.getCurrentValue() >
                                        rootView.getMeasuredWidth() / 2 -
                                                view.getMeasuredWidth() / 2) {

                                    mSpring.setEndValue(rootView.getMeasuredWidth() -
                                            view.getMeasuredWidth());
                                } else {

                                    mSpring.setEndValue(0);
                                }
                            }
                        },
                        View.TRANSLATION_X
                )
                .build();
    }

    private void zoom() {
        final SpringSystem springSystem = SpringSystem.create();
        final Spring spring = springSystem.createSpring();

        spring.addListener(new Performer(view, View.SCALE_X));
        spring.addListener(new Performer(view, View.SCALE_Y));

        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(MainActivity.this,
                new ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    @Override
                    public boolean onScale(ScaleGestureDetector detector) {
                        spring.setCurrentValue(spring.getCurrentValue() * detector.getScaleFactor(), true);
                        return true;
                    }

                    @Override
                    public void onScaleEnd(ScaleGestureDetector detector) {
                        spring.setEndValue(1.0f);
                    }
                });
        spring.setCurrentValue(1.0f);//init
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return scaleGestureDetector.onTouchEvent(event);
            }
        });
    }
}
