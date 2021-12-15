package ch.rz.quicklist.controller;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener extends GestureDetector.SimpleOnGestureListener{
    @Override
    public boolean onDown(MotionEvent event) {
        Log.d("TAG","onDown: ");

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.e("TAG", "onSingleTapConfirmed: ");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.e("TAG", "onLongPress: ");
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.e("TAG", "onDoubleTap: ");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.e("TAG", "onScroll: ");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        Log.d("TAG", "onFling: ");
        return true;
    }
}

