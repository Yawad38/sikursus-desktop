package view;
    import dao.PesertaDAO;
    import model.Peserta;
    import java.sql.SQLException;
    import java.util.List;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel;

public class PesertaFrame extends javax.swing.JFrame {

    private final PesertaDAO dao = new PesertaDAO();
    private int selectedId = -1;
    
    public PesertaFrame() {
      initComponents();
        buttonGroup1.add(rbLaki);
        buttonGroup1.add(rbPerempuan);
        
        // Konfigurasi JTable dan Muat Data Awal Pertemuan 10
        configureTable();
        loadTable();
        clearForm();
        
        setLocationRelativeTo(null);
    }
    

    private void configureTable() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "NIM", "Nama", "JK", "Prodi", "No. HP", "Email"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // JTable non-editable
            }
        };
        tblPeserta.setModel(model);
        tblPeserta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        // Pasang Event Mouse Clicked pada JTable
        tblPeserta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesertaMouseClicked(evt);
            }
        });
    }
    
    private void fillTable(List<Peserta> data) {
        DefaultTableModel model = (DefaultTableModel) tblPeserta.getModel();
        model.setRowCount(0); // Wajib direset agar tidak duplikat
        for (Peserta p : data) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNim(),
                p.getNama(),
                p.getJenisKelamin(),
                p.getProdi(),
                p.getNoHp(),
                p.getEmail()
            });
        }
    }
    
    private void loadTable() {
        try {
            fillTable(dao.findAll());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void refreshData() {
        loadTable();
        clearForm();
        txtCari.setText("");
    }
    
    private String getJenisKelamin() {
        if (rbLaki.isSelected()) return "L";
        if (rbPerempuan.isSelected()) return "P";
        return null;
    }
    
    private Peserta getFormData() {
        Peserta p = new Peserta();
        p.setId(selectedId);
        p.setNim(txtNim.getText().trim());
        p.setNama(txtNama.getText().trim());
        p.setJenisKelamin(getJenisKelamin());
        p.setProdi(txtProdi.getText().trim());
        p.setNoHp(txtNoHP.getText().trim());
        p.setEmail(txtEmail.getText().trim());
        return p;
    }
    
    private boolean validateForm() {
        if (txtNim.getText().trim().isEmpty() 
                || txtNama.getText().trim().isEmpty() 
                || txtProdi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM, Nama, dan Prodi wajib diisi.", "Validasi Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (getJenisKelamin() == null) {
            JOptionPane.showMessageDialog(this, "Pilih jenis kelamin terlebih dahulu.", "Validasi Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void clearForm() {
        selectedId = -1;
        txtNim.setText("");
        txtNama.setText("");
        buttonGroup1.clearSelection();
        txtProdi.setText("");
        txtNoHP.setText("");
        txtEmail.setText("");
        
        if (tblPeserta != null) {
            tblPeserta.clearSelection();
        }
        
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        txtNim.requestFocus();
    }
    
    private void tblPesertaMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblPeserta.getSelectedRow();
        if (row == -1) return;

        // Ambil ID dari kolom 0 JTable
        selectedId = Integer.parseInt(tblPeserta.getValueAt(row, 0).toString());
        txtNim.setText(tblPeserta.getValueAt(row, 1).toString());
        txtNama.setText(tblPeserta.getValueAt(row, 2).toString());
        
        String jk = tblPeserta.getValueAt(row, 3).toString();
        rbLaki.setSelected("L".equals(jk));
        rbPerempuan.setSelected("P".equals(jk));
        
        txtProdi.setText(tblPeserta.getValueAt(row, 4).toString());
        txtNoHP.setText(tblPeserta.getValueAt(row, 5).toString());
        txtEmail.setText(tblPeserta.getValueAt(row, 6).toString());

        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtNim = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtProdi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeserta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Master Data Peserta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(388, 388, 388))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel4.setText("Jenis Kelamin");

        jLabel11.setText("Program Studi");

        jLabel8.setText("NIM");

        jLabel9.setText("Nomor HP");

        jLabel2.setText("Nama Peserta");

        jLabel10.setText("Email");

        txtNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHPActionPerformed(evt);
            }
        });

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        rbLaki.setText("Laki-Laki");

        rbPerempuan.setText("Perempuan");

        txtNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNimActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("FORM PESERTA");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                                    .addComponent(txtNoHP)
                                    .addComponent(txtEmail)))
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(38, 38, 38)
                                    .addComponent(rbLaki)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbPerempuan)
                                    .addGap(638, 638, 638))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNim, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                                        .addComponent(txtNama))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Peserta");

        jLabel14.setText("Pencarian");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblPeserta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPeserta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(414, 414, 414))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getJenisPeserta() {
        if (rbLaki.isSelected()) {
            return "Mahasiswa";
        }
        if (rbPerempuan.isSelected()) {
            return "Umum";
        }
        return "";
    }
    
    private double hitungBiayaDasar(String kursus) {
        double biaya = 0;
        switch (kursus) {
            case "Java Desktop":
                biaya = 500_000;
                break;
            case "Data Science":
                biaya = 650_000;
                break;
            case "Web Programming":
                biaya = 450_000;
                break;
            case "UI/UX Design":
                biaya = 400_000;
                break;
            default:
                biaya = 0;
                break;
        }
        return biaya;
    }
    
