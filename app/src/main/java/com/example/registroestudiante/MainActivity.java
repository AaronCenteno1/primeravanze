package com.example.registroestudiante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.registroestudiante.db.StudentsDatabase;

public class MainActivity extends AppCompatActivity {

    StudentsDatabase studentsDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        studentsDatabase = new StudentsDatabase(this);

        EditText txtnombre = findViewById(R.id.txtnombre);
        EditText txtapellido = findViewById(R.id.txtapellido);
        EditText txtedad = findViewById(R.id.txtedad);
        EditText txtcorreo = findViewById(R.id.txtcorreo);
        EditText txtcarrera = findViewById(R.id.txtcarrer);
        Button btnguardar = findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(v -> {
            String name = txtnombre.getText().toString();
            String lastname = txtapellido.getText().toString();
            int age = Integer.parseInt(txtedad.getText().toString());
            String email = txtcorreo.getText().toString();
            String carrer = txtcarrera.getText().toString();

            long idnuevo = studentsDatabase.insertStudents(name, lastname,age,email,carrer);
            if (idnuevo != -1){
                Toast.makeText(MainActivity.this,"se ingreso correctamente",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(MainActivity.this,"hubo un error al ingresar",Toast.LENGTH_LONG).show();
            }
        });

        Button btnsalir = findViewById(R.id.btnsalir);
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnmostrar = findViewById(R.id.btnmostrar);
        btnmostrar.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this,InformationActivity.class);
            startActivity(intent);
        });
    }
}