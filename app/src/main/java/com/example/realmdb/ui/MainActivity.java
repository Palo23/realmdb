package com.example.realmdb.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.realmdb.R;
import com.example.realmdb.crud.CrudProfesor;
import com.example.realmdb.model.Profesor;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {


    private EditText nombreProfesor, emailProfesor;
    private Button guardarProfesor, mostrarProfesores, buscarProfesor, buscarProfesorID;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView(){
        profesor = new Profesor();
        nombreProfesor = findViewById(R.id.edtNombreProfesor);
        emailProfesor = findViewById(R.id.edtEmailProfesor);
        guardarProfesor = findViewById(R.id.btnSaveProfesor);

        guardarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombreProfesor.getText().toString());
                profesor.setEmail(emailProfesor.getText().toString());
                CrudProfesor.addProfesor(profesor);
                Toast.makeText(getApplicationContext(), "Guardado con éxito", Toast.LENGTH_SHORT).show();
                nombreProfesor.setText("");
                emailProfesor.setText("");
            }
        });
        mostrarProfesores = findViewById(R.id.btnShowProfesor);
        mostrarProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrudProfesor.getAllProfesor();
            }
        });
        buscarProfesor = findViewById(R.id.btnFindProfesor);
        buscarProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrudProfesor.getProfesorByName(nombreProfesor.getText().toString());
            }
        });
        buscarProfesorID = findViewById(R.id.btnFindProfesorID);
        buscarProfesorID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrudProfesor.getProfesorByID(Integer.parseInt(nombreProfesor.getText().toString()));
            }
        });
    }
}
