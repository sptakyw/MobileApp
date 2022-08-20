package com.example.appsimpletoast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    Toast toastSimple;
    RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4, radioBtn5, radioBtn6;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toastSimple = Toast.makeText(this,"This simple Toast",

                Toast.LENGTH_SHORT);

        radioBtn1 = (RadioButton) findViewById(R.id.radioButton1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioButton2);
        radioBtn3 = (RadioButton) findViewById(R.id.radioButton3);
        radioBtn4 = (RadioButton) findViewById(R.id.radioButton4);
        radioBtn5 = (RadioButton) findViewById(R.id.radioButton5);
        radioBtn6 = (RadioButton) findViewById(R.id.radioButton6);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (radioBtn1.isChecked()) {
            toastSimple.setText("Display Top");
            toastSimple.setGravity(Gravity.TOP, 0, 0);
        }
        else if (radioBtn2.isChecked()) {
            toastSimple.setText("Display Left");
            toastSimple.setGravity(Gravity.LEFT, 0, 0);
        }
        else if (radioBtn3.isChecked()) {
            toastSimple.setText("Display Center");
            toastSimple.setGravity(Gravity.CENTER, 0, 0);
        }
        else if (radioBtn4.isChecked()) {
            toastSimple.setText("Display Right");
            toastSimple.setGravity(Gravity.RIGHT, 0, 0);
        }
        else if (radioBtn5.isChecked()) {
            toastSimple.setText("Display Bottom");
            toastSimple.setGravity(Gravity.BOTTOM, 0, 0);
        }
        else if (radioBtn6.isChecked()) {
            toastSimple.setText("Display Top and Right");
            toastSimple.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
        }
        toastSimple.show();
    }
}