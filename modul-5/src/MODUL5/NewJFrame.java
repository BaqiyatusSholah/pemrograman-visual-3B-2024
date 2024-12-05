/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MODUL5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OKI
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        LoadDataKaryawan();
        LoadDataProyek();
        LoadDataTransaksi();
        TambahComboBox();
    }

    public void LoadDataKaryawan(){    
    try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM tb_karyawan"; // Ganti dengan nama tabel Anda
            ResultSet rs = stmt.executeQuery(query);

            // Tambahkan data baris ke model tabel
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nama = rs.getString("nama");
                String jabatan = rs.getString("jabatan");
                String departemen = rs.getString("departemen");
                
                String tbdata[] = {id, nama, jabatan, departemen};
                DefaultTableModel tablemodel = (DefaultTableModel)tbkaryawan.getModel();
                tablemodel.addRow(tbdata);
            }

            // Tutup koneksi
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadDataProyek(){    
    try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM tb_proyek";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String namaproyek = rs.getString("nama_proyek");
                String durasi = rs.getString("durasi_pengerjaan");
                
                String tbdata[] = {id, namaproyek, durasi};
                DefaultTableModel tablemodel = (DefaultTableModel)tbproyek.getModel();
                tablemodel.addRow(tbdata);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void LoadDataTransaksi(){    
    try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM tb_transaksi";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String idkaryawan = String.valueOf(rs.getInt("id_karyawan"));
                String idproyek = String.valueOf(rs.getInt("id_proyek"));
                String durasi = rs.getString("peran");
                
                String tbdata[] = {idkaryawan, idproyek, durasi};
                DefaultTableModel tablemodel = (DefaultTableModel)tbtransaksi.getModel();
                tablemodel.addRow(tbdata);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void TambahComboBox(){
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT nama FROM tb_karyawan";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Menambahkan data ke JComboBox
            while (resultSet.next()) {
                boxkaryawan.addItem(resultSet.getString("nama"));
            }
            
            String query2 = "SELECT nama_proyek FROM tb_proyek";
            Statement statement2 = conn.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);

            // Menambahkan data ke JComboBox
            while (resultSet2.next()) {
                boxproyek.addItem(resultSet2.getString("nama_proyek"));
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        innamakaryawan = new javax.swing.JTextField();
        inidkaryawan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        injabatan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        indepartemen = new javax.swing.JTextField();
        btnaddkaryawan = new javax.swing.JButton();
        btneditkaryawan = new javax.swing.JButton();
        btndelkaryawan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbkaryawan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inidproyek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        innamaproyek = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        indurasi = new javax.swing.JTextField();
        btnaddproyek = new javax.swing.JButton();
        btneditproyek = new javax.swing.JButton();
        btndelproyek = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbproyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inperan = new javax.swing.JTextField();
        btnaddtransaksi = new javax.swing.JButton();
        btnedittransaksi = new javax.swing.JButton();
        btndeltransaksi = new javax.swing.JButton();
        boxproyek = new javax.swing.JComboBox<>();
        boxkaryawan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        outidkaryawan = new javax.swing.JTextField();
        outidproyek = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btncek = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbtransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(200, 565));

        inidkaryawan.setEditable(false);

        jLabel1.setText("ID");

        jLabel2.setText("NAMA");

        jLabel3.setText("JABATAN");

        jLabel4.setText("DEPARTEMEN");

        btnaddkaryawan.setText("TAMBAH");
        btnaddkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddkaryawanActionPerformed(evt);
            }
        });

        btneditkaryawan.setText("UBAH");
        btneditkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditkaryawanActionPerformed(evt);
            }
        });

        btndelkaryawan.setText("HAPUS");
        btndelkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelkaryawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inidkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(innamakaryawan)
                    .addComponent(injabatan)
                    .addComponent(indepartemen)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnaddkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndelkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(innamakaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(injabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddkaryawan)
                .addGap(18, 18, 18)
                .addComponent(btneditkaryawan)
                .addGap(18, 18, 18)
                .addComponent(btndelkaryawan)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_END);

        tbkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAMA", "JABATAN", "DEPARTEMEN"
            }
        ));
        tbkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbkaryawan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("KARYAWAN", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(200, 565));

        jLabel5.setText("ID");

        inidproyek.setEditable(false);

        jLabel6.setText("PROYEK");

        jLabel7.setText("DURASI");

        btnaddproyek.setText("TAMBAH");
        btnaddproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddproyekActionPerformed(evt);
            }
        });

        btneditproyek.setText("UBAH");
        btneditproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditproyekActionPerformed(evt);
            }
        });

        btndelproyek.setText("HAPUS");
        btndelproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelproyekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inidproyek)
                    .addComponent(innamaproyek)
                    .addComponent(indurasi)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnaddproyek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneditproyek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndelproyek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inidproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(innamaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddproyek)
                .addGap(18, 18, 18)
                .addComponent(btneditproyek)
                .addGap(18, 18, 18)
                .addComponent(btndelproyek)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.LINE_END);

        tbproyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROYEK", "DURASI (HARI)"
            }
        ));
        tbproyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproyekMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbproyek);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("PROYEK", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(200, 565));

        jLabel8.setText("KARYAWAN");

        jLabel9.setText("PROYEK");

        jLabel10.setText("PERAN");

        btnaddtransaksi.setText("TAMBAH");
        btnaddtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtransaksiActionPerformed(evt);
            }
        });

        btnedittransaksi.setText("UBAH");
        btnedittransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedittransaksiActionPerformed(evt);
            }
        });

        btndeltransaksi.setText("HAPUS");

        boxproyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));

        boxkaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));

        jLabel11.setText("ID KARYAWAN");

        outidkaryawan.setEditable(false);

        outidproyek.setEditable(false);

        jLabel12.setText("ID PROYEK");

        btncek.setText("CEK");
        btncek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inperan)
                    .addComponent(btnaddtransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btnedittransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndeltransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxproyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxkaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outidkaryawan)
                    .addComponent(outidproyek, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btncek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inperan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncek)
                .addGap(57, 57, 57)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outidproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddtransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnedittransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndeltransaksi)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.LINE_END);

        tbtransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_KARYAWAN", "ID_PROYEK", "PERAN"
            }
        ));
        tbtransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtransaksiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbtransaksi);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel9, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("TRANSAKSI", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddkaryawanActionPerformed
        // TODO add your handling code here:
        if(innamakaryawan.getText().equals("") || injabatan.getText().equals("") || indepartemen.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI SEMUA");
        }else{        
        String namakaryawan = innamakaryawan.getText();
        String jabatan =injabatan.getText();
        String departemen = indepartemen.getText();
        
        
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";
            PreparedStatement pst;

            Connection conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("INSERT INTO `tb_karyawan`(`nama`, `jabatan`, `departemen`) VALUES (?,?,?)");
            pst.setString(1, namakaryawan);
            pst.setString(2, jabatan);
            pst.setString(3, departemen);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Ditambah", JOptionPane.PLAIN_MESSAGE);
                DefaultTableModel tablemodel = (DefaultTableModel)tbkaryawan.getModel();
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataKaryawan();
                TambahComboBox();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);            
        }}
    }//GEN-LAST:event_btnaddkaryawanActionPerformed

    private void tbkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkaryawanMouseClicked
        // TODO add your handling code here:
        String id = tbkaryawan.getValueAt(tbkaryawan.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT id, nama, jabatan, departemen FROM tb_karyawan WHERE id = '" + id + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                inidkaryawan.setText(rs.getString("id"));
                innamakaryawan.setText(rs.getString("nama"));
                injabatan.setText(rs.getString("jabatan"));
                indepartemen.setText(rs.getString("departemen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbkaryawanMouseClicked

    private void btneditkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditkaryawanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbkaryawan.getModel();
        String id = tbkaryawan.getValueAt(tbkaryawan.getSelectedRow(), 0).toString();
        PreparedStatement pstmt;
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement("UPDATE `tb_karyawan` SET `id`='" + inidkaryawan.getText() + "',`nama`='" + innamakaryawan.getText() + "',`jabatan`='" + injabatan.getText() + "',`departemen`='" + indepartemen.getText() + "' WHERE id = '" + id + "'");
            
            int k = pstmt.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Diubah", JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataKaryawan();
            }                
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditkaryawanActionPerformed

    private void btndelkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelkaryawanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbkaryawan.getModel();
        String id = tbkaryawan.getValueAt(tbkaryawan.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM tb_karyawan WHERE id = '" + id + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            int k = pstmt.executeUpdate();
            if(k == 1){
                JOptionPane.showMessageDialog(null, "Sudah Terhapus", "Berhasil" ,JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataKaryawan();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndelkaryawanActionPerformed

    private void btnaddproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddproyekActionPerformed
        // TODO add your handling code here:
        if(innamaproyek.getText().equals("") || indurasi.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI SEMUA");
        }else{        
        String namaproyek = innamaproyek.getText();
        String durasi =indurasi.getText();        
        
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";
            PreparedStatement pst;

            Connection conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("INSERT INTO `tb_proyek`(`nama_proyek`, `durasi_pengerjaan`) VALUES (?,?)");
            pst.setString(1, namaproyek);
            pst.setString(2, durasi);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Ditambah", JOptionPane.PLAIN_MESSAGE);
                DefaultTableModel tablemodel = (DefaultTableModel)tbproyek.getModel();
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataProyek();
                TambahComboBox();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);            
        }}
    }//GEN-LAST:event_btnaddproyekActionPerformed

    private void tbproyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproyekMouseClicked
        // TODO add your handling code here:
        String id = tbproyek.getValueAt(tbproyek.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT id, nama_proyek, durasi_pengerjaan FROM tb_proyek WHERE id = '" + id + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                inidproyek.setText(rs.getString("id"));
                innamaproyek.setText(rs.getString("nama_proyek"));
                indurasi.setText(rs.getString("durasi_pengerjaan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbproyekMouseClicked

    private void btneditproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditproyekActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbproyek.getModel();
        String id = tbproyek.getValueAt(tbproyek.getSelectedRow(), 0).toString();
        PreparedStatement pstmt;
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement("UPDATE `tb_proyek` SET `id`='" + inidproyek.getText() + "',`nama_proyek`='" + innamaproyek.getText() + "',`durasi_pengerjaan`='" + indurasi.getText() + "' WHERE id = '" + id + "'");
            
            int k = pstmt.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Diubah", JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataProyek();
            }                
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditproyekActionPerformed

    private void btndelproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelproyekActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbproyek.getModel();
        String id = tbproyek.getValueAt(tbproyek.getSelectedRow(), 0).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM tb_proyek WHERE id = '" + id + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            int k = pstmt.executeUpdate();
            if(k == 1){
                JOptionPane.showMessageDialog(null, "Sudah Terhapus", "Berhasil" ,JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataProyek();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btndelproyekActionPerformed

    private void btnaddtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtransaksiActionPerformed
        // TODO add your handling code here:
        if(outidkaryawan.getText().equals("") || outidproyek.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI SEMUA");
        }else{        
        String idkaryawan = outidkaryawan.getText();
        String idproyek = outidproyek.getText();
        String peran = inperan.getText();
        
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";
            PreparedStatement pst;

            Connection conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("INSERT INTO `tb_transaksi`(`id_karyawan`, `id_proyek`, `peran`) VALUES (?,?,?)");
            pst.setString(1, idkaryawan);
            pst.setString(2, idproyek);
            pst.setString(3, peran);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Ditambah", JOptionPane.PLAIN_MESSAGE);
                DefaultTableModel tablemodel = (DefaultTableModel)tbtransaksi.getModel();
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataTransaksi();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);            
        }}
    }//GEN-LAST:event_btnaddtransaksiActionPerformed

    private void btncekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekActionPerformed
        // TODO add your handling code here:
        if(boxkaryawan.getSelectedItem().equals("PILIH") || boxproyek.getSelectedItem().equals("PILIH") || inperan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI SEMUA");
        }else{        
        String karyawan = (String) boxkaryawan.getSelectedItem();
        String proyek = (String) boxproyek.getSelectedItem();
        String peran = inperan.getText();    
        
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT id FROM tb_karyawan WHERE nama = '" + karyawan + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                outidkaryawan.setText(rs.getString("id"));
            }
            
            String query2 = "SELECT id FROM tb_proyek WHERE nama_proyek = '" + proyek + "'";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            
            ResultSet rs2 = pstmt2.executeQuery(query2);
            if (rs2.next()) {
                outidproyek.setText(rs2.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);            
        }}
    }//GEN-LAST:event_btncekActionPerformed

    private void btnedittransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedittransaksiActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tablemodel = (DefaultTableModel)tbtransaksi.getModel();
        String idkaryawan = tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 0).toString();
        String idproyek = tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 1).toString();
        PreparedStatement pstmt;
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement("UPDATE `tb_transaksi` SET `id_karyawan`='" + outidkaryawan.getText() + "',`id_proyek`='" + outidproyek.getText() + "',`peran`='" + inperan.getText() + "' WHERE id_karyawan = '" + idkaryawan + "' AND id_proyek = '" + idproyek + "'");
            
            int k = pstmt.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(null, "Silahkan Cek" ,"Berhasil Diubah", JOptionPane.PLAIN_MESSAGE);
                int rows = tablemodel.getRowCount(); 
                    for(int i = rows - 1; i >=0; i--){
                        tablemodel.removeRow(i); 
                    }
                LoadDataTransaksi();
            }                
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnedittransaksiActionPerformed

    private void tbtransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtransaksiMouseClicked
        // TODO add your handling code here:
        String idkaryawan = tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 0).toString();
        String idproyek = tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 1).toString();
        try {
            // Ganti dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/java_database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT id_karyawan, id_proyek, peran FROM tb_transaksi WHERE id_karyawan = '" + idkaryawan + "' AND id_proyek = '" + idproyek + "'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                outidkaryawan.setText(rs.getString("id_karyawan"));
                outidproyek.setText(rs.getString("id_proyek"));
                inperan.setText(rs.getString("peran"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbtransaksiMouseClicked

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxkaryawan;
    private javax.swing.JComboBox<String> boxproyek;
    private javax.swing.JButton btnaddkaryawan;
    private javax.swing.JButton btnaddproyek;
    private javax.swing.JButton btnaddtransaksi;
    private javax.swing.JButton btncek;
    private javax.swing.JButton btndelkaryawan;
    private javax.swing.JButton btndelproyek;
    private javax.swing.JButton btndeltransaksi;
    private javax.swing.JButton btneditkaryawan;
    private javax.swing.JButton btneditproyek;
    private javax.swing.JButton btnedittransaksi;
    private javax.swing.JTextField indepartemen;
    private javax.swing.JTextField indurasi;
    private javax.swing.JTextField inidkaryawan;
    private javax.swing.JTextField inidproyek;
    private javax.swing.JTextField injabatan;
    private javax.swing.JTextField innamakaryawan;
    private javax.swing.JTextField innamaproyek;
    private javax.swing.JTextField inperan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField outidkaryawan;
    private javax.swing.JTextField outidproyek;
    private javax.swing.JTable tbkaryawan;
    private javax.swing.JTable tbproyek;
    private javax.swing.JTable tbtransaksi;
    // End of variables declaration//GEN-END:variables
}
