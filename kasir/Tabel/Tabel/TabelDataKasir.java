/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class TabelDataKasir extends AbstractTableModel{
    private List<DataKasir> list = new ArrayList<>();

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
  switch(columnIndex){
    case 0 : return list.get(rowIndex).getKode();  
    case 1 : return list.get(rowIndex).getnama_brg();
    case 2 : return list.get(rowIndex).getharga();
    case 3 : return list.get(rowIndex).getstok();
    default : return null;
  }
}

@Override
public String getColumnName(int kolom){
  switch(kolom){
     case 0 : return "Kode Barang";
     case 1 : return "Nama Barang";
     case 2 : return "Harga Satuan";
     case 3 : return "Stok";
     default : return null;
  }
}

public void add(DataKasir kasir){
   list.add(kasir);
   fireTableRowsInserted(getRowCount(), getColumnCount());
}

public void delete(int i, int baris){
     list.remove(i);
     fireTableRowsDeleted(i, baris);
}

public DataKasir get(int baris){
     return (DataKasir) list.get(baris);
}

    int GetRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}