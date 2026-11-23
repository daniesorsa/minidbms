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

        tab_PanelDeArchivos = new javax.swing.JTabbedPane();
        pnl_Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_camposAbiertos = new javax.swing.JTextArea();
        btn_salir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_archivoAbierto = new javax.swing.JTextArea();
        btn_abrirMenu = new javax.swing.JButton();
        mnuBar_Opciones = new javax.swing.JMenuBar();
        mnu_Archivo = new javax.swing.JMenu();
        mni_CrearArchivo = new javax.swing.JMenuItem();
        mni_AbrirArchivo = new javax.swing.JMenuItem();
        mni_GuardarArchivo = new javax.swing.JMenuItem();
        mni_CerrarArchivo = new javax.swing.JMenuItem();
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

        tab_PanelDeArchivos.setBackground(new java.awt.Color(255, 204, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setText("Archivo Actual:");

        txt_camposAbiertos.setColumns(20);
        txt_camposAbiertos.setRows(5);
        txt_camposAbiertos.setEnabled(false);
        jScrollPane2.setViewportView(txt_camposAbiertos);

        btn_salir.setText("Salir");
        btn_salir.addActionListener(this::btn_salirActionPerformed);

        txt_archivoAbierto.setColumns(20);
        txt_archivoAbierto.setForeground(new java.awt.Color(0, 0, 0));
        txt_archivoAbierto.setRows(5);
        txt_archivoAbierto.setEnabled(false);
        jScrollPane3.setViewportView(txt_archivoAbierto);

        btn_abrirMenu.setText("Abrir Menú");
        btn_abrirMenu.addActionListener(this::btn_abrirMenuActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_salir)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_abrirMenu)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salir)
                    .addComponent(btn_abrirMenu))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_FondoLayout = new javax.swing.GroupLayout(pnl_Fondo);
        pnl_Fondo.setLayout(pnl_FondoLayout);
        pnl_FondoLayout.setHorizontalGroup(
            pnl_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_FondoLayout.setVerticalGroup(
            pnl_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            listado();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mni_CrearCampoActionPerformed

    private void mni_ModificarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_ModificarCampoActionPerformed
        try {
            String antiguo = JOptionPane.showInputDialog(this, "Nombre del campo a modificar:");
            String nuevo = JOptionPane.showInputDialog(this, "Nuevo nombre:");
            String longitud = JOptionPane.showInputDialog(this, "Nueva longitud máxima:");
            int nuevaLongitud = Integer.parseInt(longitud);
            gestor.modificarCampo(antiguo, nuevo, nuevaLongitud);
            JOptionPane.showMessageDialog(this, "Campo modificado con éxito!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        listado();
    }//GEN-LAST:event_mni_ModificarCampoActionPerformed

    private void mni_AbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_AbrirArchivoActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                gestor.abrirArchivo(archivoSeleccionado);
                JOptionPane.showMessageDialog(this, "Archivo abierto con exito!");
                txt_archivoAbierto.setText(archivoSeleccionado.getName());
                listado();
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
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al cerrar", JOptionPane.ERROR_MESSAGE);
        }
        txt_archivoAbierto.setText("");
        txt_camposAbiertos.setText("");
    }//GEN-LAST:event_mni_CerrarArchivoActionPerformed

    private void listado(){
        try {
            var campos = gestor.listarCampos();
            StringBuilder sb = new StringBuilder("");
            for (var c : campos) {
                sb.append("- ").append(c.getNombre()).append(" (").append(c.getTipoDato()).append(")(").append(c.getLongitudMax()).append(")\n");
            }
            txt_camposAbiertos.setText(sb.toString()); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void mni_ListarCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_ListarCampoActionPerformed
        listado();
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
        listado();
    }//GEN-LAST:event_mni_BorrarCampoActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_abrirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_abrirMenuActionPerformed

    
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
    private javax.swing.JButton btn_abrirMenu;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JMenuItem mni_XML;
    private javax.swing.JMenuBar mnuBar_Opciones;
    private javax.swing.JMenu mnu_Archivo;
    private javax.swing.JMenu mnu_Campos;
    private javax.swing.JMenu mnu_Exportar;
    private javax.swing.JMenu mnu_Registros;
    private javax.swing.JMenu mnu_Visualizar;
    private javax.swing.JPanel pnl_Fondo;
    private javax.swing.JTabbedPane tab_PanelDeArchivos;
    private javax.swing.JTextArea txt_archivoAbierto;
    private javax.swing.JTextArea txt_camposAbiertos;
    // End of variables declaration//GEN-END:variables
}
