package com.example.registroestudiante;

import android.content.Intent;
import android.os.Bundle;
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

        //  BOTÓN GUARDAR
        btnguardar.setOnClickListener(v -> {
            String name = txtnombre.getText().toString().trim();
            String lastname = txtapellido.getText().toString().trim();
            String ageText = txtedad.getText().toString().trim();
            String email = txtcorreo.getText().toString().trim();
            String carrer = txtcarrera.getText().toString().trim();

            // Valir que los campos esten completos
            if (name.isEmpty() || lastname.isEmpty() || ageText.isEmpty() || email.isEmpty() || carrer.isEmpty()) {
                Toast.makeText(MainActivity.this, " Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convertimos edad a número (ya que pasó la validación)
            int age = Integer.parseInt(ageText);

            // Insertar registro en la base de datos
            long idnuevo = studentsDatabase.insertStudents(name, lastname, age, email, carrer);
            if (idnuevo != -1) {
                Toast.makeText(MainActivity.this, " Se ingresó correctamente", Toast.LENGTH_LONG).show();

                // Limpiar los campos después de guardar
                txtnombre.setText("");
                txtapellido.setText("");
                txtedad.setText("");
                txtcorreo.setText("");
                txtcarrera.setText("");

            } else {
                Toast.makeText(MainActivity.this, " Hubo un error al ingresar", Toast.LENGTH_LONG).show();
            }
        });

        // 🔹 BOTÓN SALIR
        Button btnsalir = findViewById(R.id.btnsalir);
        btnsalir.setOnClickListener(v -> finish());

        // 🔹 BOTÓN MOSTRAR REGISTROS
        Button btnmostrar = findViewById(R.id.btnmostrar);
        btnmostrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(intent);
        });
    }
}
