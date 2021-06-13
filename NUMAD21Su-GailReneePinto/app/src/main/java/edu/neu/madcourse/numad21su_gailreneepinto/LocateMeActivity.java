package edu.neu.madcourse.numad21su_gailreneepinto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocateMeActivity extends AppCompatActivity implements LocationListener {

    public TextView mLatitude;
    public TextView mLongitude;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_locate_me );
        mLatitude = findViewById( R.id.latitude_textview );
        mLongitude = findViewById( R.id.longitude_textview );
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            String permission[] = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(LocateMeActivity.this,
                    permission, 1);
        }
        else {
                initLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults){
        super.onRequestPermissionsResult( requestCode,permissions,grantResults );
        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(LocateMeActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                        initLocation();
                    }
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            default:
                //TODO : Add error message
                break;
        }
    }

    private void initLocation() {
        try {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            String locProvider = locationManager.getBestProvider(criteria, true);
            if (locProvider != null) {
                locationManager.requestLocationUpdates(locProvider,30000, 0, (LocationListener) this);
            }
        } catch (SecurityException ignored) {}
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        mLatitude.setText( "Latitude : " + String.valueOf(location.getLatitude()) );
        mLongitude.setText("Longitude : " + String.valueOf(location.getLongitude()) );
    }

    /*@Override
    /public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }*/
}