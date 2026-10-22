package com.ucenm.registrocontactos;

import java.util.ArrayList;

public class ListaContactos {
    private static ArrayList<Contacto> contactos = new ArrayList<>();

    public static void agregar(Contacto c) {
        contactos.add(c);
    }

    public static ArrayList<Contacto> obtenerTodos() {
        return contactos;
    }
}
