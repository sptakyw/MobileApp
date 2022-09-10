package com.example.basicloginapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnLogin, btnClear;
    EditText usernameText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(this,
                "Username : "+usernameText.getText().toString()+
                        "\nPassword:"+passwordText.getText().toString(),

                Toast.LENGTH_SHORT).show();
    }
}