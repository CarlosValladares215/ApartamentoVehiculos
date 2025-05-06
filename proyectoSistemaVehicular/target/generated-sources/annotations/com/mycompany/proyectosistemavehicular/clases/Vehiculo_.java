package com.mycompany.proyectosistemavehicular.clases;

import com.mycompany.proyectosistemavehicular.clases.EstadoVehiculo;
import com.mycompany.proyectosistemavehicular.clases.Propietario;
import com.mycompany.proyectosistemavehicular.clases.Turno;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-05T22:13:16", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, EstadoVehiculo> estado;
    public static volatile SingularAttribute<Vehiculo, Propietario> propietario;
    public static volatile ListAttribute<Vehiculo, Turno> turnos;
    public static volatile SingularAttribute<Vehiculo, Integer> idVehi;
    public static volatile SingularAttribute<Vehiculo, String> placa;

}