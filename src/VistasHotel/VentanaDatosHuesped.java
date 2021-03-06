/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VentanaDatosHuesped extends javax.swing.JInternalFrame {
    private HuespedData huespedData;
    private Conexion conexion;
    private ArrayList<Huesped> listaHuespedes;
    private DefaultTableModel modelo;
    /**
     * Creates new form VentanaDatosHuesped
     */
    public VentanaDatosHuesped() {
        try {
            initComponents();
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            modelo=new DefaultTableModel();
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        armaCabezeraTabla();
        borraFilasTabla();
        cargaDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void armaCabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
        columnas.add("Nombre");
        columnas.add("DNI");
        columnas.add("Domicilio");
        columnas.add("Correo");
        columnas.add("Celular");
        columnas.add("ID");
        for (Object it:columnas){
            modelo.addColumn(it);
        }
            datos.setModel(modelo);
        }
        
        public void borraFilasTabla(){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){
                modelo.removeRow(i);
            }
        }

        public void cargaDatos(){
            borraFilasTabla();
            for (Huesped m:listaHuespedes){
                modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),m.getCelular(),m.getId_huesped()});
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        boton2 = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);

        datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(datos);

        boton2.setText("Seleccionar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton1.setText("Cerrar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1)
                    .addComponent(boton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getAccessibleContext().setAccessibleDescription("VantanaDatosHuesped");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        try {
            int cel=datos.getSelectedRow();
            if(cel>-1){
                VistaReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                VistaReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                VistaReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                VistaReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                VistaReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                VistaReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                 this.setClosed(true);
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped");}
           
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        
            int cel=datos.getSelectedRow();
            if(cel>-1){
                try {
                    VistaGestionReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                    VistaGestionReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                    VistaGestionReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                    VistaGestionReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                    VistaGestionReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                    VistaGestionReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                    this.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_boton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton boton1;
    public static javax.swing.JButton boton2;
    public static javax.swing.JTable datos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
