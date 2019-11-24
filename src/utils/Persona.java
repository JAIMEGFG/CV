package utils;

import com.sun.org.apache.bcel.internal.generic.LDIV;

public class Persona {
    String nombre, direccion;
    int telefono, dni,aniosExpereincia;


    public Persona(String nombre, String direccion, int telefono, int dni, int aniosExpereincia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.aniosExpereincia = aniosExpereincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setAniosExpereincia(int aniosExpereincia) {
        this.aniosExpereincia = aniosExpereincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }



    public int getTelefono() {
        return telefono;
    }

    public int getDni() {
        return dni;
    }

    public int getAniosExpereincia() {
        return aniosExpereincia;
    }
}
