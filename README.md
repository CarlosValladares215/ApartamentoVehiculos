# ApartamentoVehiculos
Parte logica del codigo:
Vehiculo:
```java

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
```
Turno:

```java
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
```
Propietario:
``` Java
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

```

Intrefaz Grafica:

Registro del Propietario:

![image](https://github.com/user-attachments/assets/858af99a-229f-46c0-8ca3-f58c923fcb22)

```java

 private void TXT_CedulaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {                                            
       try{
           // Obtener datos del formulario
           String cedula = TXT_Cedula.getText().trim();
           String nombre = TXT_Nombre.getText().trim();
           String apellido = TXT_Apellido.getText().trim();
           // Validar campos basicos
            if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }
            // Crear objeto Propietario
            Propietario propietario = new Propietario();
            propietario.setCedula(cedula);
            propietario.setNombre(nombre);
            propietario.setApellido(apellido);
            
            // Insertar propietario usando logica
            LogPropietario log = new LogPropietario();
            Propietario existente = log.buscarPropietarioPorCedula(cedula);
            if (existente != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un propietario con esa cédula.");
                return;
            }
            
            log.insertarPropietario(propietario);
            
            JOptionPane.showMessageDialog(this, "Propietario registrado exitosamente.");
            TXT_Nombre.setText("");
            TXT_Apellido.setText("");
            TXT_Cedula.setText("");
       }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar cliente: " + ex.getMessage());
        }
    }                                           

    private void BTN_RegresarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new VentanaPrincipal().setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }                                            

    private void BTN_ReservarTurnoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        new ReservaTurnos().setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }        Botones:
```
Registro de Vehiculo:

Interfaz Grafica:

![image](https://github.com/user-attachments/assets/fb3d96e1-6e1b-44fc-a65b-4dd17daa9754)

Codigo:
```java
private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {                                            

        try{
           // Obtener datos del formulario
           String placa = TXT_Placa.getText().trim();
           String marca = TXT_Marca.getText().trim();
           // Validar campos basicos
            if (placa.isEmpty() || marca.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }
            // Crear objeto Vehiculo
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMarca(marca);
            vehiculo.setPlaca(placa);
            
            // Insertar vehiculo usando logica
            LogVehiculo log = new LogVehiculo();
            
            log.insertarPropietario(vehiculo);
            
            JOptionPane.showMessageDialog(this, "Propietario registrado exitosamente.");
            TXT_Marca.setText("");
            TXT_Placa.setText("");
       }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar cliente: " + ex.getMessage());
        }

    }                                           

    private void BTN_PropietarioActionPerformed(java.awt.event.ActionEvent evt) {                                                
        new IngresarPropietario().setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }                                               

    private void BTN_AtrasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new VentanaPrincipal().setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }
```
Reserva de Turnos:

Interfaz Grafica:

![image](https://github.com/user-attachments/assets/18620388-264b-48db-86b8-761dbc5b4837)


```java
private void BTN_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            // 1. Obtener datos del formulario
            String dia = CBX_Dia.getSelectedItem().toString();
            String mes = CBX_Mes.getSelectedItem().toString();
            String hora = CBX_Hora.getSelectedItem().toString();
            String anden = TXT_Anden.getText().trim();

            // Validar campos básicos
            if (dia.isEmpty() || mes.isEmpty() || hora.isEmpty() || anden.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            // 2. Crear la fecha del turno (día del turno)
            int anioActual = java.time.Year.now().getValue();
            String fechaTexto = anioActual + "-" + mes + "-" + dia;

            // Convertir a java.util.Date
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date fechaTurno = formato.parse(fechaTexto);

            // 3. Buscar el vehículo 
            Vehiculo vehiculo = buscarVehiculoSeleccionado();

            if (vehiculo == null) {
                JOptionPane.showMessageDialog(this, "Vehículo no válido o no seleccionado.");
                return;
            }

            // 4. Validar si ya tiene un turno ese día o en ese andén
            LogTurno log = new LogTurno();
            if (!log.validarTurno(vehiculo, fechaTurno, anden)) {
                JOptionPane.showMessageDialog(this, "Este vehículo ya tiene un turno ese día o en ese andén.");
                return;
            }

            // 5. Crear el turno
            Turno turno = new Turno();
            turno.setAnden(anden);
            turno.setHoraTurno(hora);
            turno.setDiaTurno(fechaTurno);
            turno.setFechaCreacion(new Date()); // ahora
            turno.setVehiculo(vehiculo);

            // 6. Guardar el turno
            log.insertarTurno(turno);

            // 7. Cambiar estado del vehículo
            vehiculo.setEstado(EstadoVehiculo.EN_USO);
            new VehiculoJpaController().edit(vehiculo);

            JOptionPane.showMessageDialog(this, "Turno registrado exitosamente.");
            TXT_Anden.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar turno: " + ex.getMessage());
            ex.printStackTrace();
        }
    }                                             

    private void BTN_CedulaConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        LogPropietario log = new LogPropietario();
        Propietario p = log.buscarPropietarioPorCedula(TXT_Cedula.getText().trim());
        if (p == null) {
            JOptionPane.showMessageDialog(this, "No existe propietario con esa cédula.");
            BTN_CedulaConfirmacion.setText("❌");
            return;
        }else{
            BTN_CedulaConfirmacion.setText("✅");
        }
    }                                                      

    private void BTN_IdConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        LogVehiculo log = new LogVehiculo();
        int id = Integer.parseInt(TXT_IdVehiculo.getText().trim());
        Vehiculo p = log.buscarVehiculoPorId(id);
        if (p == null) {
            JOptionPane.showMessageDialog(this, "No existe vehiculo con ese id.");
            BTN_CedulaConfirmacion.setText("❌");
            return;
        }else{
            BTN_CedulaConfirmacion.setText("✅");
        }
    }                                                  

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new VentanaPrincipal().setVisible(true);
        this.dispose(); // Cierra la ventana actual
    }
```
