import com.mysql.cj.xdevapi.Table;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableDataPenjualan extends AbstractTableModel{

    private List<dataPenjualan> list = new ArrayList<dataPenjualan>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0 : return list.get(rowIndex).getKode();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getharga();
            case 3 : return list.get(rowIndex).getStok();

            default: return null;

        }
    }

    public String getColumnName(int kolom) {

        switch (kolom) {

            case 0 : return "KODE";
            case 1 : return "NAMA BARANG";
            case 2 : return "HARGA";
            case 3 : return "STOK";

            default: return null;

        }

    }

    public void add(dataPenjualan kasir) {

        list.add(kasir);
        fireTableRowsInserted(getRowCount(), getColumnCount());

    }

    public dataPenjualan get (int baris) {

        return (dataPenjualan) list.get(baris);

    }
}

