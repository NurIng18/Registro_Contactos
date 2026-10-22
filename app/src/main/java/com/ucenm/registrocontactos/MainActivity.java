package com.ucenm.registrocontactos;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etCorreo, etTelefono;
    private Spinner spTipo;
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO_VIDA", "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO_VIDA", "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO_VIDA", "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO_VIDA", "MainActivity - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO_VIDA", "MainActivity - onDestroy");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        spTipo = findViewById(R.id.spTipo);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        // Opciones del Spinner
        String[] tipos = {"Personal", "Trabajo", "Familia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, tipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adapter);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    // Enviar datos a pantalla de confirmación
                    Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);
                    intent.putExtra("nombre", etNombre.getText().toString().trim());
                    intent.putExtra("correo", etCorreo.getText().toString().trim());
                    intent.putExtra("telefono", etTelefono.getText().toString().trim());
                    intent.putExtra("tipo", spTipo.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validar() {
        boolean ok = true;

        // Campo vacío
        if (TextUtils.isEmpty(etNombre.getText().toString().trim())) {
            etNombre.setError("El nombre es obligatorio");
            ok = false;
        }

        // Campo vacío + formato de correo
        String correo = etCorreo.getText().toString().trim();
        if (TextUtils.isEmpty(correo)) {
            etCorreo.setError("El correo es obligatorio");
            ok = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Formato de correo inválido");
            ok = false;
        }

        // Teléfono: vacío + 8 dígitos
        String telefono = etTelefono.getText().toString().trim();
        if (TextUtils.isEmpty(telefono)) {
            etTelefono.setError("El teléfono es obligatorio");
            ok = false;
        } else if (!telefono.matches("\\d{8}")) {
            etTelefono.setError("Debe tener exactamente 8 dígitos");
            ok = false;
        }

        return ok;
    }
}
