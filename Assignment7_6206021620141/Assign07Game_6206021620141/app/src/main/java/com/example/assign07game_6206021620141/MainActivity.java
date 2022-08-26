package com.example.assign07game_6206021620141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView numPoin;
    int res_iv[] = { R.id.imageButton,R.id.imageButton2, R.id.imageButton3,
            R.id.imageButton4, R.id.imageButton5, R.id.imageButton6,
            R.id.imageButton7, R.id.imageButton8, R.id.imageButton9 };

    int res_image[] = { R.drawable.apple,R.drawable.apricot,
            R.drawable.banana, R.drawable.cherry,
            R.drawable.mango, R.drawable.pear,
            R.drawable.strawberry, R.drawable.watermalon };

    int fg = R.drawable.ic_home_m;
    ImageButton iv[] = new ImageButton[res_iv.length];
    Button startButton;
    int iNum = -1, oldNum = -1, iImage = -1;
    CountDownTimer timer1;
    Random rnd = new Random();
    int MaxImage = res_image.length; // 8
    int MaxPos = res_image.length; // 9
    int Poin = 0;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numPoin = (TextView) findViewById(R.id.numPoin);
        time = (TextView) findViewById(R.id.time);

        // show img home
        for(int n = 0 ; n < iv.length ; n ++) {
            iv[n] = (ImageButton) findViewById(res_iv[n]);
            iv[n].setImageResource(fg);
        }

        timer1 = new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
                int min = (int) millisUntilFinished / 1000;
                time.setText(min+"");
//                Log.d("pooh", "millisUntilFinished: "+ (min));
                if (oldNum != -1) {
                    iv[oldNum].setImageResource(fg);
                    iv[oldNum].setEnabled(false);
                }

                iNum = rnd.nextInt( MaxPos );
                iImage = rnd.nextInt( MaxImage );

                iv[iNum].setImageResource( res_image[iImage] );
                iv[iNum].setEnabled(true);
                iv[iNum].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(res_iv[iNum] == view.getId()) {
                            Poin++;
                            numPoin.setText(Poin+"");
                            iv[oldNum].setEnabled(false);
                        }
                    }
                });
                oldNum = iNum;
            }

            public void onFinish() {
                iv[iNum].setImageResource(fg);
                startButton.setEnabled(true);

                // คลิ๊กไม่ได้
                for (int i = 0; i < iv.length ; i++)
                    iv[i].setEnabled(false);
            }
        };

        // Start Game
        startButton = (Button) findViewById( R.id.buttonStart);
        startButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Poin = 0;
                numPoin.setText(Poin+"");
                time.setText("20");
                timer1.start();
                startButton.setEnabled(false);
            }
        });

    }
}