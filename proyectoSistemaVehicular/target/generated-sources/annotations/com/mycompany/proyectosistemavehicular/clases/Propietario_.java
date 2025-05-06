package com.mycompany.proyectosistemavehicular.clases;

import com.mycompany.proyectosistemavehicular.clases.Vehiculo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-05T22:13:16", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Propietario.class)
public class Propietario_ { 

    public static volatile SingularAttribute<Propietario, String> Nombre;
    public static volatile SingularAttribute<Propietario, String> Apellido;
    public static volatile SingularAttribute<Propietario, String> Cedula;
    public static volatile SingularAttribute<Propietario, Integer> idprop;
    public static volatile ListAttribute<Propietario, Vehiculo> vehiculos;

}