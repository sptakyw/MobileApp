package com.example.assignment8_6206021620141;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.Random;

public class GraphicsView extends View implements View.OnTouchListener {
    private Paint p;
    private int[] X = new int[5], Y = new int[5];
    private float[] speedY = new float[5];
    private boolean[] shoot = new boolean[5];
    private int imageWidth, imageHeight;
    private float width, height;
    private Bitmap image, image_boom;
    private int score, time;
    private CountDownTimer timer, ufo_1;
    private boolean finish = false;
    private Random random = new Random();
    private int time_coun = 30000; // 30 sec
    private int speedst , speednd;
    MediaPlayer mPlayer;

    public GraphicsView(Context context) {
        super(context);



        // set bg color
        // setBackgroundColor(Color.argb(100, 10, 10, 10));
        // set bg color class
        // setBackgroundColor(getResources().getColor(R.color.black));
        // set bg img
        setBackground(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.awk));

        p = new Paint();
        image = BitmapFactory.decodeResource(getResources(), R.drawable.mn);
        image_boom = BitmapFactory.decodeResource(getResources(), R.drawable.boom_80x80);
        score = 0;
        time = 0;
        width = 0;
        height = 0;
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        speedst = 10;
        speednd = 50;
        setOnTouchListener(this);

        mPlayer = MediaPlayer.create(context,R.raw.tid);

        startUfo();
        // เวลา
        timer = new CountDownTimer(time_coun, 1000) {
            public void onTick(long millisUntilFinished) {
                time++;
                invalidate();
            }
            public void onFinish() {
                finish = true;
                ufo_1.cancel();
                invalidate();
            }
        };

        // สุ่มยาน
        ufo_1 = new CountDownTimer(time_coun, 40) {
            public void onTick(long millisUntilFinished) {
                for (int i = 0; i < 5 ; i++) {
                    Y[i] += speedY[i];
                    int maxY = 100 + (int) (height - imageHeight - 100); // ทำให้พอดีกับหน้า
                    if (Y[i] > maxY)
                        Y[i] = 0;
                }
                invalidate();
            }
            public void onFinish() {
                finish = true;
                invalidate();
            }
        };

        timer.start();
        ufo_1.start();
    }

    private void startUfo() {
        Arrays.fill(shoot,false);
        for (int i = 0; i < 5 ; i++) {
            int maxX = (int) (width - imageWidth);
            X[i] = random.nextInt(Math.abs( maxX ));
            speedY[i] = rand(speedst,speednd);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (finish) {
            finish = false;
            timer.start();
            ufo_1.start();
            score = 0;
            time = 0;
            startUfo();
            invalidate();
        } else {
            float x = event.getX();
            float y = event.getY();
            for (int i = 0; i < 5 ; i++) {
                if (isInside(x, y,X[i],Y[i])) {
                    shoot[i] = true;
                    score += 1;
                    invalidate();
                }
            }
        }
        return (true);
    }

    private boolean isInside(float xp, float yp,float X,float Y) {
        if (xp > X && xp < X + image.getWidth())
            if (yp > Y && yp < Y + image.getHeight())
                return (true);
        return (false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();

        if (finish) {
            p.setColor(Color.WHITE);
            p.setTextSize(60);
            p.setTextAlign(Paint.Align.CENTER);
            p.setFakeBoldText(true);
            canvas.drawText("Time Out!", width/2, height/2-100, p);
            canvas.drawText("Press for play again or back to exit", width/2, height/2 + 100, p);
        }
        else {
            p.setColor(Color.CYAN);
            p.setTextSize(50);
            p.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Score : " + score, 20, 60, p);
            p.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Time : " + time, width-20, 60, p);

            for (int i = 0; i < 5; i++) {
                if (shoot[i]) {
                    canvas.drawBitmap(image_boom, X[i], Y[i], null);
                    X[i] = -500;
                    Y[i] = -500;
                    shoot[i] = false;
                    int maxX = (int) (width - imageWidth);
                    X[i] = random.nextInt(maxX);
                    speedY[i] = rand(speedst,speednd);

                    if (mPlayer.isPlaying()){
                        mPlayer.stop();
                        mPlayer.release();
                        mPlayer = null;
                    }
                    mPlayer = MediaPlayer.create(getContext(),R.raw.tid);
                    mPlayer.start();
                }
                else
                    canvas.drawBitmap(image, X[i], Y[i], null);
            }
        }
    }

    // random
    private int rand(int min,int max) {
        int num = max - min + 1;
        int random_int = (min + (int)(Math.random() * num));
        return (random_int);
    }
}
