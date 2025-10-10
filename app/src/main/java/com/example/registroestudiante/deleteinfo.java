package com.example.registroestudiante;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registroestudiante.db.StudentsDatabase;

public class deleteinfo extends AppCompatActivity {

    private StudentsDatabase studentsDatabase;
    private int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deleteinfo);

        studentsDatabase = new StudentsDatabase(this);

        // Referencias a los EditText del layout
        EditText txtnombre = findViewById(R.id.edtFirstname);
        EditText txtapellido = findViewById(R.id.edtLastname);
        EditText txtedad = findViewById(R.id.edtAge);
        EditText txtcorreo = findViewById(R.id.edtEmail);
        EditText txtcarrera = findViewById(R.id.edtCarrer);

        // Botones
        Button btnactualizar = findViewById(R.id.btnupdate);
        Button btneliminar = findViewById(R.id.btndelete);

        // Obtener el ID pasado desde InformationActivity
        studentId = getIntent().getIntExtra("STUDENT_ID", -1);


        // Botón para actualizar
        btnactualizar.setOnClickListener(v -> {
            String nombre = txtnombre.getText().toString();
            String apellido = txtapellido.getText().toString();
            int edad = Integer.parseInt(txtedad.getText().toString());
            String correo = txtcorreo.getText().toString();
            String carrera = txtcarrera.getText().toString();

            boolean actualizado = studentsDatabase.updateStudent(studentId, nombre, apellido, edad, correo, carrera);
            if (actualizado) {
                Toast.makeText(deleteinfo.this, "Estudiante actualizado correctamente", Toast.LENGTH_SHORT).show();
                finish(); // Cierra la activity
            } else {
                Toast.makeText(deleteinfo.this, "Error al actualizar el estudiante", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para eliminar
        btneliminar.setOnClickListener(v -> {
            boolean eliminado = studentsDatabase.deleteStudent(studentId);
            if (eliminado) {
                Toast.makeText(deleteinfo.this, "Estudiante eliminado correctamente", Toast.LENGTH_SHORT).show();
                finish(); // Cierra la activity
            } else {
                Toast.makeText(deleteinfo.this, "Error al eliminar el estudiante", Toast.LENGTH_SHORT).show();
            }
        });
    }
}