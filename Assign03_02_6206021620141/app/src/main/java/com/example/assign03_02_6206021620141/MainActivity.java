//6206021620141 นางสาว สุพัทตรา อากิยวงศ์ IT3RA

package com.example.assign03_02_6206021620141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText midText,finalText,homeworkText;
    TextView sumShow,gradeShow;
    private Button btnCal;
    private float mid,fi,home,sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        midText = (EditText) findViewById(R.id.midText);
        finalText = (EditText) findViewById(R.id.finalText);
        homeworkText = (EditText) findViewById(R.id.homeworkText);
        sumShow = (TextView) findViewById(R.id.sumShow);
        gradeShow = (TextView) findViewById(R.id.gradeShow);
        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);
    }
    public void onClick(View v) {
        sumShow.setText("คะแนนรวม :");
        gradeShow.setText("เกรดที่ได้ :");
        gradeShow.setText(gradeShow.getText().toString() + "");
        if (midText.getText().length() == 0 || finalText.getText().length() == 0 || homeworkText.getText().length() == 0){
            Toast.makeText(MainActivity.this, "กรุณาใส่ช้อมูลให้ครบทุกช่อง",
                    Toast.LENGTH_LONG).show();
        }
        else {
            mid = Float.parseFloat(midText.getText().toString());
            fi = Float.parseFloat(finalText.getText().toString());
            home = Float.parseFloat(homeworkText.getText().toString());
            if (mid > 30){
                Toast.makeText(MainActivity.this, "คะแนนกลางภาคต้องไม่เกิน 30 คะแนน",
                        Toast.LENGTH_LONG).show();
            }
            else if(fi > 40){
                Toast.makeText(MainActivity.this, "คะแนนปลายภาคต้องไม่เกิน 40 คะแนน",
                        Toast.LENGTH_LONG).show();
            }
            else if(home > 30){
                Toast.makeText(MainActivity.this, "คะแนนการบ้านต้องไม่เกิน 30 คะแนน",
                        Toast.LENGTH_LONG).show();
            }
            else {
                sum = mid+fi+home;
                sumShow.setText(sumShow.getText().toString() + " " + sum);
                if (sum > 80){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "A");
                }
                else if(sum >= 75 && sum < 80 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "B+");
                }
                else if(sum >= 70 && sum < 75 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "B");
                }
                else if(sum >= 65 && sum < 70 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "C+");
                }
                else if(sum >= 60 && sum < 65 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "C");
                }
                else if(sum >= 55 && sum < 60 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "D+");
                }
                else if(sum >= 50 && sum < 55 ){
                    gradeShow.setText(gradeShow.getText().toString() + " " + "D");
                }
                else {
                    gradeShow.setText(gradeShow.getText().toString() + " " + "F");
                }
            }
        }
    }
}