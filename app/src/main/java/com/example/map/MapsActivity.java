package com.example.map;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        View view = new View(getApplicationContext());
        view.invalidate();
        view.requestLayout();
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
    public void onMapReady(final GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        mMap = googleMap;

//        googleMap.clear();

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                googleMap.clear();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                double lat = latLng.latitude;
                double lng =latLng.longitude;
                Toast.makeText(getBaseContext(),  lat + ", " +  lng, Toast.LENGTH_SHORT).show();



                if(lat>31.328117&& lat<31.437279)
                if (lng>34.215612&&lng<35.687089)
                {
                    LatLng pal = new LatLng(lat, lng);

                    googleMap.addMarker(new MarkerOptions().position(pal)
                            .title("My home Palestine"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(pal));

                }

                LatLng sydney = new LatLng(lat, lng);

                googleMap.addMarker(new MarkerOptions().position(sydney)
                        .title("hello"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        });








    }


}
