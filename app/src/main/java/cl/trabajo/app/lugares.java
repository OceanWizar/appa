package cl.trabajo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lugares extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    public void Mapa(View view) {
        Intent intent3 = new Intent(lugares.this, Mapa.class);
        startActivity(intent3);
        myRef.setValue("Ingreso al mapa");
    }
    public void lugaress(View view) {
        Intent intent3 = new Intent(lugares.this, nombre.class);
        startActivity(intent3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
    }
}