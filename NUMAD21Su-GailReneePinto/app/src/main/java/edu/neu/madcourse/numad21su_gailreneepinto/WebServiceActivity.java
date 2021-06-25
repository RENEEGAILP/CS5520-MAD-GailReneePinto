package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WebServiceActivity extends AppCompatActivity {

    ImageView HTTPResponseImageView;
    Button loadDataButton;
    EditText HTTPStatusCodeEditText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web_service );
        HTTPResponseImageView = findViewById( R.id.http_image );
        loadDataButton = findViewById( R.id.HTTP_status_load_image_button );
        HTTPStatusCodeEditText = findViewById( R.id.HTTP_status_code_input_editText );
        loadDataButton.setOnClickListener( this::onLoadDataButtonClick );
        progressBar = findViewById( R.id.progressBar2 );
    }

    public void onLoadDataButtonClick(View view)
    {
        WebServiceTask webServiceTask = new WebServiceTask();
        webServiceTask.execute(  );
    }

    private class WebServiceTask extends AsyncTask<Void, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
       protected Bitmap doInBackground(Void... voids) {
            String url = "https://http.cat/";
            String lHTTPStatusCode = HTTPStatusCodeEditText.getText().toString();
            if(lHTTPStatusCode.isEmpty())
            {
                lHTTPStatusCode = "404";
            }
            Bitmap bitmap = null;
            try {
                URL httpStatusURL =new URL(url+ lHTTPStatusCode +".jpg");
                HttpURLConnection conn = (HttpURLConnection) httpStatusURL.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                conn.setDoInput(true);
                conn.connect();

                InputStream inputStream = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute( result );
            progressBar.setVisibility( View.INVISIBLE );
            HTTPResponseImageView.setImageBitmap( result );
        }
    }

}

