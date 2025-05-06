
package com.mycompany.proyectosistemavehicular.Logica;

import com.mycompany.proyectosistemavehicular.clases.Propietario;
import java.util.List;
import percistencias.PropietarioJpaController;


public class LogPropietario {
    
    PropietarioJpaController propietarioJPA = new PropietarioJpaController();
    
    public Propietario buscarPropietarioPorCedula(String cedula) {
        List<Propietario> lista = propietarioJPA.findPropietarioEntities();
        for(Propietario p : lista){
            if(p.getCedula().equals(cedula)){
                return p;
            }
        }
        return null;
    }

    public void insertarPropietario(Propietario propietario) {
        propietarioJPA.create(propietario);
    }
    
    public void actualizarPropietario(Propietario propietario) throws Exception{
        propietarioJPA.edit(propietario);
    }
}
