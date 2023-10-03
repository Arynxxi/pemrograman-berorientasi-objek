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

public class member extends javax.swing.JFrame {
    private JTextField tfKode;
    private JTextField tfNama;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnPrint;
    private JButton btnTutup;
    private JTable tableMember;
    private JTextField tfKeterangan;
    private JPanel panelMember;
    private JList listMember;
    private JScrollPane tableDisplay;
    private JList lstKeterangan;

    Connection con;
    PreparedStatement pst;

    DefaultListModel listModel = new DefaultListModel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("member");
        frame.setContentPane(new member().panelMember);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void koneksi() {

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/db_kasir", "root", "");
            System.out.println("Sukses");

            DatabaseMetaData metaData = con.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, "tbl_memberr", null);


        }catch (SQLException ex) {
            System.out.println("SQLExepction: " + ex.getMessage());
            System.out.println("SQLExepction: " + ex.getSQLState());
            System.out.println("SQLExepction: " + ex.getErrorCode());
        }

    }

    private void bersih() {

        tfKode.setText(null);
        tfNama.setText(null);
        tfNama.requestFocus();

    }

    private void tableMember() {

        try {

            pst = con.prepareStatement("SELECT *FROM tbl_memberr");
            ResultSet rs =  pst.executeQuery();
            tableMember.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

    }

    private JList<String> itemList;

    public member() {

        koneksi();
        tableMember();

//        itemList = new JList<>(listMember.getModel());

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idmbr, namambr;

                idmbr= tfKode.getText();
                namambr = tfNama.getText();
                String[] keterangan = (String[]) listMember.getSelectedValuesList().toArray(new String[0]);

                try {

                    pst = con.prepareStatement("INSERT INTO tbl_memberr(id_member, nama_member, keterangan) VALUES (?,?,?)");

                    for (String items : keterangan) {

                        pst.setString(1, idmbr);
                        pst.setString(2, namambr);
                        pst.setString(3, items);

                    }

                    int k = pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!!!");

                    tableMember();

                    if (k == 1) {
                        tfKode.setText("");
                        tfNama.setText("");
                        tfKode.requestFocus();
                    } else {
                        System.out.println("Gagal");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idmbr;

                idmbr = tfKode.getText();

                try {

                    pst = con.prepareStatement("DELETE FROM tbl_memberr WHERE id_member = ?");

                    pst.setString(1, idmbr);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil di hapus!!!");

                    tableMember();
                    bersih();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }

        });

        btnTutup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int app;

                if ((app = JOptionPane.showConfirmDialog(null, "Ubah data penjualan" + "?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0) {

                    try {

                        String sql = "UPDATE tbl_memberr SET"
                                + " id_member = '" +tfKode.getText()+ "', "
                                + " nama_member = '" +tfNama.getText()+ "', "
                                + " keterangan = '" +listMember.getSelectedValuesList()+ "' WHERE "
                                + " id_member = '" +tfKode.getText()+ "'";
                        pst.executeUpdate(sql);

                        tableMember();

                    } catch (SQLException ex) {

                        System.err.print(ex);

                    }

                }

            }
        });

        tableMember.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = tableMember.getSelectedRow();

                if (selectedRow >= 0) {
                    String idMbr = tableMember.getValueAt(selectedRow, 0).toString();
                    String namaMbr = tableMember.getValueAt(selectedRow, 1).toString();
                    String ket = tableMember.getValueAt(selectedRow, 2).toString();

                    tfKode.setText(idMbr);
                    tfNama.setText(namaMbr);

                }

            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MessageFormat header = new MessageFormat("Data Member");
                MessageFormat footer = new MessageFormat("Page(0, number, integer)");

                try {

                    tableMember.print(JTable.PrintMode.NORMAL, header, footer);

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, ex);

                }

            }
        });
    }

}
