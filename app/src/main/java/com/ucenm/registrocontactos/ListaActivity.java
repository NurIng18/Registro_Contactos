package com.ucenm.registrocontactos;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        RecyclerView rv = findViewById(R.id.rvContactos);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ContactoAdapter adapter = new ContactoAdapter(ListaContactos.obtenerTodos());
        rv.setAdapter(adapter);

        if (ListaContactos.obtenerTodos().isEmpty()) {
            Toast.makeText(this, "No hay contactos", Toast.LENGTH_SHORT).show();
        }
    }
}
