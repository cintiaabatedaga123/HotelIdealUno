/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author Usuario
 */
public class Huesped {
    private int id=-1;
    private String nombre;
    private int dni;
    private String domicilio;
    private String correo;
    private double Celular;

    public Huesped(int id, String nombre, int dni, String domicilio, String correo, double Celular) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }

    public Huesped(String nombre, int dni, String domicilio, String correo, double Celular) {
        id=-1;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }

 

    public Huesped(String nombre, int dni, String domicilio, String correo) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Huesped() {
        id=-1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getCelular() {
        return Celular;
    }

    public void setCelular(double Celular) {
        this.Celular = Celular;
    }
    
    
}
