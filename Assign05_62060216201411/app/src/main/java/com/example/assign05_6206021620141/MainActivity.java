package com.example.assign05_6206021620141;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button gradeBtn,vatBtn ,gpaBtn,galleryBtn ,exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gradeBtn = (Button) findViewById(R.id.button1);
        gradeBtn.setOnClickListener(this);
        vatBtn  = (Button) findViewById(R.id.button2);
        vatBtn .setOnClickListener(this);
        gpaBtn  = (Button) findViewById(R.id.button3);
        gpaBtn .setOnClickListener(this);
        galleryBtn  = (Button) findViewById(R.id.button4);
        galleryBtn .setOnClickListener(this);
        exitBtn = (Button) findViewById(R.id.button5);
        exitBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1) {
            startGrade();
        }
        else if (id == R.id.button2){
            startVat();
        }
        else if (id == R.id.button3){
            startGpa();
        }
        else if (id == R.id.button4){
            startGallery();
        }
        else if (id == R.id.button5) {
            Toast.makeText( MainActivity.this,
                    "Exit", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    public void startGrade() {
        Intent launchFirst = new Intent(MainActivity.this, GradeActivity.class);
        startActivity(launchFirst); // call FirstActivity
    }
    public void startVat() {
        Intent launchSecond = new Intent(MainActivity.this, VatActivity.class);
        startActivity(launchSecond); // call SecondActivity
    }
    public void startGpa() {
        Intent launchFirst = new Intent(MainActivity.this, GpaActivity.class);
        startActivity(launchFirst); // call FirstActivity
    }
    public void startGallery() {
        Intent launchFirst = new Intent(MainActivity.this, GalleryActivity.class);
        startActivity(launchFirst); // call FirstActivity
    }
}