package com.example.googlemapnavigator;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapnavigator.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        double startLatitude=-34;
        double startLongitude=151;
        double endLatitude=-27;
        double endLongitude=153;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(startLatitude, startLongitude);
        //mMap is a google map object
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //call class LatLng
        //object brisbane
        LatLng brisbane = new LatLng(endLatitude, endLongitude);
        mMap.addMarker(new MarkerOptions().position(brisbane).title("Marker in brisbane"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(startLatitude,startLongitude),15.0f));

        //calculate distance between two places
        float [] results=new float[1];
        Location.distanceBetween(startLatitude,startLongitude,endLatitude,endLongitude,results);
        float distance= results[0];
        //distance in Kilometres
        int kilometers= (int) (distance/1000);
        Toast.makeText(this,String.valueOf(kilometers)+"KM",Toast.LENGTH_SHORT).show();


    }
}