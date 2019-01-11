package com.scanview.quts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ScanView extends View implements ValueAnimator.AnimatorUpdateListener{

    private static final float CONTENT_SIZE_RATE = 2 / 3;
    private static final float INDICATOR_SIZE_RATE = 2 / 3;
    private static final float SPACE_SIZE_RATE = 1 / 6;
    private static final float CIRCLE_SIZE_RATE = 1 / 6;
    private static final int INDICATOR_START_DEGREE = 45;

    private ValueAnimator mAnimator = ValueAnimator.ofFloat(0f,1f);
    private Paint mPaint = new Paint();

    private float mCircleX;
    private float mCircleY;
    private float mCircleR;
    private float mIndicatorX;
    private float mIndicatorY;
    private float mIndicatorHeight;
    private float mIndicatorWidth;

    public ScanView(final Context context) {
        super(context);
        initResource();
    }

    public ScanView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        initResource();
    }

    public ScanView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initResource();
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        initWidthSize(w,h);
    }

    private void initResource(){
        mPaint.setAntiAlias(true);
        mPaint.set
        mIndicatorWidth = getResources().getDimension(R.dimen.indicator_stroke_width);
    }

    private void initWidthSize(int viewWidth,int viewHeight){
        int standardLength = Math.min(viewWidth,viewHeight);
        float wgtLength = standardLength * CONTENT_SIZE_RATE;
        mCircleX = (float)viewWidth / 2;
        mCircleR = wgtLength * CIRCLE_SIZE_RATE / 2;
        mCircleY = viewHeight - ((standardLength - wgtLength) / 2 ) - mCircleR;
        mIndicatorHeight = wgtLength * INDICATOR_SIZE_RATE;
    }

    public void startScan(){
        mAnimator.start();
    }

    public void stopScan(){

    }

    public void pauseScan(){

    }

    public void reverseScan(){

    }

    public void destroyScan(){
        mAnimator.cancel();
        mAnimator = null;
    }


    @Override
    public void onAnimationUpdate(final ValueAnimator animation) {

    }
}
