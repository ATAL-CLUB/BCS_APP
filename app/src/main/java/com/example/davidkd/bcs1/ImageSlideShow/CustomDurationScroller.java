package com.example.davidkd.bcs1.ImageSlideShow;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by davidkd on 09/03/2017.
 */

public class CustomDurationScroller extends Scroller {

    private int scrollFactor = 5000;

    public CustomDurationScroller(Context context) {
        super(context);
    }

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }


    public void setScrollDurationFactor(int scrollFactor) {
        this.scrollFactor = scrollFactor;
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, scrollFactor);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, scrollFactor);
    }


}
