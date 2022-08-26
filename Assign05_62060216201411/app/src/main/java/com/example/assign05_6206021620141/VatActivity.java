package com.example.assign05_6206021620141;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VatActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack2 , btnCalVat;
    TextView ShowPrice,ShowVat,ShowTotal;
    EditText numPrice;
    float price , vat , total ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat);
        ShowPrice = (TextView) findViewById(R.id.textCredite);
        ShowVat = (TextView) findViewById(R.id.textPointGpa);
        ShowTotal = (TextView) findViewById(R.id.textTotal);
        numPrice = (EditText) findViewById(R.id.numPrice);
        btnCalVat = (Button) findViewById(R.id.btnCalVat );
        btnCalVat.setOnClickListener(this);
        btnBack2 = (Button) findViewById(R.id.btnBack2);
        btnBack2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnCalVat){
            ShowPrice.setText("");
            ShowVat.setText("");
            ShowTotal.setText("");
            if(numPrice.getText().length() == 0){
                Toast.makeText( VatActivity.this,
                        " Please enter Price. ",Toast.LENGTH_SHORT).show();
            }
            else {
            price = Float.parseFloat(numPrice.getText().toString());
            vat = price*7/100;
            total = price+vat;
            ShowPrice.setText(ShowPrice.getText().toString() + price);
            ShowVat.setText(ShowVat.getText().toString() + vat);
            ShowTotal.setText(ShowTotal.getText().toString() + total);}
        }
        else if(id == R.id.btnBack2){
            Toast.makeText( VatActivity.this,
                    " Out of Calculate VAT ",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}