package com.seulki.mapansan;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.seulki.mapansan.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private  int MY_LOCATION_REQUEST_CODE = 1;


    private ActivityMapsBinding binding;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permission.length == 1 &&
                    permission[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                                PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 1);
                }
                mMap.setMyLocationEnabled(true);
            }
        }
    }

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

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        LatLng tour = new LatLng(37.326518,126.814262);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("화랑유원지")
                .snippet("")
        );

        tour = new LatLng(37.273347, 126.839341);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("안산갈대습지공원")
                .snippet("")
        );

        tour = new LatLng(37.339579, 126.863395);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("별빛마을포토랜드")
                .snippet("")
        );

        tour = new LatLng(37.283447, 126.578113);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("대부도바다향기테마파크")
                .snippet("")
        );

        tour = new LatLng(37.187126, 126.632282);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("누에섬")
                .snippet("")
        );

        tour = new LatLng(37.300649, 126.823277);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("안산호수공원")
                .snippet("")
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(tour));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tour,10));

    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location;\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }



}