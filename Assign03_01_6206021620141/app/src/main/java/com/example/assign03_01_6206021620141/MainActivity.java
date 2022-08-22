//6206021620141 นางสาว สุพัทตรา อากิยวงศ์ IT3RA

package com.example.assign03_01_6206021620141;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    EditText numText;
    private RadioButton binaryRadio, OctalRadio, HexaRadio;
    private Button btnChange;
    private RadioGroup radioGrp;
    TextView showText;
    private int dec;
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numText = (EditText) findViewById(R.id.numText);
        binaryRadio = (RadioButton) findViewById(R.id.binaryRadio);
        OctalRadio = (RadioButton) findViewById(R.id.octalRadio);
        HexaRadio = (RadioButton) findViewById(R.id.hexaRadio);
        radioGrp = (RadioGroup) findViewById(R.id.RadioGroup);
        btnChange = (Button) findViewById(R.id.btnChange);
        showText = (TextView) findViewById(R.id.showText2);
        btnChange.setOnClickListener(this);
    }

    private String decToBin(int dec) {
        String str1 = "";
        while (dec > 0) {
            dec = dec / 2;
            int f = dec%2;
            str1 = str1+f;
        }
        return(str1);
    }
    private String decToOc(int dec) {
        int rem;
        String str2="";
        char dig[]={'0','1','2','3','4','5','6','7'};

        while(dec>0)
        {
            rem=dec%8;
            str2=dig[rem]+str2;
            dec=dec/8;
        }
        return(str2);
    }
    private String decToHex(int dec) {
        int rem;
        String str3="";
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(dec>0)
        {
            rem=dec%16;
            str3=hex[rem]+str3;
            dec=dec/16;
        }
        return(str3);
    }
    public void onClick(View v) {
        if (numText.getText().length() == 0 ){
            Toast.makeText(MainActivity.this, "Please enter Number",
                    Toast.LENGTH_LONG).show();
        }
        else if(!binaryRadio.isChecked() && !OctalRadio.isChecked() && !HexaRadio.isChecked()){
            Toast.makeText(MainActivity.this, "Please Checkbox",
                    Toast.LENGTH_LONG).show();
        }
        else {
            dec = Integer.parseInt(numText.getText().toString());
            showText.setText(showText.getText().toString() + "\n" +"Decimal : "+ dec);
            if(binaryRadio.isChecked()){
                String binText = "";
                binText = decToBin(dec);
                showText.setText(showText.getText().toString() + "\n" + "Binary : "  + binText);
            }
            else if(OctalRadio.isChecked()){
                String ocText = "";
                ocText = decToOc(dec);
                showText.setText(showText.getText().toString() + "\n" + "Octal : "  + ocText);
            }
            else if(HexaRadio.isChecked()){
                String hexText = "";
                hexText = decToHex(dec);
                showText.setText(showText.getText().toString() + "\n" + "Hexa : "  + hexText);
            }
        }
    }
}

