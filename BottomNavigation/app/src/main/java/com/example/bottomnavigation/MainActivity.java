package com.example.bottomnavigation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(

                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch(item.getItemId()) {
                            case R.id.home :
                                textView.setText("Home Activity");
                                break;
                            case R.id.camera:
                                textView.setText("Camera Activity");
                                break;
                            case R.id.profile:
                                textView.setText("Profile Activity");
                                break;
                        }
                        return true;
                    }
                });
    }
}
