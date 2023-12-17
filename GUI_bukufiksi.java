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
public class GUI_bukufiksi extends javax.swing.JFrame {

    /**
     * Creates new form GUI_bukufiksi
     */
    public GUI_bukufiksi() {
        initComponents();
        tampil();
       /** DefaultTableModel dataBukuFiksi = (DefaultTableModel)tabel_buku_fiksi.getModel();
        int rowCount = dataBukuFiksi.getRowCount();
        while (rowCount > 0 )
        {
            dataBukuFiksi.removeRow(rowCount - 1);
            rowCount = dataBukuFiksi.getRowCount();
        }**/
    }
    String judul1,pengarang1, penerbit1, thnterbit1, jenisbuku1,tingkatText1;
    public Connection conn;
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_perpustakaan?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_bukufiksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_bukufiksi.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_bukufiksi.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("JUDUL BUKU");
        tabelhead.addColumn("PENGARANG");
        tabelhead.addColumn("PENERBIT");
        tabelhead.addColumn("TAHUN TERBIT");
        tabelhead.addColumn("GENRE");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_bukufiksi";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), });
            }
            tabel_buku_fiksi.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
    public void refresh() {
        new GUI_bukufiksi().setVisible(true);
        this.setVisible(false);
    }
    
    public void insert() {
        String judulbuku = txt_judulbuku.getText();
        String pengarang = txt_pengarang.getText();
        String penerbit = txt_penerbit.getText();
        int thnterbit = (Integer.parseInt(txt_thnterbit.getText()));
        String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
            statement.executeUpdate("INSERT INTO tb_bukufiksi (judul_buku, pengarang,penerbit, th_terbit, genre)"
            + "VALUES('" + judulbuku + "','" + pengarang + "','" + penerbit + "','" + thnterbit + "','" + tingkatText + "')");
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
        String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
        String judullama = judul1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_bukufiksi SET judul_buku='" + judulbuku + "'," + "pengarang='" + pengarang + "'," + "penerbit='" + penerbit + "'" + ",th_terbit='" + thnterbit + "',genre='" + tingkatText  + "' WHERE judul_buku = '" + judullama + "'");
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
                String sql = "DELETE FROM tb_bukufiksi WHERE judul_buku='" + txt_judulbuku.getText() + "'";
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
                String sql = "SELECT * FROM tb_databuku WHERE `judul_buku`  LIKE '%" + txtSearch.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txt_judulbuku.setText(rs.getString(2));
                    txt_pengarang.setText(rs.getString(3));
                    txt_penerbit.setText(rs.getString(4));
                    txt_thnterbit.setText(rs.getString(5));
                    String tingkText = rs.getString(6);
                    String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
        String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
    }

    
    public void clear() {
 txt_judulbuku.setText("");
 txt_pengarang.setText("");
 txt_penerbit.setText("");
 txt_thnterbit.setText("");
 txt_rating.setText(" ");
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
        cmb_pilih = new javax.swing.JComboBox<>();
        txtSimpan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_rating = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_buku_fiksi = new javax.swing.JTable();
        txtHapus = new javax.swing.JButton();
        txtBatal = new javax.swing.JButton();
        txtClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BUKU FIKSI");

        jLabel2.setText("JUDUL BUKU");

        jLabel3.setText("PENGARANG");

        jLabel4.setText("PENERBIT");

        jLabel5.setText("TAHUN TERBIT");

        jLabel6.setText("GENRE");

        txt_pengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pengarangActionPerformed(evt);
            }
        });

        txt_thnterbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thnterbitActionPerformed(evt);
            }
        });

        cmb_pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horor", "Romance", "Sains Fiksi", "Petualangan", "Komedi", " " }));
        cmb_pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pilihActionPerformed(evt);
            }
        });

        txtSimpan.setText("Simpan");
        txtSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSimpanActionPerformed(evt);
            }
        });

        jLabel7.setText("RATING");

        txt_rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ratingActionPerformed(evt);
            }
        });

        tabel_buku_fiksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Genre"
            }
        ));
        tabel_buku_fiksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_buku_fiksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_buku_fiksi);

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

        btnSearch.setText("Search");
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
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_judulbuku)
                            .addComponent(txt_pengarang)
                            .addComponent(txt_penerbit)
                            .addComponent(txt_thnterbit)
                            .addComponent(cmb_pilih, 0, 173, Short.MAX_VALUE)
                            .addComponent(txt_rating))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUbah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBatal)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtClose))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(53, 53, 53)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_judulbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(cmb_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSimpan)
                    .addComponent(txtHapus)
                    .addComponent(txtBatal)
                    .addComponent(txtClose)
                    .addComponent(btnUbah))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pengarangActionPerformed

    private void txt_thnterbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thnterbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thnterbitActionPerformed

    private void cmb_pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_pilihActionPerformed

    private void txtSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    /**JOptionPane.showMessageDialog(null, "Data anda Ditambahkan Ke tabel");
 // Mengambil model data dari tabel
 DefaultTableModel dataBukuFiksi = (DefaultTableModel) tabel_buku_fiksi.getModel();
 // Inisialisasi sebuah ArrayList bernama 'list'
 List list = new ArrayList<>();
 // Mengatur tabel untuk membuat kolom dari model secara otomatis
tabel_buku_fiksi.setAutoCreateColumnsFromModel(true);
 // Membuat instance dari kelas Mahasiswa
 Buku bukuA2 = new Buku_Fiksi();//polimorfism
 // Mengatur data NIM menggunakan nilai dari komponen txtNim
 bukuA2.dataJudul(txt_judulbuku.getText());
 // Mengatur data Nama menggunakan nilai dari komponen txtNama
 bukuA2.dataPengarang(txt_pengarang.getText());
 // Mengatur jenis kelamin sesuai dengan radio button yang dipilih
 // Mengatur data Prodi menggunakan nilai dari komponen txtProdi
  bukuA2.dataPenerbit(txt_penerbit.getText());
 // Mengatur data Angkatan menggunakan nilai dari komponen txtAngkatan
  bukuA2.datathnTerbit(Integer.parseInt(txt_thnterbit.getText()));
 // Mengatur data Alamat menggunakan nilai dari komponen txtAlama
 
 String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
 // Menambahkan data-data dari objek Mahasiswa ke dalam ArrayList 'list'
 list.add(bukuA2.cetakJudul());
 list.add(bukuA2.cetakPengarang());
 list.add(bukuA2.cetakPenerbit());
 list.add(bukuA2.cetakThnterbit());
 list.add(tingkatText);
 //list.add(bukuA.cetakAlamat());
 // Menambahkan baris baru ke model tabel menggunakan data dari ArrayList 'list'
 dataBukuFiksi.addRow(list.toArray());
 // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen
 clear();**/
        
    /**boolean isAuthenticated = Hujan.cekRating(rating);
    if(isAuthenticated)
        {
            JOptionPane.showMessageDialog(rootPane, "Buku " + Hujan.judulBuku + " Tersedia.");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Maaf, Buku " + Hujan.judulBuku + " Tidak Tersedia.");
        }
    
    String selectedTingkat = (String) cmb_pilih.getSelectedItem();
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
    }**/
    
    /**String output = "--DATA BUKU--\n";
    output += "--------------------------------------------------------\n";
    output += "JUDUL BUKU    : " + Hujan.cetakJudul() + "\n";
    output += "PENGARANG     : " + Hujan.cetakPengarang() + "\n";
    output += "PENERBIT      : " + Hujan.cetakPenerbit() + "\n";
    output += "TAHUN TERBIT  : " + Hujan.cetakThnterbit() + "\n";
    output += "TINGKAT      : " + tingkatText + "\n";
    
    txt_tampil.setText(output);**/
    }//GEN-LAST:event_txtSimpanActionPerformed

    private void txt_ratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ratingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ratingActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        // TODO add your handling code here:
        delete();
       /** DefaultTableModel dataBukuFiksi = (DefaultTableModel)tabel_buku_fiksi.getModel();
        int rowCount = dataBukuFiksi.getRowCount();
        while (rowCount > 0)
        {
            dataBukuFiksi.removeRow(rowCount - 1);
            rowCount = dataBukuFiksi.getRowCount();
        }**/
    }//GEN-LAST:event_txtHapusActionPerformed

    private void txtBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatalActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_txtBatalActionPerformed

    private void txtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_txtCloseActionPerformed

    private void tabel_buku_fiksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_buku_fiksiMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_buku_fiksi.getSelectedRow();
        judul1 = tabel_buku_fiksi.getValueAt(tabel, 0).toString();
        pengarang1 = tabel_buku_fiksi.getValueAt(tabel, 1).toString();
        penerbit1 = tabel_buku_fiksi.getValueAt(tabel, 2).toString();
        thnterbit1 = tabel_buku_fiksi.getValueAt(tabel, 3).toString();
        jenisbuku1 = tabel_buku_fiksi.getValueAt(tabel, 4).toString();
        tingkatText1 = tabel_buku_fiksi.getValueAt(tabel, 5).toString();
        itempilih();
    }//GEN-LAST:event_tabel_buku_fiksiMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_bukufiksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_bukufiksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_bukufiksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_bukufiksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_bukufiksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmb_pilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_buku_fiksi;
    private javax.swing.JButton txtBatal;
    private javax.swing.JButton txtClose;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton txtSimpan;
    private javax.swing.JTextField txt_judulbuku;
    private javax.swing.JTextField txt_penerbit;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_rating;
    private javax.swing.JTextField txt_thnterbit;
    // End of variables declaration//GEN-END:variables

    private void batal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
