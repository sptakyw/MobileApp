package com.example.bottomsheets;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    Button button;
    BottomSheetBehavior mBottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bottomsheet = findViewById(R.id.bottomSheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBottomSheetBehavior.getState() !=
                        BottomSheetBehavior.STATE_EXPANDED) {

                    mBottomSheetBehavior.setState(

                            BottomSheetBehavior.STATE_EXPANDED);

                    button.setText("Collapse Sheet");
                }
                else {
                    mBottomSheetBehavior.setState(

                            BottomSheetBehavior.STATE_COLLAPSED);

                    button.setText("Expand Sheet");
                }
            }
        });
    }
}