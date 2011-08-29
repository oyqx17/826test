package com.example;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

/**
 * 这个是自定义的TextView. 至少需要重载构造方法和onDraw方法 对于自定义的View如果没有自己独特的属性，可以直接在xml文件中使用就可以了
 * 如果含有自己独特的属性，那么就需要在构造函数中获取属性文件attrs.xml中自定义属性的名称 并根据需要设定默认值，放在在xml文件中没有定义。
 * 如果使用自定义属性，那么在应用xml文件中需要加上新的schemas， 比如这里是xmlns:my="http://schemas.android.com/apk/res/demo.view.my"
 * 其中xmlns后的“my”是自定义的属性的前缀，res后的是我们自定义View所在的包
 *
 * @author Administrator
 */
public class M2image extends ImageView
{
    /**
     * ***********************************************************
     */
    private static final int INVALID_POINTER_ID = -1;


    private float mPosX;

    private float mPosY;

    private Drawable mImage;

    private float mLastTouchX;

    private float mLastTouchY;

    private int mActivePointerId = INVALID_POINTER_ID;

    private ScaleGestureDetector mScaleDetector;

    private float mScaleFactor = 1.f;
    private M2image  mM2image;

    /**
     * ***********************************************************
     */
    Paint mPaint; //画笔,包含了画几何图形、文本等的样式和颜色信息

    public M2image(Context context)
    {
        super(context);
//        mImage = getResources().getDrawable(R.drawable.ic);
    }

    public M2image(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mPaint = new Paint();
        //TypedArray是一个用来存放由context.obtainStyledAttributes获得的属性的数组
        //在使用完成后，一定要调用recycle方法
        //属性的名称是styleable中的名称+“_”+属性名称
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        int textColor = array.getColor(R.styleable.MyView_textColor, 0XFF00FF00); //提供默认值，放置未指定
        float textSize = array.getDimension(R.styleable.MyView_textSize, 36);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);

        array.recycle(); //一定要调用，否则这次的设定会对下次的使用造成影响
    }

//    public void onDraw(Canvas canvas)
//    {
//        super.onDraw(canvas);
//        //Canvas中含有很多画图的接口，利用这些接口，我们可以画出我们想要的图形
//        //mPaint = new Paint();
//        //mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.STROKE); //设置填充
//        canvas.drawRect(50, 0, 200, 100, mPaint); //绘制矩形
//        mPaint.setColor(Color.BLUE);
////        canvas.drawText("我是被画出来的", 60, 120, mPaint);
//    }

  

    @Override public boolean onTouchEvent(MotionEvent ev)
    {
        super.onTouchEvent(ev);
        {
            // Let the ScaleGestureDetector inspect all events.
//            mScaleDetector.onTouchEvent(ev);

            final int action = ev.getAction();

            {
                switch (action & MotionEvent.ACTION_MASK)
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        System.out.println("action-down");
                        final float x = ev.getX();
                        System.out.println(x);
                        final float y = ev.getY();
                        System.out.println(y);
//                        mLastTouchX = x;
//                        mLastTouchY = y;
//                        mActivePointerId = ev.getPointerId(0);
                        break;
                    }

                    case MotionEvent.ACTION_MOVE:
                    {
                        System.out.println("action-move" + ev.getX());
//                        final int pointerIndex = ev.findPointerIndex(mActivePointerId);
//                        final float x = ev.getX(pointerIndex);
//                        final float y = ev.getY(pointerIndex);
//
//                        // Only move if the ScaleGestureDetector isn't processing a gesture.
//                        if (!mScaleDetector.isInProgress())
//                        {
//                            final float dx = x - mLastTouchX;
//                            final float dy = y - mLastTouchY;
//
//                            mPosX += dx;
//                            mPosY += dy;
//
//                            invalidate();
//                        }
//
//                        mLastTouchX = x;
//                        mLastTouchY = y;

                        break;
                    }

                    case MotionEvent.ACTION_UP:
                    {
                        System.out.println("action_up");
//                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_CANCEL:

                    {
                        System.out.println("action-cancel");
//                        mActivePointerId = INVALID_POINTER_ID;
                        break;
                    }

                    case MotionEvent.ACTION_POINTER_UP:
                    {
                        System.out.println("action-pointer-up");
//                        final int pointerIndex =
//                            (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK)
//                                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
//                        final int pointerId = ev.getPointerId(pointerIndex);
//                        if (pointerId == mActivePointerId)
//                        {
//                            // This was our active pointer going up. Choose a new
//                            // active pointer and adjust accordingly.
//                            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
//                            mLastTouchX = ev.getX(newPointerIndex);
//                            mLastTouchY = ev.getY(newPointerIndex);
//                            mActivePointerId = ev.getPointerId(newPointerIndex);
//                        }
                        break;
                    }
                }
            }
        }
        return true;
    }
}
