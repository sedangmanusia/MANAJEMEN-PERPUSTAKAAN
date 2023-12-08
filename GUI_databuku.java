/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGASPRAKTIKUM;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author finaa
 */
public class GUI_databuku extends javax.swing.JFrame {

    /**
     * Creates new form GUI_databuku
     */
    public GUI_databuku() {
        initComponents();
       /** Buku buku1 = new Buku();
        txt_judulbuku.setText(buku1.judulBuku);
        txt_pengarang.setText(buku1.pengarang);
        txt_penerbit.setText(buku1.penerbit);
        txt_thnterbit.setText(Integer.toString(buku1.tahunTerbit));
        txt_fiksi.setText(buku1.jenisBuku);
        txt_bindonesia.setText(buku1.bahasa);
        String statusKetersediaan = txt_ketersediaan.getText();**/
       DefaultTableModel dataBuku = (DefaultTableModel)tabel_buku.getModel();
        int rowCount = dataBuku.getRowCount();
        while (rowCount > 0 )
        {
            dataBuku.removeRow(rowCount - 1);
            rowCount = dataBuku.getRowCount();
        }
    }
    
    public void clear() {
 txt_judulbuku.setText("");
 txt_pengarang.setText("");
 txt_penerbit.setText("");
 txt_thnterbit.setText("");
 txt_ketersediaan.setText("");
 txt_harga.setText(" ");
 txt_Petugas.setText(" ");
 //txt_binggris.clearSelection();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_judulbuku = new javax.swing.JTextField();
        txt_pengarang = new javax.swing.JTextField();
        txt_penerbit = new javax.swing.JTextField();
        txt_thnterbit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_fiksi = new javax.swing.JRadioButton();
        txt_nonfiksi = new javax.swing.JRadioButton();
        txt_bindonesia = new javax.swing.JCheckBox();
        txt_binggris = new javax.swing.JCheckBox();
        txt_barab = new javax.swing.JCheckBox();
        btnSimpan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_ketersediaan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_buku = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_Petugas = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DATA BUKU");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Pengarang");

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("Jenis Buku");

        txt_penerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_penerbitActionPerformed(evt);
            }
        });

        jLabel7.setText("Bahasa");

        txt_fiksi.setText("Fiksi");
        txt_fiksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fiksiActionPerformed(evt);
            }
        });

        txt_nonfiksi.setText("Non-fiksi");

        txt_bindonesia.setText("Indonesia");

        txt_binggris.setText("Inggris");
        txt_binggris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_binggrisActionPerformed(evt);
            }
        });

        txt_barab.setText("Arab");
        txt_barab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barabActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel8.setText("Status Ketersediaan");

        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Jenis Buku", "Bahasa", "Harga", "Petugas"
            }
        ));
        jScrollPane2.setViewportView(tabel_buku);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel10.setText("Harga");

        jLabel11.setText("Petugas");

        btnSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(115, 115, 115)
                        .addComponent(txt_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nonfiksi)
                            .addComponent(txt_fiksi)
                            .addComponent(txt_bindonesia)
                            .addComponent(txt_binggris)
                            .addComponent(txt_barab)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(100, 100, 100)
                        .addComponent(txt_judulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(99, 99, 99)
                        .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txt_thnterbit)
                            .addComponent(txt_ketersediaan, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txt_Petugas))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnSimpan)
                        .addGap(54, 54, 54)
                        .addComponent(btnHapus)
                        .addGap(49, 49, 49)
                        .addComponent(btnBatal)
                        .addGap(37, 37, 37)
                        .addComponent(btnClose)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(65, 65, 65))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_judulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch))
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_thnterbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_fiksi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nonfiksi)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_bindonesia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_binggris)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_barab))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal)
                            .addComponent(btnClose)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_ketersediaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_penerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_penerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_penerbitActionPerformed

    private void txt_fiksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fiksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fiksiActionPerformed

    private void txt_binggrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_binggrisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_binggrisActionPerformed

    private void txt_barabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barabActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
     // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel 
      JOptionPane.showMessageDialog(null, "Data anda Ditambahkan Ke tabel");
 // Mengambil model data dari tabel
 DefaultTableModel dataBuku = (DefaultTableModel) tabel_buku.getModel();
 // Inisialisasi sebuah ArrayList bernama 'list'
 List list = new ArrayList<>();
 // Mengatur tabel untuk membuat kolom dari model secara otomatis
tabel_buku.setAutoCreateColumnsFromModel(true);
 // Membuat instance dari kelas Mahasiswa
 Buku bukuA = new Buku();
 // Mengatur data NIM menggunakan nilai dari komponen txtNim
 bukuA.dataJudul(txt_judulbuku.getText());
 // Mengatur data Nama menggunakan nilai dari komponen txtNama
 bukuA.dataPengarang(txt_pengarang.getText());
 // Mengatur jenis kelamin sesuai dengan radio button yang dipilih
 String JenisBuku = "";
 if (txt_fiksi.isSelected()) {
 bukuA.dataJenisBuku(txt_fiksi.getText());
 } else {
 bukuA.dataJenisBuku(txt_nonfiksi.getText());
 }
 
 String JenisBahasa = "";
 if (txt_bindonesia.isSelected()) 
 {
 bukuA.dataBahasa(txt_bindonesia.getText());
 }
 else if(txt_binggris.isSelected())
 {
    bukuA.dataBahasa(txt_binggris.getText());
 }
 else 
 {
 bukuA.dataBahasa(txt_barab.getText());
 }
 // Mengatur data Prodi menggunakan nilai dari komponen txtProdi
  bukuA.dataPenerbit(txt_penerbit.getText());
 // Mengatur data Angkatan menggunakan nilai dari komponen txtAngkatan
  bukuA.datathnTerbit(Integer.parseInt(txt_thnterbit.getText()));
  
  bukuA.setHargaBuku(Double.parseDouble(txt_harga.getText()));
  bukuA.setnamaPetugas(txt_Petugas.getText());
 // Mengatur data Alamat menggunakan nilai dari komponen txtAlamat
 // Menambahkan data-data dari objek Mahasiswa ke dalam ArrayList 'list'
 list.add(bukuA.cetakJudul());
 list.add(bukuA.cetakPengarang());
 list.add(bukuA.cetakPenerbit());
 list.add(bukuA.cetakThnterbit());
 list.add(bukuA.cetakJenisBuku());
 list.add(bukuA.cetakBahasa());
 list.add(bukuA.hargaBuku()); 
 list.add(bukuA.namaPetugas());
 // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
 dataBuku.addRow(list.toArray());
 // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
 clear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
         DefaultTableModel dataBuku = (DefaultTableModel)tabel_buku.getModel();
        int rowCount = dataBuku.getRowCount();
        while (rowCount > 0)
        {
            dataBuku.removeRow(rowCount - 1);
            rowCount = dataBuku.getRowCount();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
         clear();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_databuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_databuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_buku;
    private javax.swing.JTextField txt_Petugas;
    private javax.swing.JCheckBox txt_barab;
    private javax.swing.JCheckBox txt_bindonesia;
    private javax.swing.JCheckBox txt_binggris;
    private javax.swing.JRadioButton txt_fiksi;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_judulbuku;
    private javax.swing.JTextField txt_ketersediaan;
    private javax.swing.JRadioButton txt_nonfiksi;
    private javax.swing.JTextField txt_penerbit;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_thnterbit;
    // End of variables declaration//GEN-END:variables
}