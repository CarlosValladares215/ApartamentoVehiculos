
package com.mycompany.proyectosistemavehicular.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprop")
    private int idprop;
    @Basic
    private String Cedula;
    @Basic
    private String Apellido;
    @Basic
    private String Nombre;
    
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

    public Propietario() {
    }

    public Propietario(int idprop, String Cedula, String Apellido, String Nombre, ArrayList<Vehiculo> vehiculo) {
        this.idprop = idprop;
        this.Cedula = Cedula;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.vehiculos = vehiculo;
    }

    public int getIdprop() {
        return idprop;
    }

    public void setIdprop(int idprop) {
        this.idprop = idprop;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
