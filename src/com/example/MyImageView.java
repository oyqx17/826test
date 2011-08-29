package com.example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by IntelliJ IDEA. User: Administrator Date: 11-8-26 Time: 下午5:09 To change this template
 * use File | Settings | File Templates.
 */
public class MyImageView extends View
{
    private static final int INVALID_POINTER_ID = -1;

    private Drawable mImage;

    private float mPosX;

    private float mPosY;

    private float mLastTouchX;

    private float mLastTouchY;

    private int mActivePointerId = INVALID_POINTER_ID;

    private ScaleGestureDetector mScaleDetector;

    private float mScaleFactor = 1.f;

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.save();
        Log.d("DEBUG", "X: " + mPosX + " Y: " + mPosY);
        canvas.translate(mPosX, mPosY);
        canvas.scale(mScaleFactor, mScaleFactor);
        mImage.draw(canvas);
        canvas.restore();
    }

    public MyImageView(Context context)
    {
        super(context);
    }

//    /**
//     * {@inheritDoc}
//     */
//    @Override protected void onLayout(boolean changed, int l, int t, int r, int b)
//    {
//        int childLeft = 0;
//
//        final int count = getChildCount();
//        for (int i = 0; i < count; i++)
//        {
//            final View child = getChildAt(i);
//            if (child.getVisibility() != View.GONE)
//            {
//                final int childWidth = child.getMeasuredWidth();
//                child.layout(childLeft, 0, childLeft + childWidth, child.getMeasuredHeight());
//                childLeft += childWidth;
//            }
//        }
//    }

    /**
     * Implement this method to handle touch screen motion events.
     *
     * @param ev The motion event.
     *
     * @return True if the event was handled, false otherwise.
     */
    @Override public boolean onTouchEvent(MotionEvent ev)
    {
        super.onTouchEvent(ev);
        {
            // Let the ScaleGestureDetector inspect all events.
            mScaleDetector.onTouchEvent(ev);

            final int action = ev.getAction();

            {
                switch (action & MotionEvent.ACTION_MASK)
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        System.out.println("action-down");
                        final float x = ev.getX();
                        final float y = ev.getY();

                        mLastTouchX = x;
                        mLastTouchY = y;
                        mActivePointerId = ev.getPointerId(0);
                        break;
                    }

                    case MotionEvent.ACTION_MOVE:
                    {
                        System.out.println("action-move");
                        final int pointerIndex = ev.findPointerIndex(mActivePointerId);
                        final float x = ev.getX(pointerIndex);
                        final float y = ev.getY(pointerIndex);

                        // Only move if the ScaleGestureDetector isn't processing a gesture.
                        if (!mScaleDetector.isInProgress())
                        {
                            final float dx = x - mLastTouchX;
                            final float dy = y - mLastTouchY;

                            mPosX += dx;
                            mPosY += dy;

                            invalidate();
                        }

                        mLastTouchX = x;
                        mLastTouchY = y;

                        break;
                    }

                    case MotionEvent.ACTION_UP:
                    {
                        System.out.println("action_up");
                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_CANCEL:

                    {
                        System.out.println("action-cancel");
                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_POINTER_UP:
                    {
                        System.out.println("action-pointer-up");
                        final int pointerIndex =
                            (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK)
                                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                        final int pointerId = ev.getPointerId(pointerIndex);
                        if (pointerId == mActivePointerId)
                        {
                            // This was our active pointer going up. Choose a new
                            // active pointer and adjust accordingly.
                            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                            mLastTouchX = ev.getX(newPointerIndex);
                            mLastTouchY = ev.getY(newPointerIndex);
                            mActivePointerId = ev.getPointerId(newPointerIndex);
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }
}
