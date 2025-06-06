package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa una agenda que contiene una lista de personas
 * y métodos para añadir, eliminar o modificar los contactos.
 */
public class Agenda {
    /**
     * Lista de personas almacenadas en la agenda.
     */
    private List<Persona> contacts;

    /**
     * Constructor que inicializa una agenda vacía.
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Añade un contacto nuevo a la agenda o añade un teléfono
     * a un contacto existente si ya está registrado.
     *
     * @param name  Nombre del contacto.
     * @param phone Número de teléfono a añadir.
     */
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona p : contacts) {
            if (p.getName().equalsIgnoreCase(name)) {
                exists = true;
                p.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Elimina un contacto de la agenda según su nombre.
     *
     * @param name Nombre del contacto a eliminar.
     */
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona p = it.next();

            if (p.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     * Modifica el número de teléfono de un contacto específico.
     *
     * @param name     Nombre del contacto.
     * @param oldPhone Teléfono que se desea reemplazar.
     * @param newPhone Nuevo número de teléfono.
     */
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona p : contacts) {
            if (p.getName().equalsIgnoreCase(name)) {
                List<String> phones = p.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Obtiene la lista completa de contactos en la agenda.
     *
     * @return Lista de personas.
     */
    public List<Persona> getContacts() {
        return this.contacts;
    }
}