//    private double hitungBiayaFasilitas() {
//        double total = 0;
//        if (cbModul.isSelected()) {
//            total += 50_000;
//        }
//        if (cbSertifikat.isSelected()) {
//            total += 75_000;
//        }
//        if (cbRekaman.isSelected()) {
//            total += 40_000;
//        }
//        return total;
//    }
    
//    private String buatRingkasanFasilitas() {
//        String[] fasilitasDipilih = new String[3];
//        int jumlah = 0;
//        
//        if (cbModul.isSelected()) {
//            fasilitasDipilih[jumlah] = "Modul Cetak";
//            jumlah++;
//        }
//        if (cbSertifikat.isSelected()) {
//            fasilitasDipilih[jumlah] = "Sertifikat";
//            jumlah++;
//        }
//        if (cbRekaman.isSelected()) {
//            fasilitasDipilih[jumlah] = "Akses Rekaman";
//            jumlah++;
//        }
//        
//        if (jumlah == 0) {
//            return "Tidak ada fasilitas tambahan";
//        }
//        
//        StringBuilder hasil = new StringBuilder();
//        for (int i = 0; i < jumlah; i++) {
//            hasil.append("- ").append(fasilitasDipilih[i]).append("\n");
//        }
//        return hasil.toString();
//    }
//    
//    private boolean validasiInput() {
//        String nama = txtNama.getText().trim();
//        String kode = new String(txtKodeAkses.getPassword()).trim();
//        
//        if (nama.isEmpty()) {
//            javax.swing.JOptionPane.showMessageDialog(this,
//                "Nama peserta wajib diisi.",
//                "Validasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE);
//            txtNama.requestFocus();
//            return false;
//        }
//        if (!kode.equals("PB02026")) { 
//            javax.swing.JOptionPane.showMessageDialog(this,
//                "Kode akses demo salah.",
//                "Validasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE);
//            txtKodeAkses.requestFocus();
//            return false;
//        }
//        if (!rbLaki.isSelected() && !rbPerempuan.isSelected()) {
//            javax.swing.JOptionPane.showMessageDialog(this,
//                "Pilih jenis peserta.",
//                "Validasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (cmbKursus.getSelectedIndex() == 0) {
//            javax.swing.JOptionPane.showMessageDialog(this,
//                "Pilih kursus terlebih dahulu.",
//                "Validasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        return true;
//    }
    
    
    
    private void resetForm() {
        txtNama.setText("");
    //    txtKodeAkses.setText("");
        buttonGroup1.clearSelection();
    //    cmbKursus.setSelectedIndex(0);
     //   cbModul.setSelected(false);
     //   cbSertifikat.setSelected(false);
     //   cbRekaman.setSelected(false);
     //   txtRingkasan.setText("");
        txtNama.requestFocus();
    }
    
    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       if (!validateForm()) return;

        try {
            Peserta p = getFormData();
            if (dao.insert(p)) {
                JOptionPane.showMessageDialog(this, "Data peserta berhasil disimpan.");
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak tersimpan.", "Informasi", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data:\n" + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

//       String nim = txtNim.getText().trim();
//        String nama = txtNama.getText().trim();
//        String prodi = txtNoHP.getText().trim();
//        String noHp = txtEmail.getText().trim();
//        String email = txtEmail.getText().trim();
//
//        String jenisKelamin = "";
//        if (rbLaki.isSelected()) {
//            jenisKelamin = "L";
//        } else if (rbPerempuan.isSelected()) {
//            jenisKelamin = "P";
//        }
//
//        // Validasi input UI
//        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || jenisKelamin.isEmpty()) {
//            javax.swing.JOptionPane.showMessageDialog(
//                this,
//                "NIM, nama, jenis kelamin, dan prodi wajib diisi.",
//                "Validasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE
//            );
//            return;
//        }
//
//        Peserta peserta = new Peserta(nim, nama, jenisKelamin, prodi, noHp, email);
//        PesertaDAO dao = new PesertaDAO();
//
//        try {
//        boolean berhasil = dao.insert(peserta);
//        if (berhasil) {
//            // 3. Jika berhasil masuk MySQL, Tampilkan Ringkasan ke txtRingkasan
//            String jenisTeks = jenisKelamin.equals("L") ? "Laki-laki" : "Perempuan";
//            String ringkasan = "DATA PESERTA BERHASIL DISIMPAN\n" +
//                               "===============================\n" +
//                               "NIM           : " + nim + "\n" +
//                               "Nama          : " + nama + "\n" +
//                               "Jenis Kelamin : " + jenisTeks + "\n" +
//                               "Prodi         : " + prodi + "\n" +
//                               "No. HP        : " + noHp + "\n" +
//                               "Email         : " + email + "\n" +
//                               "===============================\n" +
//                               "Status        : Tersimpan di Database (db_sikursus)";
//            
//            txtRingkasan.setText(ringkasan);
//
//            javax.swing.JOptionPane.showMessageDialog(
//                this, 
//                "Data peserta berhasil disimpan ke database."
//            );
//        } else {
//            javax.swing.JOptionPane.showMessageDialog(
//                this,
//                "Data tidak tersimpan.",
//                "Informasi",
//                javax.swing.JOptionPane.WARNING_MESSAGE
//            );
//        }
//    } catch (java.sql.SQLException e) {
//        javax.swing.JOptionPane.showMessageDialog(
//            this,
//            "Gagal menyimpan data:\n" + e.getMessage(),
//            "Database Error",
//            javax.swing.JOptionPane.ERROR_MESSAGE
//        );
//        e.printStackTrace();
//        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        loadTable();
        clearForm();
        txtCari.setText("");

//        if (selectedId <= 0) {
//            JOptionPane.showMessageDialog(this, "Pilih data peserta pada tabel terlebih dahulu.");
//            return;
//        }
//
//        if (!validateForm()) return;
//
//        try {
//            Peserta p = getFormData();
//            if (dao.update(p)) {
//                JOptionPane.showMessageDialog(this, "Data peserta berhasil diubah.");
//                refreshData();
//            } else {
//                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau tidak berubah.");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
//        }

//       int jawab = javax.swing.JOptionPane.showConfirmDialog(this,
//            "Kosongkan seluruh input?",
//            "Konfirmasi Reset",
//            javax.swing.JOptionPane.YES_NO_OPTION);
//            
//        if (jawab == javax.swing.JOptionPane.YES_OPTION) {
//            resetForm();
//        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNimActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHPActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        if (selectedId <= 0) {
            JOptionPane.showMessageDialog(this, "Pilih data peserta pada tabel terlebih dahulu.");
            return;
        }

        if (!validateForm()) return;

        try {
            Peserta p = getFormData();
            if (dao.update(p)) {
                JOptionPane.showMessageDialog(this, "Data peserta berhasil diubah.");
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau tidak berubah.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (selectedId <= 0) {
            JOptionPane.showMessageDialog(this, "Pilih data peserta yang akan dihapus.");
            return;
        }

        String nama = txtNama.getText().trim();
        int jawab = JOptionPane.showConfirmDialog(
            this,
            "Yakin menghapus peserta: " + nama + "?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (jawab != JOptionPane.YES_OPTION) return;

        try {
            if (dao.delete(selectedId)) {
                JOptionPane.showMessageDialog(this, "Data peserta berhasil dihapus.");
                refreshData();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdiActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String keyword = txtCari.getText().trim();
        try {
            if (keyword.isEmpty()) {
                loadTable();
            } else {
                fillTable(dao.search(keyword));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Pencarian gagal: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(PesertaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesertaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesertaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesertaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesertaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tblPeserta;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextField txtProdi;
    // End of variables declaration//GEN-END:variables
}
