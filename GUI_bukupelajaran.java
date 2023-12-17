/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TUGASPRAKTIKUM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author finaa
 */
public class GUI_bukupelajaran extends javax.swing.JFrame  {

    /**
     * Creates new form GUI_bukupelajaran
     */
    public GUI_bukupelajaran() {
        initComponents();
        /**DefaultTableModel dataBukuPelajaran = (DefaultTableModel)tabel_buku_pelajaran.getModel();
        int rowCount = dataBukuPelajaran.getRowCount();
        while (rowCount > 0 )
        {
            dataBukuPelajaran.removeRow(rowCount - 1);
            rowCount = dataBukuPelajaran.getRowCount();
        }**/
    }
    String judul1,pengarang1, penerbit1, thnterbit1, mapel1, edisi1, tingkatText1;
    public Connection conn;
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_perpustakaan?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_databuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_databuku.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_databuku.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("JUDUL BUKU");
        tabelhead.addColumn("PENGARANG");
        tabelhead.addColumn("PENERBIT");
        tabelhead.addColumn("TAHUN TERBIT");
        tabelhead.addColumn("MATA PELAJARAN");
        tabelhead.addColumn("EDISI");
        tabelhead.addColumn("TINGKAT");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_bukupelajaran";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8),});
            }
            tabel_buku_pelajaran.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
    public void refresh() {
        new GUI_bukupelajaran().setVisible(true);
        this.setVisible(false);
    }
    
    public void insert() {
        String judulbuku = txt_judulbuku.getText();
        String pengarang = txt_pengarang.getText();
        String penerbit = txt_penerbit.getText();
        int thnterbit = (Integer.parseInt(txt_thnterbit.getText()));
        String mapel = txt_mapel.getText();
        String edisi = txt_edisi.getText();
       String selectedTingkat = cmb_pilih.getSelectedItem().toString(); // Ubah di sini
    String tingkatText = "";

    if (selectedTingkat.equals("Horor")) {
        tingkatText = "Horor";
    } else if (selectedTingkat.equals("Romance")) {
        tingkatText = "Romance";
    } else if (selectedTingkat.equals("Sains Fiksi")) {
        tingkatText = "Sains Fiksi";
    } else if (selectedTingkat.equals("Petualangan")) {
        tingkatText = "Petualangan";
    } else if (selectedTingkat.equals("Komedi")) {
        tingkatText = "Komedi";
    }
    try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_bukupelajaran (judul_buku, pengarang,penerbit, th_terbit, mapel, edisi, tingkat)"
            + "VALUES('" + judulbuku + "','" + pengarang + "','" + penerbit + "','" + thnterbit + "','" + mapel + "','" + edisi + "','" + tingkatText + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Buku!" + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    
    public void update() {
        String judulbuku = txt_judulbuku.getText();
        String pengarang = txt_pengarang.getText();
        String penerbit = txt_penerbit.getText();
        int thnterbit = (Integer.parseInt(txt_thnterbit.getText()));
        String mapel = txt_mapel.getText();
        String edisi = txt_edisi.getText();
        String selectedTingkat = (String) cmb_pilih.getSelectedItem();
    String tingkatText = "";
    
    if (selectedTingkat.equals("SD")) {
        tingkatText = "Sekolah Dasar";
    } else if (selectedTingkat.equals("SMP")) {
        tingkatText = "Sekolah Menengah Pertama";
    } else if (selectedTingkat.equals("SMA")) {
        tingkatText = "Sekolah Menengah Atas";
    } else if (selectedTingkat.equals("SMK")) {
        tingkatText = "Sekolah Menengah Kejuruan";
    } else if (selectedTingkat.equals("UMUM")) {
        tingkatText = "Umum";
    }
        String judullama = judul1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_bukupelajaran SET judul_buku='" + judulbuku + "'," + "pengarang='" + pengarang + "'," + "penerbit='" + penerbit + "'" + ",th_terbit='" + thnterbit + "',mapel='" + mapel + "',edisi='"+ edisi +"',tingkat='"+ tingkatText  + "' WHERE judul_buku = '" + judullama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Buku Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_bukupelajaran WHERE judul_buku='" + txt_judulbuku.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }
    
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_bukupelajaran WHERE `judul_buku`  LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txt_judulbuku.setText(rs.getString(2));
                    txt_pengarang.setText(rs.getString(3));
                    txt_penerbit.setText(rs.getString(4));
                    txt_thnterbit.setText(rs.getString(5));
                    txt_mapel.setText(rs.getString(6));
                    txt_edisi.setText(rs.getString(7));
                    String tingkText = rs.getString(8);
                    String selectedTingkat = (String) cmb_pilih.getSelectedItem();
    String tingkatText = "";
    
    if (selectedTingkat.equals("SD")) {
        tingkatText = "Sekolah Dasar";
    } else if (selectedTingkat.equals("SMP")) {
        tingkatText = "Sekolah Menengah Pertama";
    } else if (selectedTingkat.equals("SMA")) {
        tingkatText = "Sekolah Menengah Atas";
    } else if (selectedTingkat.equals("SMK")) {
        tingkatText = "Sekolah Menengah Kejuruan";
    } else if (selectedTingkat.equals("UMUM")) {
        tingkatText = "Umum";
    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    
    public void itempilih() {
        txt_judulbuku.setText(judul1);
        txt_pengarang.setText(pengarang1);
        txt_penerbit.setText(penerbit1);
        txt_thnterbit.setText(thnterbit1);
        txt_mapel.setText(mapel1);
        txt_edisi.setText(edisi1);
        String selectedTingkat = (String) cmb_pilih.getSelectedItem();
    String tingkatText = "";
    
    if (selectedTingkat.equals("SD")) {
        tingkatText = "Sekolah Dasar";
    } else if (selectedTingkat.equals("SMP")) {
        tingkatText = "Sekolah Menengah Pertama";
    } else if (selectedTingkat.equals("SMA")) {
        tingkatText = "Sekolah Menengah Atas";
    } else if (selectedTingkat.equals("SMK")) {
        tingkatText = "Sekolah Menengah Kejuruan";
    } else if (selectedTingkat.equals("UMUM")) {
        tingkatText = "Umum";
    }
    }
       public void clear() {
 txt_judulbuku.setText("");
 txt_pengarang.setText("");
 txt_penerbit.setText("");
 txt_thnterbit.setText("");
 txt_edisi.setText("");
 txt_mapel.setText(" ");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_judulbuku = new javax.swing.JTextField();
        txt_pengarang = new javax.swing.JTextField();
        txt_penerbit = new javax.swing.JTextField();
        txt_thnterbit = new javax.swing.JTextField();
        txt_mapel = new javax.swing.JTextField();
        txt_edisi = new javax.swing.JTextField();
        cmb_pilih = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_buku_pelajaran = new javax.swing.JTable();
        txtHapus = new javax.swing.JButton();
        txtBatal = new javax.swing.JButton();
        txtClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BUKU PELAJARAN");

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Pengarang");

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("Mata Pelajaran");

        jLabel7.setText("Edisi");

        jLabel8.setText("Tingkat");

        cmb_pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SD", "SMP", "SMA", "SMK", "UMUM" }));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        tabel_buku_pelajaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Mata Pelajaran", "Edisi", "Tingkat"
            }
        ));
        tabel_buku_pelajaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_buku_pelajaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_buku_pelajaran);

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        txtBatal.setText("Batal");
        txtBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatalActionPerformed(evt);
            }
        });

        txtClose.setText("Close");
        txtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCloseActionPerformed(evt);
            }
        });

        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_judulbuku)
                            .addComponent(txt_pengarang)
                            .addComponent(txt_penerbit)
                            .addComponent(txt_thnterbit)
                            .addComponent(txt_mapel)
                            .addComponent(txt_edisi)
                            .addComponent(cmb_pilih, 0, 205, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBatal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtClose)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUbah))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_judulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_thnterbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_mapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_edisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(txtHapus)
                    .addComponent(txtBatal)
                    .addComponent(txtClose)
                    .addComponent(btnUbah))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
        // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel 
