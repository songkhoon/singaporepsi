package com.songkhoon.singaporepsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.SupportMapFragment;
import com.songkhoon.singaporepsi.contoller.GoogleMapController;
import com.songkhoon.singaporepsi.model.PSIModel;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private GoogleMapController googleMapController;

    @Inject
    PSIModel psiModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        googleMapController = new GoogleMapController(this, mapFragment, psiModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_refresh:
                googleMapController.updatePSIData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
