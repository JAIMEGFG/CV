package utils;

import com.sun.org.apache.bcel.internal.generic.LDIV;

public class Persona {
    String nombre, direccion;
    int telefono, dni,aniosExpereincia;
    int estado;


    public Persona(String nombre, String direccion, int telefono, int dni, int aniosExpereincia,int estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.aniosExpereincia = aniosExpereincia;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + String.valueOf(telefono) ;
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

    public void setEstado(int estado) {
        this.estado = estado;
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

    public int getEstado() {
        return estado;
    }

    public int getAniosExpereincia() {
        return aniosExpereincia;
    }
}