/**JOptionPane.showMessageDialog(null, "Data anda Ditambahkan Ke tabel");
 // Mengambil model data dari tabel
 DefaultTableModel dataBukuPelajaran = (DefaultTableModel) tabel_buku_pelajaran.getModel();
 // Inisialisasi sebuah ArrayList bernama 'list'
 List list = new ArrayList<>();
 // Mengatur tabel untuk membuat kolom dari model secara otomatis
tabel_buku_pelajaran.setAutoCreateColumnsFromModel(true);
 // Membuat instance dari kelas Mahasiswa
 Buku_Pelajaran bukuA1 = new Buku_Pelajaran();
 // Mengatur data NIM menggunakan nilai dari komponen txtNim
 bukuA1.dataJudul(txt_judulbuku.getText());
 // Mengatur data Nama menggunakan nilai dari komponen txtNama
 bukuA1.dataPengarang(txt_pengarang.getText());
 // Mengatur jenis kelamin sesuai dengan radio button yang dipilih
 // Mengatur data Prodi menggunakan nilai dari komponen txtProdi
  bukuA1.dataPenerbit(txt_penerbit.getText());
 // Mengatur data Angkatan menggunakan nilai dari komponen txtAngkatan
  bukuA1.datathnTerbit(Integer.parseInt(txt_thnterbit.getText()));
 // Mengatur data Alamat menggunakan nilai dari komponen txtAlamat
 bukuA1.dataMapel(txt_mapel.getText());
 bukuA1.dataEdisi(txt_edisi.getText());
 
 String selectedTingkat = (String) cmb_pilih.getSelectedItem();
    String tingkatText = "";
    
    if (selectedTingkat.equals("SD")) {
        tingkatText = "Sekolah Dasar";
    } else if (selectedTingkat.equals("SMP")) {
        tingkatText = "Sekolah Menengah Pertama";
    } else if (selectedTingkat.equals("SMA")) {
        tingkatText = "Sekolah Menengah Atas";
    } else if (selectedTingkat.equals("SMK")) {
        tingkatText = "Sekolah Menengah Kejuruan";
    } else if (selectedTingkat.equals("UMUM")) {
        tingkatText = "Umum";
    }
 // Menambahkan data-data dari objek Mahasiswa ke dalam ArrayList 'list'
 list.add(bukuA1.cetakJudul());
 list.add(bukuA1.cetakPengarang());
 list.add(bukuA1.cetakPenerbit());
 list.add(bukuA1.cetakThnterbit());
 list.add(bukuA1.cetakMapel());
 list.add(bukuA1.cetakEdisi());
 list.add(tingkatText);
 //list.add(bukuA.cetakAlamat());
 // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
 dataBukuPelajaran.addRow(list.toArray());
 // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
 clear();**/
        
   /** boolean isAuthenticated = matematika2A.cekEdisi(edisi);
    if(isAuthenticated)
        {
            JOptionPane.showMessageDialog(rootPane, "Buku " + matematika2A.judulBuku + " Tersedia.");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Maaf, Buku " + matematika2A.judulBuku + " Tidak Tersedia Karena Edisi Khusus.");
        }**/
        
   /** String selectedTingkat = (String) cmb_pilih.getSelectedItem();
    String tingkatText = "";
    
    if (selectedTingkat.equals("SD")) {
        tingkatText = "Sekolah Dasar";
    } else if (selectedTingkat.equals("SMP")) {
        tingkatText = "Sekolah Menengah Pertama";
    } else if (selectedTingkat.equals("SMA")) {
        tingkatText = "Sekolah Menengah Atas";
    } else if (selectedTingkat.equals("SMK")) {
        tingkatText = "Sekolah Menengah Kejuruan";
    } else if (selectedTingkat.equals("UMUM")) {
        tingkatText = "Umum";
    }**/
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatalActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_txtBatalActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        // TODO add your handling code here:
        delete();
        /**DefaultTableModel dataBukuPelajaran = (DefaultTableModel)tabel_buku_pelajaran.getModel();
        int rowCount = dataBukuPelajaran.getRowCount();
        while (rowCount > 0)
        {
            dataBukuPelajaran.removeRow(rowCount - 1);
            rowCount = dataBukuPelajaran.getRowCount();
        }**/
    }//GEN-LAST:event_txtHapusActionPerformed

    private void txtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_txtCloseActionPerformed

    private void tabel_buku_pelajaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_buku_pelajaranMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_buku_pelajaran.getSelectedRow();
        judul1 = tabel_buku_pelajaran.getValueAt(tabel, 0).toString();
        pengarang1 = tabel_buku_pelajaran.getValueAt(tabel, 1).toString();
        penerbit1 = tabel_buku_pelajaran.getValueAt(tabel, 2).toString();
        thnterbit1 = tabel_buku_pelajaran.getValueAt(tabel, 3).toString();
        mapel1 = tabel_buku_pelajaran.getValueAt(tabel, 4).toString();
        edisi1 = tabel_buku_pelajaran.getValueAt(tabel, 5).toString();
        tingkatText1 = tabel_buku_pelajaran.getValueAt(tabel, 5).toString();
        itempilih();
    }//GEN-LAST:event_tabel_buku_pelajaranMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_bukupelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_bukupelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_bukupelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_bukupelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_bukupelajaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmb_pilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_buku_pelajaran;
    private javax.swing.JButton txtBatal;
    private javax.swing.JButton txtClose;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_edisi;
    private javax.swing.JTextField txt_judulbuku;
    private javax.swing.JTextField txt_mapel;
    private javax.swing.JTextField txt_penerbit;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_thnterbit;
    // End of variables declaration//GEN-END:variables

    private void batal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
