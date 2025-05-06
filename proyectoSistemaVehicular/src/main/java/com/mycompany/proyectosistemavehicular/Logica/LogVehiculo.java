package com.mycompany.proyectosistemavehicular.Logica;

import com.mycompany.proyectosistemavehicular.clases.EstadoVehiculo;
import com.mycompany.proyectosistemavehicular.clases.Vehiculo;
import java.util.List;
import percistencias.VehiculoJpaController;

public class LogVehiculo {

    VehiculoJpaController jpaVehiculo = new VehiculoJpaController();

    public Vehiculo buscarVehiculoPorId(int IdVehi) {
        List<Vehiculo> lista = jpaVehiculo.findVehiculoEntities();
        for (Vehiculo p : lista) {
            if (p.getIdVehi() == IdVehi) {
                return p;
            }
        }
        return null;
    }

    public void insertarPropietario(Vehiculo vehiculo) {
        vehiculo.setEstado(EstadoVehiculo.DISPONIBLE);
        jpaVehiculo.create(vehiculo);
    }

    public void actualizarVehiculo(Vehiculo vehiculo) throws Exception {
        jpaVehiculo.edit(vehiculo);
    }
}
