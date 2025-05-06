package com.mycompany.proyectosistemavehicular.clases;

import com.mycompany.proyectosistemavehicular.clases.Vehiculo;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-05T22:13:16", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> diaTurno;
    public static volatile SingularAttribute<Turno, Date> fechaCreacion;
    public static volatile SingularAttribute<Turno, String> anden;
    public static volatile SingularAttribute<Turno, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Turno, Integer> idTurn;
    public static volatile SingularAttribute<Turno, String> horaTurno;

}