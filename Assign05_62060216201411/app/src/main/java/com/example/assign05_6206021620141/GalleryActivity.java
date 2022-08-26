package com.example.assign05_6206021620141;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btn1,btn2,btn3,btn4,btn5,btn66,btn7,btn8;
    private ImageView Show;
    private String [] names = {

            "deosai_land", "dudipatsar_lake","rama_lake","picture_1","picture_2","picture_3","picture_4","picture_5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn66 = (ImageButton) findViewById(R.id.btn66);
        btn66.setOnClickListener(this);
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        Show = (ImageView) findViewById(R.id.imageView);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn1){
            Show.setImageResource(R.drawable.deosai_land);
        }
        if(id == R.id.btn2){
            Show.setImageResource(R.drawable.dudipatsar_lake);
        }
        if(id == R.id.btn3){
            Show.setImageResource(R.drawable.rama_lake);
        }
        if(id == R.id.btn4){
            Show.setImageResource(R.drawable.picture_1);
        }
        if(id == R.id.btn5){
            Show.setImageResource(R.drawable.picture_2);
        }
        if(id == R.id.btn66){
            Show.setImageResource(R.drawable.picture_5);
        }
        if(id == R.id.btn7){
            Show.setImageResource(R.drawable.picture_4);
        }
        if(id == R.id.btn8){
            Show.setImageResource(R.drawable.picture_3);
        }
    }
}