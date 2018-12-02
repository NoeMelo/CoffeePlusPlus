package com.example.laboratorioesan.ilunch;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng Ratatoille = new LatLng(-12.100666, -76.969513);
    private static final LatLng LaSirenita = new LatLng(-12.107635, -76.968566);
    private static final LatLng ElRocoto = new LatLng(-12.104640, -76.962473);
    private static final LatLng mipos = new LatLng(-12.104139, -76.961984);

    private Marker mRatatoille;
    private Marker mLaSirenita;
    private Marker mElRocoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        mRatatoille = mMap.addMarker(new MarkerOptions()

                .position(Ratatoille)
                .title("Ratatoille")
                .snippet("Pasta a Motones")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.polleria))
        );
        mRatatoille.setTag(1);

        mLaSirenita = mMap.addMarker(new MarkerOptions()

                .position(LaSirenita)
                .title("La Sirenita")
                .snippet("Cebiche a Montones")

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pescado))
        );
        mLaSirenita.setTag(2);

        mElRocoto = mMap.addMarker(new MarkerOptions()

                .position(ElRocoto)
                .title("El Rocoto")
                .snippet("Carne pero mucha carne")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.carne))
        );
        mElRocoto.setTag(3);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String id;
                //id = marker.getTitle().toString();
                id = marker.getTag().toString();
                Intent intent = new Intent(getApplicationContext(),ClienteActivity.class); //Aqui está llamando a la otra vista
                intent.putExtra("IdRestaurante",id);
                startActivity(intent);
                return false;
            }
        });
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mipos,16));
    }
}
