package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAboutClick(View view) {
        TextView about = (TextView)findViewById(R.id.about_textView);
        if(about.getVisibility() == View.INVISIBLE) {
            about.setVisibility(View.VISIBLE);
            about.postDelayed(() -> about.setVisibility(View.INVISIBLE), 15000);
        }
    }
}