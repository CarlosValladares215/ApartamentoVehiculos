package com.mycompany.proyectosistemavehicular.Logica;

import com.mycompany.proyectosistemavehicular.clases.Turno;
import com.mycompany.proyectosistemavehicular.clases.Vehiculo;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import percistencias.TurnoJpaController;

public class LogTurno {

    TurnoJpaController jpaTurno = new TurnoJpaController();

    public void insertarTurno(Turno turno) {
        jpaTurno.create(turno);
    }

    public boolean validarTurno(Vehiculo vehiculo, Date diaTurno, String anden) {
        EntityManager em = jpaTurno.getEntityManager();
        try {
            // 1. Ya tiene turno ese día
            TypedQuery<Turno> consulta1 = em.createQuery(
                    "SELECT t FROM Turno t WHERE t.vehiculo = :vehiculo AND t.diaTurno = :fecha", Turno.class);
            consulta1.setParameter("vehiculo", vehiculo);
            consulta1.setParameter("fecha", diaTurno);

            if (!consulta1.getResultList().isEmpty()) {
                return false;
            }

            // 2. Ya tiene turno en ese andén ese día
            TypedQuery<Turno> consulta2 = em.createQuery(
                    "SELECT t FROM Turno t WHERE t.vehiculo = :vehiculo AND t.anden = :anden AND t.diaTurno = :fecha", Turno.class);
            consulta2.setParameter("vehiculo", vehiculo);
            consulta2.setParameter("anden", anden);
            consulta2.setParameter("fecha", diaTurno);

            if (!consulta2.getResultList().isEmpty()) {
                return false;
            }

            return true;
        } finally {
            em.close();
        }
    }

}
