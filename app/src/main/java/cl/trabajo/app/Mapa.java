package cl.trabajo.app;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.trabajo.app.databinding.ActivityMapaBinding;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cl.trabajo.app.databinding.ActivityMapaBinding binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
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


        LatLng plaza_de_armas = new LatLng(-36.606776355238225, -72.10329349835753);
        LatLng teatro_municipal = new LatLng(-36.60686546958592, -72.10429402096231);
        LatLng intituto_de_musica = new LatLng(-36.60567269585235, -72.10973590346141);
        LatLng museo_claudio_arrau = new LatLng(-36.605903954145845, -72.10737533339201);
        LatLng escuela_de_arte = new LatLng(-36.604533889859525, -72.10170555732452);
        LatLng pasarela_chillan = new LatLng(-36.60834302271183, -72.10319824148417);

        googleMap.addMarker(new MarkerOptions().position(plaza_de_armas).title("plaza_de_armas"));
        googleMap.addMarker(new MarkerOptions().position(teatro_municipal).title("teatro_municipal"));
        googleMap.addMarker(new MarkerOptions().position(intituto_de_musica).title("intituto_de_musica "));
        googleMap.addMarker(new MarkerOptions().position(museo_claudio_arrau).title("museo_claudio_arrau "));
        googleMap.addMarker(new MarkerOptions().position(escuela_de_arte).title("escuela_de_arte"));
        googleMap.addMarker(new MarkerOptions().position(pasarela_chillan).title("pasarela_chillan"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plaza_de_armas, 15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teatro_municipal, 15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(intituto_de_musica, 15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(museo_claudio_arrau, 15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(escuela_de_arte, 15));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pasarela_chillan, 15));
    }
}