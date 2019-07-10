/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Clases.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class VistaAparato extends javax.swing.JInternalFrame {
    private AparatoData ad;
    private ClienteData cd;
    private Conexion con;
    private List<Cliente> listaCliente;
    /**
     * Creates new form VistaAparato
     */
    public VistaAparato(){
        
            initComponents();
        try {    
            con = new Conexion("jdbc:mysql://localhost/tallerreparacion","root","");
            ad = new AparatoData(con);
            cd = new ClienteData(con);
            listaCliente = cd.listarClientes();
            cargarCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaAparato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtNroSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtIngreso = new javax.swing.JTextField();
        jtEgreso = new javax.swing.JTextField();
        jtTipo = new javax.swing.JTextField();
        jcbCliente = new javax.swing.JComboBox<>();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("ID");

        jLabel2.setText("Nro serie");

        jLabel3.setText("Tipo");

        jLabel4.setText("Dueño");

        jLabel5.setText("Fecha de ingreso");

        jLabel6.setText("Fecha de egreso");

        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBuscar.setText("BuscarID");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jButton1.setText("BuscarXingreso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jbModificar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbGuardar)
                                .addGap(114, 114, 114)))
                        .addComponent(jbEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbCliente, 0, 128, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbModificar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        try{
            String tipo = jtTipo.getText();
            String nroSerie = jtNroSerie.getText();
            Cliente c = (Cliente)jcbCliente.getSelectedItem();
            LocalDate ingreso = LocalDate.parse(jtIngreso.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate egreso = LocalDate.parse(jtEgreso.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Aparato a = new Aparato(nroSerie,tipo,c,ingreso,egreso);
            ad.guardarAparato(a);
            jtID.setText(a.getId_aparato() + "");
            JOptionPane.showMessageDialog(null, "Se ha agregado un aparato");
            limpiarVistaAparato();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Completar los campos");
            limpiarVistaAparato();
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed
    private void limpiarVistaAparato(){
        jtID.setText("");
        jtTipo.setText("");
        jtNroSerie.setText("");
        jtIngreso.setText("");
        jtEgreso.setText("");
    }
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        try{
                
                int id = Integer.parseInt(jtID.getText());
                String tipo = jtTipo.getText();
                String nroSerie = jtNroSerie.getText();
                LocalDate ingreso = LocalDate.parse(jtIngreso.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate egreso = LocalDate.parse(jtEgreso.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Cliente c = (Cliente)jcbCliente.getSelectedItem();
                Aparato a = new Aparato(id,tipo,nroSerie,c,ingreso,egreso);
                ad.actualizarAparato(a);
                 JOptionPane.showMessageDialog(null,"Se ha actualizado un aparato");
                 limpiarVistaAparato();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Completar los casilleros");
                limpiarVistaAparato();
            }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        if(jtID.getText()!=null){
        int id = Integer.parseInt(jtID.getText());
        ad.borrarAparato(id);
        JOptionPane.showMessageDialog(null,"Se ha eliminado");
        limpiarVistaAparato();
        }
        else{
            JOptionPane.showMessageDialog(null,"Completar casillero de ID");
            limpiarVistaAparato();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        try{
            
            Aparato aparato;
            int id = Integer.parseInt(jtID.getText());
            aparato = ad.buscarAparato(id);
            if(aparato.getDueño().getNombre_Cliente()!=null){
                jtID.setText(String.valueOf(aparato.getId_aparato()));
                jtTipo.setText(String.valueOf(aparato.getTipo()));
                jtNroSerie.setText(String.valueOf(aparato.getNro_serie()));
                jtIngreso.setText(String.valueOf(aparato.getFechIngreso()));
                jtEgreso.setText(String.valueOf(aparato.getFechEgreso()));
                JOptionPane.showMessageDialog(null,"busqueda exitosa!.");
            }
            else{
                JOptionPane.showMessageDialog(null,"No exite el aparato!.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se ha podido buscar!.");
            limpiarVistaAparato();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Aparato aparato;
        try{
            String fecha = jtIngreso.getText();
            aparato = ad.buscarAparatoXFecha(fecha);
            if(aparato.getDueño().getNombre_Cliente()!=null){
            jtID.setText(String.valueOf(aparato.getId_aparato()));
            jtTipo.setText(String.valueOf(aparato.getTipo()));
            jtNroSerie.setText(String.valueOf(aparato.getNro_serie()));
            jtIngreso.setText(String.valueOf(aparato.getFechEgreso()));
            jtEgreso.setText(String.valueOf(aparato.getFechEgreso()));
            JOptionPane.showMessageDialog(null,"Busqueda exitosa!");
            }
            else{
                JOptionPane.showMessageDialog(null,"No existe aparato en esa fecha!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!");
            limpiarVistaAparato();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void cargarCombo(){
        listaCliente = cd.listarClientes();
        
        for(Cliente c: listaCliente){
            jcbCliente.addItem(c);
        }
    }
    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<Cliente> jcbCliente;
    private javax.swing.JTextField jtEgreso;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtIngreso;
    private javax.swing.JTextField jtNroSerie;
    private javax.swing.JTextField jtTipo;
    // End of variables declaration//GEN-END:variables
}
