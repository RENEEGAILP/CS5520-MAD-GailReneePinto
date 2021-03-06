package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.about_button:
                TextView about = findViewById(R.id.about_textView);
                if(about.getVisibility() == View.INVISIBLE) {
                    about.setVisibility(View.VISIBLE);
                    about.postDelayed(() -> about.setVisibility(View.INVISIBLE), 15000);
                }
                break;
            case R.id.clickhere_button:
                Intent ClickyClick_intent = new Intent(this, ClickyClickyActivity.class);
                startActivity(ClickyClick_intent);
                break;
            case R.id.linkcollector_button:
                Intent linkCollector_intent = new Intent(this,LinkCollectorActivity.class);
                startActivity(linkCollector_intent);
                break;
            case R.id.locateme_button:
                Intent locateme_intent = new Intent(this,LocateMeActivity.class);
                startActivity(locateme_intent);
                break;
            case R.id.webservice_button:
                Intent webservice_intent = new Intent(this,WebServiceActivity.class);
                startActivity(webservice_intent);
                break;
        }
    }
}