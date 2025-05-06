/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectosistemavehicular;

import com.mycompany.proyectosistemavehicular.Presentacion.VentanaPrincipal;
import javax.swing.SwingUtilities;

/**
 *
 * @author vcarl
 */
public class ProyectoSistemaVehicular {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal frame = new VentanaPrincipal();
            frame.setSize(300, 300);
            frame.setVisible(true);
        });
    }
}
