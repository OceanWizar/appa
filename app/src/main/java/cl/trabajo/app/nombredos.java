package cl.trabajo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nombredos extends AppCompatActivity {

    public void atras(View view) {
        Intent intent7 = new Intent(nombredos.this, nombre.class);
        startActivity(intent7);
    }
    public void inicio(View view) {
        Intent intent8 = new Intent(nombredos.this, lugares.class);
        startActivity(intent8);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombredos);
    }
}