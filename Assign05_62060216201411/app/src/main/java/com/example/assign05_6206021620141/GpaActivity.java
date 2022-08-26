package com.example.assign05_6206021620141;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class GpaActivity extends AppCompatActivity implements View.OnClickListener {
    Button backBtn , btnCalGpa;
    EditText textGrade1,textGrade2 ,textGrade3 ,textGrade4;
    TextView ShowPointGPA ,ShowCredits,ShowGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        textGrade1 = (EditText) findViewById(R.id.textGrade1);
        textGrade2 = (EditText) findViewById(R.id.textGrade2);
        textGrade3 = (EditText) findViewById(R.id.textGrade3);
        textGrade4 = (EditText) findViewById(R.id.textGrade4);
        ShowPointGPA = (TextView) findViewById(R.id.textPointGpa);
        ShowCredits = (TextView) findViewById(R.id.textCredite);
        ShowGPA = (TextView) findViewById(R.id.textGPA);
        btnCalGpa = (Button) findViewById(R.id.btnCalGTA);
        btnCalGpa.setOnClickListener(this);
        backBtn = (Button) findViewById(R.id.btnBack3);
        backBtn.setOnClickListener(this);
    }
        @Override
        public void onClick (View v) {
            int id = v.getId();
            if (id == R.id.btnCalGTA) {
                double P1 = 0 ;
                double P2 = 0 ;
                double P3 = 0 ;
                double P4 = 0;
                int cre1 = 0;
                int cre2 = 0;
                int cre3 = 0;
                int cre4 = 0;
                ShowPointGPA.setText("");
                ShowCredits.setText("");
                ShowGPA.setText("");
                //Grade1
                if (textGrade1.getText().length() == 0 ){
                    Toast.makeText(GpaActivity.this, "No GPA",
                            Toast.LENGTH_LONG).show();
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("A")){
                    P1 = 4;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("B\\+")){
                    P1 = 3.5;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("B")){
                    P1 = 3;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("C\\+")){
                    P1 = 2.5;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("C")){
                    P1 = 2;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("D\\+")){
                    P1 = 1.5;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("D")){
                    P1 = 1;
                    cre1 = 3;
                }
                else if (textGrade1.getText().toString().toUpperCase(Locale.ROOT).matches("F")){
                    P1 = 0;
                    cre1 = 3;
                }
                else {
                    Toast.makeText(GpaActivity.this, "Please Enter \n A or B+ or B or C+ or C or D+ or D or F ",
                            Toast.LENGTH_LONG).show();
                }

                //Grade2
                if (textGrade2.getText().length() == 0){
                    P2 = 0;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("A")){
                    P2 = 4;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("B\\+")){
                    P2 = 3.5;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("B")){
                    P2 = 3;
                    cre2 += 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("C\\+")){
                    P2 = 2.5;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("C")){
                    P2 = 2;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("D\\+")){
                    P2 = 1.5;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("D")){
                    P2 = 1;
                    cre2 = 3;
                }
                else if (textGrade2.getText().toString().toUpperCase(Locale.ROOT).matches("F")){
                    P2 = 0;
                    cre2 = 3;
                }
                else {
                    Toast.makeText(GpaActivity.this, "Please Enter \n A or B+ or B or C+ or C or D+ or D or F ",
                            Toast.LENGTH_LONG).show();
                }


                //Grade3
                if (textGrade3.getText().length() == 0){
                    P3 = 0;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("A")){
                    P3 = 4;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("B\\+")){
                    P3 = 3.5;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("B")){
                    P3 = 3;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("C\\+")){
                    P3 = 2.5;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("C")){
                    P2 = 2;
                    cre2 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("D\\+")){
                    P3 = 1.5;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("D")){
                    P3 = 1;
                    cre3 = 3;
                }
                else if (textGrade3.getText().toString().toUpperCase(Locale.ROOT).matches("F")){
                    P3 = 0;
                    cre3 = 3;
                }
                else {
                    Toast.makeText(GpaActivity.this, "Please Enter \n A or B+ or B or C+ or C or D+ or D or F ",
                            Toast.LENGTH_LONG).show();
                }

                //Grade4
                if (textGrade4.getText().length() == 0){
                    P4 = 0;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("A")){
                    P4 = 4;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("B\\+")){
                    P4 = 3.5;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("B")){
                    P4 = 3;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("C\\+")){
                    P4 = 2.5;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("C")){
                    P4 = 2;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("D\\+")){
                    P4 = 1.5;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("D")){
                    P4 = 1;
                    cre4 = 3;
                }
                else if (textGrade4.getText().toString().toUpperCase(Locale.ROOT).matches("F")){
                    P4 = 0;
                    cre4 = 3;
                }
                else {
                    Toast.makeText(GpaActivity.this, "Please Enter \n A or B+ or B or C+ or C or D+ or D or F ",
                            Toast.LENGTH_LONG).show();
                }

                double Point = ((P1*3)+(P2*3)+(P3*3)+(P4*3));
                int Credits = (cre1+cre2+cre3+cre4);
                double GPA = Point/Credits;
                ShowPointGPA.setText(ShowPointGPA.getText().toString() + Point);
                ShowCredits.setText(ShowCredits.getText().toString() + Credits);
                ShowGPA.setText(ShowGPA.getText().toString() + GPA);
            }
            else if (id == R.id.btnBack3){
                Toast.makeText( GpaActivity.this,
                        " Out of Calculate GPA ",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
}

