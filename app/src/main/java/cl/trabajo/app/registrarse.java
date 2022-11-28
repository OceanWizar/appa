package cl.trabajo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void iniciar_sesion(View view){
        Intent intent2 = new Intent(registrarse.this, MainActivity.class);
        startActivity(intent2);

    }


}