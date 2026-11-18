package edu.unitec.minidbms.ui;
import edu.unitec.minidbms.modelo.PoliticaDeReutilizacion;
import javax.swing.JOptionPane;
import java.io.File;
public class Dlg_CrearArchivo extends javax.swing.JDialog {
    
    String nombre;
    String fileDirectory;
    PoliticaDeReutilizacion politica;
    boolean valid;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dlg_CrearArchivo.class.getName());
    public Dlg_CrearArchivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_backgroud = new javax.swing.JPanel();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Carpeta = new javax.swing.JLabel();
        lbl_PoliticaReutilizacion = new javax.swing.JLabel();
        fld_nombre = new javax.swing.JTextField();
        fld_carpeta = new javax.swing.JTextField();
        cmb_politicaReuti = new javax.swing.JComboBox<>();
        btn_FileChooser = new javax.swing.JButton();
        btn_CrearArchivo = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_Nombre.setText("Nombre:");

        lbl_Carpeta.setText("Carpeta:");

        lbl_PoliticaReutilizacion.setText("Politica de Reutilizacion:");

        fld_carpeta.setEditable(false);

        cmb_politicaReuti.setModel(new javax.swing.DefaultComboBoxModel<>(PoliticaDeReutilizacion.values()));

        btn_FileChooser.setText("...");
        btn_FileChooser.addActionListener(this::btn_FileChooserActionPerformed);

        btn_CrearArchivo.setText("Crear");
        btn_CrearArchivo.addActionListener(this::btn_CrearArchivoActionPerformed);

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(this::btn_CancelarActionPerformed);

        javax.swing.GroupLayout pnl_backgroudLayout = new javax.swing.GroupLayout(pnl_backgroud);
        pnl_backgroud.setLayout(pnl_backgroudLayout);
        pnl_backgroudLayout.setHorizontalGroup(
            pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backgroudLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_backgroudLayout.createSequentialGroup()
                        .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Nombre)
                            .addComponent(lbl_Carpeta))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fld_nombre)
                            .addGroup(pnl_backgroudLayout.createSequentialGroup()
                                .addComponent(fld_carpeta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_FileChooser)
                                .addGap(1, 1, 1))))
                    .addGroup(pnl_backgroudLayout.createSequentialGroup()
                        .addComponent(lbl_PoliticaReutilizacion)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_politicaReuti, 0, 99, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
            .addGroup(pnl_backgroudLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btn_CrearArchivo)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_backgroudLayout.setVerticalGroup(
            pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backgroudLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nombre)
                    .addComponent(fld_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Carpeta)
                    .addComponent(fld_carpeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_FileChooser))
                .addGap(18, 18, 18)
                .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PoliticaReutilizacion)
                    .addComponent(cmb_politicaReuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnl_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CrearArchivo)
                    .addComponent(btn_Cancelar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_CrearArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearArchivoActionPerformed
        this.valid = false;
        this.nombre = fld_nombre.getText();
        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(this, "Nombre esta en blanco!");
            return;
        }
        this.fileDirectory = fld_carpeta.getText();
        if (fileDirectory.isBlank()) {
            JOptionPane.showMessageDialog(this, "Directorio esta en blanco!");
            return;
        }
        this.politica = cmb_politicaReuti.getItemAt(cmb_politicaReuti.getSelectedIndex());
        this.valid = true;
    }//GEN-LAST:event_btn_CrearArchivoActionPerformed

    private void btn_FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FileChooserActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar Donde Guardar Archivo");
        
        int result = fileChooser.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fld_carpeta.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_btn_FileChooserActionPerformed

    public String getNombre(){
        return nombre;
    }
    
    public String getDirectory(){
        return fileDirectory;
    }
    
    public PoliticaDeReutilizacion getPolitica(){
        return politica;
    }
    
    public boolean getValid(){
        return valid;
    }
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dlg_CrearArchivo dialog = new Dlg_CrearArchivo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_CrearArchivo;
    private javax.swing.JButton btn_FileChooser;
    private javax.swing.JComboBox<PoliticaDeReutilizacion> cmb_politicaReuti;
    private javax.swing.JTextField fld_carpeta;
    private javax.swing.JTextField fld_nombre;
    private javax.swing.JLabel lbl_Carpeta;
    private javax.swing.JLabel lbl_Nombre;
    private javax.swing.JLabel lbl_PoliticaReutilizacion;
    private javax.swing.JPanel pnl_backgroud;
    // End of variables declaration//GEN-END:variables
}
