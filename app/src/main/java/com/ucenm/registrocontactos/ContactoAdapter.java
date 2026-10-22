package com.ucenm.registrocontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder> {

    private ArrayList<Contacto> contactos;

    public ContactoAdapter(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacto c = contactos.get(position);
        holder.tvNombre.setText(c.getNombre());
        holder.tvCorreo.setText(c.getCorreo());
        holder.tvTelefono.setText(c.getTelefono());
        holder.tvTipo.setText(c.getTipo());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCorreo, tvTelefono, tvTipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCorreo = itemView.findViewById(R.id.tvCorreo);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
            tvTipo = itemView.findViewById(R.id.tvTipo);
        }
    }
}
