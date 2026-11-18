package edu.unitec.minidbms.ui;
import edu.unitec.minidbms.modelo.*;
import edu.unitec.minidbms.storage.IOEncabezado;
import edu.unitec.minidbms.modelo.TipoDato;
import edu.unitec.minidbms.modelo.Campo;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class FormPrincipal extends javax.swing.JFrame {
    private IOEncabezado gestor; 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPrincipal.class.getName());

    public FormPrincipal() {
        initComponents();
        this.gestor = new IOEncabezado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Fondo = new javax.swing.JPanel();
        tab_PanelDeArchivos = new javax.swing.JTabbedPane();
        mnuBar_Opciones = new javax.swing.JMenuBar();
        mnu_Archivo = new javax.swing.JMenu();
        mni_CrearArchivo = new javax.swing.JMenuItem();
        mni_AbrirArchivo = new javax.swing.JMenuItem();
        mni_GuardarArchivo = new javax.swing.JMenuItem();
        mni_CerrarArchivo = new javax.swing.JMenuItem();
        mni_Salir = new javax.swing.JMenuItem();
        mnu_Campos = new javax.swing.JMenu();
        mni_CrearCampo = new javax.swing.JMenuItem();
        mni_ListarCampo = new javax.swing.JMenuItem();
        mni_ModificarCampo = new javax.swing.JMenuItem();
        mni_BorrarCampo = new javax.swing.JMenuItem();
        mnu_Registros = new javax.swing.JMenu();
        mni_IntroducirReg = new javax.swing.JMenuItem();
        mni_BuscarReg = new javax.swing.JMenuItem();
        mni_ModificarReg = new javax.swing.JMenuItem();
        mni_BorrarReg = new javax.swing.JMenuItem();
        mni_ListarReg = new javax.swing.JMenuItem();
        mni_CargarRegPrueba = new javax.swing.JMenuItem();
        mni_CruzarArchivos = new javax.swing.JMenuItem();
        mnu_Visualizar = new javax.swing.JMenu();
        mni_ArbolB = new javax.swing.JMenuItem();
        mni_AvailList = new javax.swing.JMenuItem();
        mni_Mapa = new javax.swing.JMenuItem();
        mnu_Exportar = new javax.swing.JMenu();
        mni_JSON = new javax.swing.JMenuItem();
        mni_XML = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab_PanelDeArchivos.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout pnl_FondoLayout = new javax.swing.GroupLayout(pnl_Fondo);
        pnl_Fondo.setLayout(pnl_FondoLayout);
        pnl_FondoLayout.setHorizontalGroup(
            pnl_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_PanelDeArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        pnl_FondoLayout.setVerticalGroup(
            pnl_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_PanelDeArchivos, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        mnu_Archivo.setText("Archivo");

        mni_CrearArchivo.setText("Crear");
        mni_CrearArchivo.addActionListener(this::mni_CrearArchivoActionPerformed);
        mnu_Archivo.add(mni_CrearArchivo);

        mni_AbrirArchivo.setText("Abrir");
        mni_AbrirArchivo.addActionListener(this::mni_AbrirArchivoActionPerformed);
        mnu_Archivo.add(mni_AbrirArchivo);

        mni_GuardarArchivo.setText("Guardar");
        mni_GuardarArchivo.addActionListener(this::mni_GuardarArchivoActionPerformed);
        mnu_Archivo.add(mni_GuardarArchivo);

        mni_CerrarArchivo.setText("Cerrar");
        mni_CerrarArchivo.addActionListener(this::mni_CerrarArchivoActionPerformed);
        mnu_Archivo.add(mni_CerrarArchivo);

        mni_Salir.setText("Salir");
        mni_Salir.addActionListener(this::mni_SalirActionPerformed);
        mnu_Archivo.add(mni_Salir);

        mnuBar_Opciones.add(mnu_Archivo);

        mnu_Campos.setText("Campos");

        mni_CrearCampo.setText("Crear");
        mni_CrearCampo.addActionListener(this::mni_CrearCampoActionPerformed);
        mnu_Campos.add(mni_CrearCampo);

        mni_ListarCampo.setText("Listar");
        mni_ListarCampo.addActionListener(this::mni_ListarCampoActionPerformed);
        mnu_Campos.add(mni_ListarCampo);

        mni_ModificarCampo.setText("Modificar");
        mni_ModificarCampo.addActionListener(this::mni_ModificarCampoActionPerformed);
        mnu_Campos.add(mni_ModificarCampo);

        mni_BorrarCampo.setText("Borrar");
        mni_BorrarCampo.addActionListener(this::mni_BorrarCampoActionPerformed);
        mnu_Campos.add(mni_BorrarCampo);

        mnuBar_Opciones.add(mnu_Campos);

        mnu_Registros.setText("Registros");

        mni_IntroducirReg.setText("Introducir");
        mnu_Registros.add(mni_IntroducirReg);

        mni_BuscarReg.setText("Buscar");
        mnu_Registros.add(mni_BuscarReg);

        mni_ModificarReg.setText("Modificar");
        mnu_Registros.add(mni_ModificarReg);

        mni_BorrarReg.setText("Borrar");
        mnu_Registros.add(mni_BorrarReg);

        mni_ListarReg.setText("Listar");
        mnu_Registros.add(mni_ListarReg);

        mni_CargarRegPrueba.setText("Cargar Registros");
        mnu_Registros.add(mni_CargarRegPrueba);

        mni_CruzarArchivos.setText("Cruzar Archivos");
        mnu_Registros.add(mni_CruzarArchivos);

        mnuBar_Opciones.add(mnu_Registros);

        mnu_Visualizar.setText("Visualizar");

        mni_ArbolB.setText("Arbol B");
        mnu_Visualizar.add(mni_ArbolB);

        mni_AvailList.setText("Avail List");
        mnu_Visualizar.add(mni_AvailList);

        mni_Mapa.setText("Mapa Del Archivo");
        mnu_Visualizar.add(mni_Mapa);

        mnuBar_Opciones.add(mnu_Visualizar);

        mnu_Exportar.setText("Exportar");

        mni_JSON.setText("JSON");
        mnu_Exportar.add(mni_JSON);

        mni_XML.setText("XML");
        mnu_Exportar.add(mni_XML);

        mnuBar_Opciones.add(mnu_Exportar);

        setJMenuBar(mnuBar_Opciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mni_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mni_SalirActionPerformed

    private void mni_CrearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_CrearArchivoActionPerformed
        Dlg_CrearArchivo dlg = new Dlg_CrearArchivo(this,true);
        dlg.setVisible(true);
        if (dlg.getValid()) {
            String nombre = dlg.getNombre();
            Path path = Path.of(dlg.getDirectory());
            String nombreTabla = "tabla.idx";
            PoliticaDeReutilizacion politica = dlg.getPolitica();
            System.out.println();
            try{
                gestor.crearArchivo(new File(path.resolve(nombre+".dat").toString()),nombreTabla,politica);
            }
            catch(Exception ex){
               JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al crear", JOptionPane.ERROR_MESSAGE);
            }
        }
        //dlg.setVisible(false);
    }//GEN-LAST:event_mni_CrearArchivoActionPerformed

    private void mni_CrearCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_CrearCampoActionPerformed
        try {
            String nombreCampo = JOptionPane.showInputDialog(this, "Nombre:");
            if (nombreCampo == null || nombreCampo.trim().isEmpty()) return;
            
            TipoDato tipo = (TipoDato) JOptionPane.showInputDialog(this, "Seleccione el tipo de dato:", "Tipo", 
                    JOptionPane.QUESTION_MESSAGE, null, TipoDato.values(), TipoDato.TEXTO);
            
            String lonStr = JOptionPane.showInputDialog(this, "Longitud máxima:");
            int longitud = Integer.parseInt(lonStr);
            
            int obligatorioOpt = JOptionPane.showConfirmDialog(this, "¿Es obligatorio?", "Obligatorio", JOptionPane.YES_NO_OPTION);
            boolean obligatorio = (obligatorioOpt == JOptionPane.YES_OPTION);
            
            int primariaOpt = JOptionPane.showConfirmDialog(this, "¿Es llave primaria?", "Llave Primaria", JOptionPane.YES_NO_OPTION);
            boolean esLlavePrimaria = (primariaOpt == JOptionPane.YES_OPTION);

            gestor.crearCampo(nombreCampo, tipo, longitud, obligatorio, "", esLlavePrimaria);
            JOptionPane.showMessageDialog(this, "Campo agregado con éxito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_CrearCampoActionPerformed

    private void mni_ModificarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_ModificarCampoActionPerformed
        try {
            String antiguo = JOptionPane.showInputDialog(this, "Nombre actual del campo a modificar:");
            String nuevo = JOptionPane.showInputDialog(this, "Nuevo nombre:");
            String lonStr = JOptionPane.showInputDialog(this, "Nueva longitud máxima:");
            int nuevaLongitud = Integer.parseInt(lonStr);

            gestor.modificarCampo(antiguo, nuevo, nuevaLongitud);
            JOptionPane.showMessageDialog(this, "Campo modificado con éxito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_ModificarCampoActionPerformed

    private void mni_AbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_AbrirArchivoActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                gestor.abrirArchivo(archivoSeleccionado);
                JOptionPane.showMessageDialog(this, "Archivo abierto con exito!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al abrir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_AbrirArchivoActionPerformed

    private void mni_GuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_GuardarArchivoActionPerformed
        try {
            gestor.guardarArchivo();
            JOptionPane.showMessageDialog(this, "Cambios guardados con exito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_GuardarArchivoActionPerformed

    private void mni_CerrarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_CerrarArchivoActionPerformed
        try {
            gestor.cerrarArchivo();
            JOptionPane.showMessageDialog(this, "Archivo cerrado con exito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_CerrarArchivoActionPerformed

    private void mni_ListarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_ListarCampoActionPerformed
        try {
            var campos = gestor.listarCampos();
            StringBuilder sb = new StringBuilder("Campos actuales:\n");
            for (var c : campos) {
                sb.append("- ").append(c.getNombre()).append(" (").append(c.getTipoDato()).append(")\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_ListarCampoActionPerformed

    private void mni_BorrarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_BorrarCampoActionPerformed
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del campo a borrar:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                gestor.borrarCampo(nombre);
                JOptionPane.showMessageDialog(this, "Campo eliminado con exito!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_BorrarCampoActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem mni_AbrirArchivo;
    private javax.swing.JMenuItem mni_ArbolB;
    private javax.swing.JMenuItem mni_AvailList;
    private javax.swing.JMenuItem mni_BorrarCampo;
    private javax.swing.JMenuItem mni_BorrarReg;
    private javax.swing.JMenuItem mni_BuscarReg;
    private javax.swing.JMenuItem mni_CargarRegPrueba;
    private javax.swing.JMenuItem mni_CerrarArchivo;
    private javax.swing.JMenuItem mni_CrearArchivo;
    private javax.swing.JMenuItem mni_CrearCampo;
    private javax.swing.JMenuItem mni_CruzarArchivos;
    private javax.swing.JMenuItem mni_GuardarArchivo;
    private javax.swing.JMenuItem mni_IntroducirReg;
    private javax.swing.JMenuItem mni_JSON;
    private javax.swing.JMenuItem mni_ListarCampo;
    private javax.swing.JMenuItem mni_ListarReg;
    private javax.swing.JMenuItem mni_Mapa;
    private javax.swing.JMenuItem mni_ModificarCampo;
    private javax.swing.JMenuItem mni_ModificarReg;
    private javax.swing.JMenuItem mni_Salir;
    private javax.swing.JMenuItem mni_XML;
    private javax.swing.JMenuBar mnuBar_Opciones;
    private javax.swing.JMenu mnu_Archivo;
    private javax.swing.JMenu mnu_Campos;
    private javax.swing.JMenu mnu_Exportar;
    private javax.swing.JMenu mnu_Registros;
    private javax.swing.JMenu mnu_Visualizar;
    private javax.swing.JPanel pnl_Fondo;
    private javax.swing.JTabbedPane tab_PanelDeArchivos;
    // End of variables declaration//GEN-END:variables
}
