package com.coconutmartini.wallet;

import android.view.GestureDetector;

public class OnSwipeTouchListener implements OnTouchListener {

    ListView list;
    private GestureDetector gestureDetector;
    private Context context;

    public OnSwipeTouchListener(Context ctx, ListView list) {
        gestureDetector = new GestureDetector(ctx, new GestureListener());
        context = ctx;
        this.list = list;
    }

    public OnSwipeTouchListener() {
        super();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public void onSwipeRight(int pos) {

    }

    public void onSwipeLeft() {

    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        private int getPostion(MotionEvent e1) {
            return list.pointToPosition((int) e1.getX(), (int) e1.getY());
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if (Math.abs(distanceX) &gt; Math.abs(distanceY) &amp;&amp; Math.abs(distanceX) &gt; SWIPE_THRESHOLD &amp;&amp; Math.abs(velocityX) &gt; SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX &gt; 0)
                onSwipeRight(getPostion(e1));
                else
                onSwipeLeft();
                return true;
            }
            return false;
        }

    }
}