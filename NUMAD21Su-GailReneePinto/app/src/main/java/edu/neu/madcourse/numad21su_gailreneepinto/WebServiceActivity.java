package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class WebServiceActivity extends AppCompatActivity {

    ImageView HTTPResponseImageView;
    Button loadDataButton;
    EditText HTTPStatusCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web_service );
        HTTPResponseImageView = findViewById( R.id.http_image );
        loadDataButton = findViewById( R.id.HTTP_status_load_image_button );
        HTTPStatusCodeEditText = findViewById( R.id.HTTP_status_code_input_editText );
    }

    protected void onLoadDataButtonClick(View view)
    {

    }
}