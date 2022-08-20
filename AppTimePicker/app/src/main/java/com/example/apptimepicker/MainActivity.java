package com.example.apptimepicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements
        TimePicker.OnTimeChangedListener, View.OnClickListener {
    private TimePicker timePicker;
    private Button btnSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(this);
        btnSet = (Button) findViewById(R.id.button);
        btnSet.setOnClickListener(this);
    }
    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, hourOfDay+":"+minute,
                Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        String time = "";
        time = timePicker.getHour() + ":" + timePicker.getMinute();
        Toast.makeText(this, "You set time : " + time,

                Toast.LENGTH_SHORT).show();

    }
}