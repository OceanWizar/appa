package cl.trabajo.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class menu extends AppCompatActivity {
    private List<persona> listperson = new ArrayList<>();
    ArrayAdapter<persona> arrayAdapterpersona;


    EditText nomP, correoP,passwordP;
    ListView listV_persona;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nomP = findViewById(R.id.txt_usuario);
        correoP = findViewById(R.id.txt_gmail);
        passwordP = findViewById(R.id.txt_contra);

        listV_persona = findViewById(R.id.list);
        inicializarFirebase();
        listarDatos();

    }

    private void listarDatos() {
        databaseReference.child("persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listperson.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    persona p = objSnapshot.getValue(persona.class);
                    listperson.add(p);

                    arrayAdapterpersona = new ArrayAdapter<persona>(menu.this, android.R.layout.simple_list_item_1, (List<persona>) listV_persona);
                    listV_persona.setAdapter(arrayAdapterpersona);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String usuario = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String contra = passwordP.getText().toString();

        switch (item.getItemId()){
            case R.id.ic_add: {
                if (usuario.equals("")) {
                    validacion();
                } else {
                    persona p = new persona();
                    p.setUid(UUID.randomUUID().toString());
                    p.setNombre_Usuario(usuario);
                    p.setGmail(correo);
                    p.setContra(contra);
                    databaseReference.child("persona").child(p.getUid()).setValue(p);

                    Toast.makeText(this, "Agregar", Toast.LENGTH_LONG).show();
                    limpiarcajas();
                }
                break;
            }
            case R.id.ic_save:{
                Toast.makeText(this, "Guardar", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.ic_delete:{
                Toast.makeText(this, "Eliminar", Toast.LENGTH_LONG).show();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarcajas() {
        nomP.setText("");
        correoP.setText("");
        passwordP.setText("");
    }

    private void validacion() {
        String usuario = nomP.getText().toString();
        String correo = correoP.getText().toString();
        String contra = passwordP.getText().toString();
        if (usuario.equals("")){
            nomP.setError("Required");
        }
        else if (correo.equals("")){
            correoP.setError("Required");
        }
        else if (contra.equals("")){
            passwordP.setError("Required");
        }
    }
}