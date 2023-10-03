import com.mysql.cj.conf.url.SingleConnectionUrl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.validation.Validator;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;;
import java.text.MessageFormat;
import java.util.SimpleTimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class penjualan extends javax.swing.JFrame{

    private JTextField tfKodeBarang;
    private JTextField tfNamaBarang;
    private JTextField tfHargaBarang;
    private JTextField tfStokBarang;
    private JButton btnSimpan;
    private JButton btnHapus;
    private JButton btnKeluar;
    private JButton btnEdit;
    private JPanel panelPenjualan;
    private JTable tablePenjualan;
    private JButton btnSearch;
    private JTextField tfSearch;
    private JScrollPane tableDisplay;
    private JComboBox cmbFilter;
    private JTextField tfFilter;
    private JButton btnNew;
    private JButton btnPrint;

    public static void main(String[] args) {
        JFrame frame = new JFrame("penjualan");
        frame.setContentPane(new penjualan().panelPenjualan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;

    validasi validasi = new validasi();
    private tableDataPenjualan modelDataPenjualan;


    public void koneksi() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_kasir", "root", "");
            System.out.println("Sukses");

            DatabaseMetaData metaData = con.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, "tbl_bayar", null);

        }catch (SQLException ex) {
            System.out.println("SQLExepction: " + ex.getMessage());
            System.out.println("SQLExepction: " + ex.getSQLState());
            System.out.println("SQLExepction: " + ex.getErrorCode());
        }

    }

    private void bersih() {

        tfKodeBarang.setText(null);
        tfNamaBarang.setText(null);
        tfHargaBarang.setText(null);
        tfStokBarang.setText(null);
        tfNamaBarang.requestFocus();

    }

    private void idAutoIncrement() {

        try {

            pst = con.prepareStatement("SELECT kode_brg FROM tbl_bayar ORDER BY kode_brg DESC LIMIT 1");
            ResultSet rs =  pst.executeQuery();

            if (rs.next()) {

                String kdMbr = rs.getString(1);
                String kode = kdMbr + 1;
                tfKodeBarang.setText(kode);

            }


        } catch (Exception ex) {

            Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void tablePenjualan() {

        try {

            pst = con.prepareStatement("SELECT *FROM tbl_bayar");
            ResultSet rs =  pst.executeQuery();
            tablePenjualan.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

    }

    public penjualan() {

        koneksi();
        tablePenjualan();

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kodebrg, namabrg, hargabrg, stokbrg;

                kodebrg = tfKodeBarang.getText();
                namabrg = tfNamaBarang.getText();
                hargabrg = tfHargaBarang.getText();
                stokbrg = tfStokBarang.getText();

                try {

                    pst = con.prepareStatement("INSERT INTO tbl_bayar(kode_brg, nama_brg, harga, stok) VALUES (?,?,?,?)");
                    pst.setString(1, kodebrg);
                    pst.setString(2, namabrg);
                    pst.setString(3, hargabrg);
                    pst.setString(4, stokbrg);

                    int k = pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!!!");

                    tablePenjualan();

                    if (k == 1) {
                        tfKodeBarang.setText("");
                        tfNamaBarang.setText("");
                        tfHargaBarang.setText("");
                        tfStokBarang.setText("");
                        tfKodeBarang.requestFocus();
                    } else {
                        System.out.println("Gagal");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String kdbrg;

                    kdbrg = tfKodeBarang.getText();

                    try {

                        pst = con.prepareStatement("DELETE FROM tbl_bayar WHERE kode_brg = ?");

                        pst.setString(1, kdbrg);

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil di hapus!!!");

                        tablePenjualan();
                        bersih();

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String kodebrg = tfSearch.getText();

                    pst = con.prepareStatement("SELECT kode_brg, nama_brg, harga, stok FROM tbl_bayar WHERE kode_brg = ?");
                    pst.setString(1, kodebrg);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {

                        String kdbrg = rs.getString(1);
                        String namabrg = rs.getString(2);
                        String harga = rs.getString(3);
                        String stok = rs.getString(4);

                        tfKodeBarang.setText(kdbrg);
                        tfNamaBarang.setText(namabrg);
                        tfHargaBarang.setText(harga);
                        tfStokBarang.setText(stok);

                    } else {

                        tfNamaBarang.setText("");
                        tfHargaBarang.setText("");
                        tfStokBarang.setText("");

                        JOptionPane.showMessageDialog(null,"Kode barang tidak ditemukan ");

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int app;

                if ((app = JOptionPane.showConfirmDialog(null, "Ubah data penjualan" + "?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0) {

                    try {

                        String sql = "UPDATE tbl_bayar SET"
                                + " kode_brg = '" +tfKodeBarang.getText()+ "', "
                                + " nama_brg = '" +tfNamaBarang.getText()+ "', "
                                + " harga = '" +tfHargaBarang.getText()+ "', "
                                + " stok = '" +tfStokBarang.getText()+ "' WHERE"
                                + " kode_brg = '" +tfKodeBarang.getText()+ "'";
                        pst.executeUpdate(sql);

                        tablePenjualan();

                    } catch (SQLException ex) {

                        System.err.print(ex);

                    }

                }
            }
        });

        tfFilter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                koneksi();

                String filetKolom = cmbFilter.getSelectedItem().toString();
                String filterValue = tfFilter.getText();

                try {

                    pst = con.prepareStatement("SELECT * FROM tbl_bayar WHERE " + filetKolom + " = ? ");
                    pst.setString(1, filterValue);
                    ResultSet rs = pst.executeQuery();


                    while (rs.next()) {

                        String kode = rs.getString("kode_brg");
                        String name = rs.getString("nama_brg");
                        int harga = rs.getInt("harga");
                        int stok = rs.getInt("stok");

                        tfKodeBarang.setText(kode);
                        tfNamaBarang.setText(name);
                        tfHargaBarang.setText(String.valueOf(harga));
                        tfStokBarang.setText(String.valueOf(stok));

                    }

                    tablePenjualan();

                }

                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MessageFormat header = new MessageFormat("Data Penjualan");
                MessageFormat footer = new MessageFormat("Page(0, number, integer)");

                try {

                    tablePenjualan.print(JTable.PrintMode.NORMAL, header, footer);

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, ex);

                }

            }
        });

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    pst = con.prepareStatement("SELECT kode_brg FROM tbl_bayar ORDER BY kode_brg DESC LIMIT 1");
                    ResultSet rs =  pst.executeQuery();

                    if (rs.next()) {

                        String kdMbr = rs.getString(1);
                        String kode = kdMbr + 1;
                        tfKodeBarang.setText(kode);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        tablePenjualan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = tablePenjualan.getSelectedRow();

                if (selectedRow >= 0) {
                    String kodeBrg = tablePenjualan.getValueAt(selectedRow, 0).toString();
                    String namabrg = tablePenjualan.getValueAt(selectedRow, 1).toString();
                    String hargaBrg = tablePenjualan.getValueAt(selectedRow, 2).toString();
                    String stokbrg = tablePenjualan.getValueAt(selectedRow, 3).toString();

                    tfKodeBarang.setText(kodeBrg);
                    tfNamaBarang.setText(namabrg);
                    tfHargaBarang.setText(hargaBrg);
                    tfStokBarang.setText(stokbrg);

                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

