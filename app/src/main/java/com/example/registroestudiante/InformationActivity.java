package com.example.registroestudiante;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.registroestudiante.db.StudentsDatabase;

import java.util.List;

public class InformationActivity extends AppCompatActivity {

    private ListView listrecord;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informacion);

        listrecord = findViewById(R.id.listrecord);
        showdata();
        //boton para regresar  al menu principal
        Button btnmain = findViewById(R.id.btnmain);
        btnmain.setOnClickListener(v -> {
            Intent intent = new Intent(InformationActivity.this,MainActivity.class);
            startActivity(intent);
        } );

        // Evento al hacer clic en un item de la lista
        listrecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                // Obtenemos el texto del elemento seleccionado
                String selectedItem = list.get(position);

                // Extraemos el ID (la primera línea del string)
                String idLine = selectedItem.split("\n")[0];
                int studentId = Integer.parseInt(idLine.trim());

                // Creamos el intent y pasamos el ID
                Intent intent = new Intent(InformationActivity.this, deleteinfo.class);
                intent.putExtra("STUDENT_ID", studentId);
                startActivity(intent);
            }

        });
    }

    //función para mostrar datos
    public void showdata() {
        list = StudentsDatabase.callList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        listrecord.setAdapter(adapter);
    }
// funcion que vuelve a cargar los datos cada vez que la activity se muestre
    @Override
    protected void onResume() {
        super.onResume();
        showdata();
    }

}