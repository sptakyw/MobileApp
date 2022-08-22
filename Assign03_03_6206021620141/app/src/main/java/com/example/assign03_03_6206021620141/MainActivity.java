//6206021620141 นางสาว สุพัทตรา อากิยวงศ์ IT3RA

package com.example.assign03_03_6206021620141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    EditText nameText,lastText,ageText,dayText,monthText,yearText;
    TextView show;
    private Button btnOK;
    private RadioButton frontRadio1,frontRadio2,frontRadio3,frontRadio4,frontRadio5,boyRadio,girlRadio,otherRadio;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private RadioGroup frontRadio,ageRadio;
    String front = "";
    String sex = "";
    String work = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = (EditText) findViewById(R.id.nameText);
        lastText = (EditText) findViewById(R.id.lastnameText);
        ageText = (EditText) findViewById(R.id.ageText);
        dayText = (EditText) findViewById(R.id.dayText);
        monthText = (EditText) findViewById(R.id.monthText);
        yearText = (EditText) findViewById(R.id.yearText);
        show = (TextView) findViewById(R.id.show);
        btnOK = (Button) findViewById(R.id.btnOK);
        frontRadio1 = (RadioButton) findViewById(R.id.frontRadio1);
        frontRadio2 = (RadioButton) findViewById(R.id.frontRadio2);
        frontRadio3 = (RadioButton) findViewById(R.id.frontRadio3);
        frontRadio4 = (RadioButton) findViewById(R.id.frontRadio4);
        frontRadio5 = (RadioButton) findViewById(R.id.frontRadio5);
        boyRadio = (RadioButton) findViewById(R.id.boyRadio);
        girlRadio = (RadioButton) findViewById(R.id.girlRadio);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
    }
    public void onClick(View v) {
        if(!frontRadio1.isChecked() && !frontRadio2.isChecked() && !frontRadio3.isChecked() && !frontRadio4.isChecked() && !frontRadio5.isChecked() ){
            Toast.makeText(MainActivity.this, "กรุณาเลือกคำนำหน้า",
                    Toast.LENGTH_LONG).show();
        }
        else if(nameText.getText().length() == 0){
            Toast.makeText(MainActivity.this, "กรุณาใส่ชื่อ",
                    Toast.LENGTH_LONG).show();
        }
        else if(lastText.getText().length() == 0){
            Toast.makeText(MainActivity.this, "กรุณาใส่นามสกุล",
                    Toast.LENGTH_LONG).show();
        }
        else if(!boyRadio.isChecked() && !girlRadio.isChecked() && !otherRadio.isChecked()){
            Toast.makeText(MainActivity.this, "กรุณาเลือกเพศ",
                    Toast.LENGTH_LONG).show();
        }
        else if(ageText.getText().length()==0){
            Toast.makeText(MainActivity.this, "กรุณาใส่อายุ",
                    Toast.LENGTH_LONG).show();
        }
        else if(dayText.getText().length()==0){
            Toast.makeText(MainActivity.this, "กรุณาระบุวันเกิด",
                    Toast.LENGTH_LONG).show();
        }
        else if(monthText.getText().length()==0){
            Toast.makeText(MainActivity.this, "กรุณาระบุเดือนเกิด",
                    Toast.LENGTH_LONG).show();
        }
        else if(yearText.getText().length()==0){
            Toast.makeText(MainActivity.this, "กรุณาระบุปีเกิด",
                    Toast.LENGTH_LONG).show();
        }
        else if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()){
            Toast.makeText(MainActivity.this, "กรุณาเลือกงานอดิเรก",
                    Toast.LENGTH_LONG).show();
        }
        else {
            if(frontRadio1.isChecked())  front = "เด็กหญิง";
            else if(frontRadio2.isChecked()) front = "เด็กชาย";
            else if(frontRadio3.isChecked()) front = "นางสาว";
            else if(frontRadio4.isChecked()) front = "นาย";
            else if(frontRadio5.isChecked()) front = "นาง";

            if (boyRadio.isChecked()) sex = "ชาย";
            else if (girlRadio.isChecked()) sex = "หญิง";
            else if (otherRadio.isChecked()) sex = "ไม่ระบุ";

            if (checkBox1.isChecked()) work = "วาดรูป";
            else if (checkBox2.isChecked()) work += " ฟังเพลง";
            else if (checkBox3.isChecked()) work += " ทำอาหาร";
            else if (checkBox4.isChecked()) work += " เล่นเกม";

            show.setText(show.getText().toString() +"ชื่อ : "+front + nameText.getText() + " " + lastText.getText()
                    + "\n" + "เพศ : " + sex
                    +"\n"+ "อายุ : " + ageText.getText() + " ปี"
                    + "\n"+ "วันเกิด : " + dayText.getText() + "/" + monthText.getText() + "/" +yearText.getText()
                    + "\n" + "งานอดิเรก : " + work);
        }
    }
}
