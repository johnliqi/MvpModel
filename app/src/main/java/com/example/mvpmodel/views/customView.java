package com.example.mvpmodel.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class customView extends View {
    int lastx;
    int lasty;
    Scroller mscroller;
    int width;

    public customView(Context context) {
        super(context);
    }

    public customView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mscroller = new Scroller(context);
    }

    public customView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int) event.getX();
        int Y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = X;
                lasty = Y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = X - lastx;
                int offsetY = Y - lasty;

//                offsetTopAndBottom(offsetY);
                //       layout(getLeft() + offesetX, getTop() + offsetY, getRight() + offesetX, getBottom() + offsetY);
                break;
        }
        return true;

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mscroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mscroller.getCurrX(), mscroller.getCurrY());
            invalidate();
        }
    }


    public void smoothScroll(int decx, int decy) {
        int scroolX = getScrollX();
        int delta = decx - scroolX;
        mscroller.startScroll(scroolX, 0, delta, 2000);
    }
      class ViewWrapper {

        private View view;

        public ViewWrapper(View view) {
            this.view = view;
        }

        public int getHeight() {
            return view.getLayoutParams().height;
        }

        public void setHeight(int height) {
            view.getLayoutParams().height = height;
            view.requestLayout();
        }
    }
}
