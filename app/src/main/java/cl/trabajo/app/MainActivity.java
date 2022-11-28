package cl.trabajo.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);


    }
    public void registrarse(View view) {
        Intent intent = new Intent(MainActivity.this, registrarse.class);
        startActivity(intent);

    }
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    public void mapa(View view) {
        Intent intent1 = new Intent(MainActivity.this, Mapa.class);
        startActivity(intent1);
        myRef.setValue("Ingreso al Mapa");
    }


    @Override

    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng chillan = new LatLng(-36.60787975863577, -72.10238905258322);
        googleMap.addMarker(new MarkerOptions().position(chillan).title("Chillan"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(chillan));

    }
}