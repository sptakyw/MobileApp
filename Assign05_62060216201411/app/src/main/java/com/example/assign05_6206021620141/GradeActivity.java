package com.example.assign05_6206021620141;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GradeActivity extends AppCompatActivity implements View.OnClickListener {
    Button backBtn, btnCalGrade;
    EditText numScore;
    TextView ShowYourScore, ShowYourGrade;
    float Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        backBtn = (Button) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(this);
        btnCalGrade = (Button) findViewById(R.id.btnCalGrade);
        btnCalGrade.setOnClickListener(this);
        ShowYourScore = (TextView) findViewById(R.id.textYourScore);
        ShowYourGrade = (TextView) findViewById(R.id.textYourGrade);
        numScore = (EditText) findViewById((R.id.numScore));
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnCalGrade) {
            if (numScore.getText().length() == 0) {
                Toast.makeText(GradeActivity.this, "Please enter score !",
                        Toast.LENGTH_LONG).show();
            }
            else {
                Score = Float.parseFloat(numScore.getText().toString());
                if (Score > 100){
                    Toast.makeText(GradeActivity.this, "Ban more than 100",
                            Toast.LENGTH_LONG).show();
                }
                else if (Score > 80) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "A");
                } else if (Score >= 75 && Score < 80) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "B+");
                } else if (Score >= 70 && Score < 75) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "B");
                } else if (Score >= 65 && Score < 70) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "C+");
                } else if (Score >= 60 && Score < 65) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "C");
                } else if (Score >= 55 && Score < 60) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "D+");
                } else if (Score >= 50 && Score < 55) {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "D");
                }
                else {
                    ShowYourGrade.setText("");
                    ShowYourScore.setText("");
                    ShowYourScore.setText(ShowYourScore.getText().toString() + Score);
                    ShowYourGrade.setText(ShowYourGrade.getText().toString() + " " + "F");
                }
            }
        }
        else if (id == R.id.btnBack){
            Toast.makeText( GradeActivity.this,
                    " Out of Calculate Grade ",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
