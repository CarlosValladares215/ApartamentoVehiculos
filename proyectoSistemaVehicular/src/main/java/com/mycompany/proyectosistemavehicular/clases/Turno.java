package com.mycompany.proyectosistemavehicular.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurn")
    private int idTurn;

    @Column(name = "anden")
    private String anden;

    @Column(name = "hora_turno")
    private String horaTurno;

    @Temporal(TemporalType.DATE)
    @Column(name = "dia_turno")
    private Date diaTurno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    public Turno() {
    }

    public Turno(int idTurn, String anden, String horaTurno, Date diaTurno, Date fechaCreacion, Vehiculo vehiculo) {
        this.idTurn = idTurn;
        this.anden = anden;
        this.horaTurno = horaTurno;
        this.diaTurno = diaTurno;
        this.fechaCreacion = fechaCreacion;
        this.vehiculo = vehiculo;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public String getAnden() {
        return anden;
    }

    public void setAnden(String anden) {
        this.anden = anden;
    }

    public String getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }

    public Date getDiaTurno() {
        return diaTurno;
    }

    public void setDiaTurno(Date diaTurno) {
        this.diaTurno = diaTurno;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
