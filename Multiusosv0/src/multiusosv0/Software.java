/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusosv0;

/**
 *
 * @author Jose Miguel Durá Sirvent
 */
public class Software {
    private String nombre;
    private String descripcion;
    private String licencia;
    private double precio;
    private String requisitos;
    private String alternativas;

    public Software(String nombre, String descripcion, String licencia, double precio, String requisitos, String alternativas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.licencia = licencia;
        this.precio = precio;
        this.requisitos = requisitos;
        this.alternativas = alternativas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String alternativas) {
        this.alternativas = alternativas;
    }

}
