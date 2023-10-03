 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir2;


/**
 *
 * @author LENOVO
 */
import Tabel.DataKasir;
import Tabel.TabelDataKasir;
import Tabel.validasi;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
public class penjualan2 extends javax.swing.JFrame {

    private Connection koneksi;
    private Statement script;
    private TabelDataKasir ModelDataKasir;
    validasi Valid = new validasi();
    
    /**
     * Creates new form penjualan2
     */
    private void bersih(){
    tfKode.setText(null);
    tfNama.setText(null);
    tfHarga.setText(null);
    tfStok.setText(null);
    tfKode.requestFocus();
    }
    
    private void Hapus(){
    int app;
    if((app=JOptionPane.showConfirmDialog(null,"Hapus data penjualan"+"?","Perhatian",
            JOptionPane.YES_NO_OPTION))==0){
    try{
        String sql="Delete from bayar where"+" Kode = '"+tfKode.getText()+"'";
        script.executeUpdate(sql);
        tampil();
        JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        bersih();
    }
    catch(SQLException ex){
    System.err.print(ex);
       }
    }
}
    
    private void Update(){
    int app;
     if ((app=JOptionPane.showConfirmDialog(null,"Ubah Data Penjualan"+"?","Perhatian",
              JOptionPane.YES_NO_OPTION))==0) {
                   
                try{
                  String sql= " Update bayar set "
                    +"Kode = '"+tfKode.getText()+"',"      
                    +"Nama_brg = '"+tfNama.getText()+"',"
                    +"Harga = '"+tfHarga.getText()+"',"
                    +"Stok = '"+tfStok.getText()+"' where"
                    +" Kode = '"+tfKode.getText()+"'";
                  
                  script.executeUpdate(sql);
                  tampil();
                  bersih();
                    JOptionPane.showMessageDialog(null,"Data Penjual Berhasil Di Ubah ");
                }
                catch(SQLException ex){
                    System.err.print(ex);
                                     
                }  
            } 
}
    
    public penjualan2() {
        initComponents();
        KoneksiDB();
        ModelDataKasir = new TabelDataKasir();
        tblKasirrr.setModel(ModelDataKasir);
        tampil();
        klikTabel();
    }
    private void klikTabel(){
    tblKasirrr.getSelectionModel().addListSelectionListener(new ListSelectionListener()
    {
      @Override
     public void valueChanged(ListSelectionEvent e)
            
     {
         int baris = tblKasirrr.getSelectedRow();
         if(baris != -1)
        {
                DataKasir kasir = ModelDataKasir.get(baris);
            tfKode.setText(kasir.getKode());
            tfNama.setText(kasir.getnama_brg());
            tfHarga.setText(String.valueOf(kasir.getharga()));
            tfStok.setText(String.valueOf(kasir.getstok()));
                
            }
        }
   });
}

     private void KoneksiDB(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        koneksi=DriverManager.getConnection("jdbc:mysql://localhost/kasir","root","");
        script=koneksi.createStatement();
    }
    catch (SQLException ex) {
        System.err.print (ex);
    }
    catch (ClassNotFoundException ex){
        System.err.print(ex);
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

        tfKode = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfStok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKasirrr = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Harga Barang");

        jLabel4.setText("Stok");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tblKasirrr.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblKasirrr);

        jLabel5.setText("cari barang");

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kode", "Nama_brg", " " }));

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfKode)
                            .addComponent(tfNama)
                            .addComponent(tfHarga)
                            .addComponent(tfStok, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan)
                            .addComponent(btnEdit)
                            .addComponent(jButton1))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus)
                            .addComponent(btnKeluar)
                            .addComponent(btnCetak))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnCetak))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKeluar)
                            .addComponent(btnEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tampil(){
    try{
        int baris = tblKasirrr.getRowCount();
        for(int i=0; i<baris; i++){
            ModelDataKasir.delete(0, baris);
        }
        String sql = " select * from bayar";
        ResultSet rs = script.executeQuery(sql);
        while (rs.next( )){
            DataKasir kasir = new DataKasir();
            
            kasir.setkode(rs.getString(1));
            kasir.setnama_brg(rs.getString(2));
            kasir.setharga(rs.getInt(3));
            kasir.setstok(rs.getInt(4));
               
               ModelDataKasir.add(kasir);
        }
    }
    catch(SQLException ex){
        System.err.print(ex);
    }
    }
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (tfKode.getText().length()==0){
           JOptionPane.showMessageDialog(null," Kode tidak boleh kosong","konfirmasi",JOptionPane.INFORMATION_MESSAGE);
           tfKode.requestFocus();
           return;
        }
        else{ 
          //validasi redudansi
               try{
                String a="select * from bayar where "+"kode='"+tfKode.getText()+"'";
                ResultSet res = script.executeQuery(a);
                if (res.next()){
                    if (tfKode.getText().equals(res.getString("kode"))){
                        JOptionPane.showMessageDialog(rootPane," Kode sudah ada");
                        tfKode.requestFocus();
                        return;
                    }
                }
            //coding simpan    
                try{
                  String sql= " insert into bayar values ("
                    + "'"+tfKode.getText()+"',"      
                    + "'"+tfNama.getText()+"',"
                    + "'"+tfHarga.getText()+"',"
                    +"'"+tfStok.getText()+"'"
                    +")";
                  script.executeUpdate(sql);
                  
                  JOptionPane.showMessageDialog(null,tfKode.getText()+" Berhasil disimpan");
                  bersih();
                  tampil();
                }
                catch(SQLException ex){
                    System.err.print(ex);
                }  
            } 
            catch (Exception e){
                JOptionPane.showMessageDialog(rootPane,"Ada yang Salah");
            } 
      }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        Update();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        Hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        cariData();// TODO add your handling code here:
    }//GEN-LAST:event_txtCariKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Valid.autoNomor(ModelDataKasir,"KD", 3, tfKode); // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        try
        {
            File report1 = new File("src/laporan/report1.jasper");
            KoneksiDB();
            
            JasperPrint jp = JasperFillManager.fillReport(report1.getPath(), null, koneksi);
            JasperViewer.viewReport(jp, false);
        }
        catch(JRException e)
                {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
    }//GEN-LAST:event_btnCetakActionPerformed
private void cariData() {
    String kolom = cmbCari.getSelectedItem().toString();
    int baris = tblKasirrr.getRowCount();
    
    for (int i=0;i<baris;i++){
        ModelDataKasir.delete(0, baris); 
    }
     try {
        String sql = "SELECT * FROM bayar WHERE " + kolom + " LIKE '%" + txtCari.getText() + "%'";
        ResultSet rs = script.executeQuery(sql);
        while (rs.next()) {
            DataKasir kasir = new DataKasir();
            
            kasir.setkode(rs.getString(1));
            kasir.setnama_brg(rs.getString(2));
            kasir.setharga(rs.getInt(3));
            kasir.setstok(rs.getInt(4));
            
            ModelDataKasir.add(kasir);
        }
    } catch (SQLException ex) {
        System.err.println(ex);
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(penjualan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKasirrr;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfKode;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfStok;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

}