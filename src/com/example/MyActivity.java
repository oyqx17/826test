package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MyActivity extends Activity
{
    private ImageView mImageView;

    private M2image mM2image;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(
            savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.main);

        mImageView = (ImageView) findViewById(R.id.image_view);
        mM2image = (M2image) findViewById(R.id.mM2image);

//        mImageView.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View v, MotionEvent event)
//            {
//
//                return !gdt.onTouchEvent(event);
//            }
//        });


//        mM2image.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View v, MotionEvent event)
//            {
////                return !gdt.onTouchEvent(event);
//             return   true;
////                return !gdt.onTouchEvent(event);
//            }
//        });
        
//        mM2image.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override public boolean onTouch(View v, MotionEvent event)
//            {
//                return !gdt.onTouchEvent(event);  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });


//        changePos();
//        mImageView.setPadding(0, 200, 100, 0);//边缘拉伸
        mImageView.setMaxHeight(200);
        /***********************与ONTouchListener无法共存*********************************/
//        mImageView.setLongClickable(true);
//        mImageView.setOnLongClickListener(new View.OnLongClickListener()
//        {
//            @Override public boolean onLongClick(View v)
//            {
//                System.out.println(" mImageView.setOnLongClickListener(new View.OnLongClickListener() mImageView.setOnLongClickListener(new View.OnLongClickListener()");
//                return true;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });
        /********************************************************/
//        mM2image.setLongClickable(true);
//        mM2image.setOnLongClickListener(new View.OnLongClickListener()
//        {
//            @Override public boolean onLongClick(View v)
//            {
//                System.out.println(
//                    " mM2image.setOnLongClickListener(new View.OnLongClickListener() mM2image.setOnLongClickListener(new View.OnLongClickListener()");
//                return true;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });
        /********************************************************/
    }

//    private void changePos()
//    {
//        new AsyncTask(){
//            @Override protected void onProgressUpdate(Object... values)
//            {
//                super.onProgressUpdate(
//                    values);    //To change body of overridden methods use File | Settings | File Templates.
//                 mImageView.setPadding();
//            }
//
//            @Override protected Object doInBackground(Object... params)
//            {
//                return null;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        }.execute();
//    }

    private final GestureDetector gdt = new GestureDetector(new GestureListener());

    private static final int SWIPE_MIN_DISTANCE = 120;

    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private class GestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {

            return super.onScroll(e1, e2, distanceX,
                distanceY);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override public void onLongPress(MotionEvent e)
        {
            super.onLongPress(
                e);    //To change body of overridden methods use File | Settings | File Templates.
            System.out.println("long press");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
            {
                System.out.println(
                    "// Right to left******************************************************");
//                mImageView.scrollTo(130, 20);
                return false; // Right to left
            }
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
            {
                System.out.println(
                    "// Left to right******************************************************");
                return false; // Left to right
            }
            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
            {
                System.out.println(
                    "// Bottom to top******************************************************");
                return false; // Bottom to top
            }
            else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
            {
                System.out.println(
                    "// Top to bottom******************************************************");
                return false; // Top to bottom
            }
            return false;
        }
    }
}


