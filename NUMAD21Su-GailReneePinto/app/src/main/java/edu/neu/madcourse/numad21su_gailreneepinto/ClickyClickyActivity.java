package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyClickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky_clicky);
        findViewById(R.id.button_A).setOnClickListener(this::onClick);
        findViewById(R.id.button_B).setOnClickListener(this::onClick);
        findViewById(R.id.button_C).setOnClickListener(this::onClick);
        findViewById(R.id.button_D).setOnClickListener(this::onClick);
        findViewById(R.id.button_E).setOnClickListener(this::onClick);
        findViewById(R.id.button_F).setOnClickListener(this::onClick);

    }

    public void onClick(View view)
    {
        TextView textView = findViewById(R.id.pressed_textView);
        Button button_pressed = findViewById(view.getId());
        textView.setText("Button Pressed : " + button_pressed.getText().toString());
        textView.setVisibility(View.VISIBLE);
    }


}