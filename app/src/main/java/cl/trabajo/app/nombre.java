package cl.trabajo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nombre extends AppCompatActivity {

    public void siguiente(View view) {
        Intent intent5 = new Intent(nombre.this, nombredos.class);
        startActivity(intent5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);
    }
}