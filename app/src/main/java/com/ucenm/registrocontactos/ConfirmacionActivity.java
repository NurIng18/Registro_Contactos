package com.ucenm.registrocontactos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvTipo = findViewById(R.id.tvTipo);
        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        // Recibir datos del Intent
        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        String tipo = getIntent().getStringExtra("opcion");

        tvNombre.setText(nombre);
        tvCorreo.setText(correo);
        tvTelefono.setText(telefono);
        tvTipo.setText(tipo);

        // Volver al formulario
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Confirmar: agregar a la lista (en memoria) e ir a la lista
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agregar contacto a la lista estática
                Contacto nuevo = new Contacto(nombre, correo, telefono, tipo);
                ListaContactos.agregar(nuevo);

                Intent intent = new Intent(ConfirmacionActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
    }
}
