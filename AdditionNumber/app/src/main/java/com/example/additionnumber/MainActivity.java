//6206021620141 นางสาวสุพัทตรา อากิยวงศ์ IT3RA
package com.example.additionnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText decTextE;
    private EditText decTextE1;
    private TextView ResumT;
    private TextView MinT;
    private TextView MaxT;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decTextE = (EditText) findViewById(R.id.decText);
        decTextE1 = (EditText) findViewById(R.id.decText1);
        ResumT = (TextView) findViewById(R.id.ReSum);
        MinT = (TextView) findViewById(R.id.Min);
        MaxT = (TextView) findViewById(R.id.Max);
        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (decTextE.getText().length() == 0 && decTextE1.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "please enter number!",
                            Toast.LENGTH_LONG).show();
                } else if (decTextE.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "please enter number1!",
                            Toast.LENGTH_LONG).show();
                } else if (decTextE1.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "please enter number2!",
                            Toast.LENGTH_LONG).show();
                } else {
                    float Num;
                    float Num1;
                    Num = Float.parseFloat(decTextE.getText().toString());
                    Num1 = Float.parseFloat(decTextE1.getText().toString());
                    if (Num == 0 && Num1 == 0) {
                        Toast.makeText(MainActivity.this, "unable to calculate!",
                                Toast.LENGTH_LONG).show();
                    } else if (Num != 0 && Num1 != 0) {
                        Num = Float.parseFloat(decTextE.getText().toString());
                        Num1 = Float.parseFloat(decTextE1.getText().toString());
                        String ReSum = "";
                        ReSum = SumTO(Num, Num1);
                        ResumT.append(ReSum);
                        String Min = "";
                        Min = Minto(Num, Num1);
                        MinT.append(Min);
                        String Max = "";
                        Max = Maxto(Num, Num1);
                        MaxT.append(Max);
                    }
                }
            }
        });
    }

    private String SumTO(float Num, float Num1) {
        String str = "";
        float s = Num + Num1;
        str = str + s;
        return (str);
    }

    private String Minto(float Num, float Num1) {
        String strMin = "";
        float s;
        if (Num < Num1)
            s = Num;
        else
            s = Num1;
        strMin = strMin + s;
        return (strMin);
    }

    private String Maxto(float Num, float Num1) {
        String strMax = "";
        float s;
        if (Num > Num1)
            s = Num;
        else
            s = Num1;
        strMax = strMax + s;
        return (strMax);
    }
}
