package com.example.assign07slide_6206021620141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    int res_image[] = { R.drawable.deosai_land, R.drawable.dudipatsar_lake,
            R.drawable.rama_lake, R.drawable.shangrila_lower_kachura_lake,
            R.drawable.pu,R.drawable.mok,R.drawable.ya,R.drawable.ta };

    Button startSlide , stopSlide;
    CheckBox Loop;
    TextInputEditText num;
    private Handler mHandler = new Handler( Looper.myLooper());
    int iSlide = 0;
    int Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Loop = (CheckBox) findViewById(R.id.checkBoxLoop);
        num =  (TextInputEditText) findViewById(R.id.inputNum);
        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(res_image[iSlide]);

        startSlide = (Button) findViewById( R.id.btnStart);
        startSlide.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                if(num.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Input Number!!",Toast.LENGTH_SHORT).show();
                    return;
                }

                Time = (int) (Float.parseFloat(num.getText().toString()) * 1000);
                iSlide = 0;
                iv.setImageResource(res_image[iSlide]);
                mHandler.postDelayed(mUpdateTimeTask,Time);
                startSlide.setEnabled(false);
                stopSlide.setEnabled(true);

                Toast.makeText(MainActivity.this,"Start",Toast.LENGTH_SHORT).show();
            }
        });

        stopSlide = (Button) findViewById(R.id.btnStop);
        stopSlide.setEnabled(false);
        stopSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.removeCallbacks(mUpdateTimeTask);
                iv.setImageResource(res_image[iSlide]);
                startSlide.setEnabled(true);
                stopSlide.setEnabled(false);

                Toast.makeText(MainActivity.this,"Stop",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Runnable mUpdateTimeTask = new Runnable () {
        public void run() {
            if (iSlide == res_image.length - 1) {
                if (Loop.isChecked())
                    iSlide = -1;
                else {
                    iSlide = 0;
                    iv.setImageResource(res_image[iSlide]);
                    startSlide.setEnabled(true);
                    stopSlide.setEnabled(false);
                    return;
                }
            }

            iSlide ++;
            iv.setImageResource(res_image[iSlide]);
            mHandler.postDelayed(this, Time);
        }
    };
}