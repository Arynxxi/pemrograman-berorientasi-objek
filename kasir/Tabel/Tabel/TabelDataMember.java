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
public class TabelDataMember extends AbstractTableModel{
    private List<DataMember> list = new ArrayList<DataMember>();
    
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
    case 0 : return list.get(rowIndex).getId();  
    case 1 : return list.get(rowIndex).getNama();
    case 2 : return list.get(rowIndex).getKeterangan();
    default : return null;
  }
}
@Override
public String getColumnName(int kolom){
  switch(kolom){
     case 0 : return "Id Barang";
     case 1 : return "Nama Barang";
     case 2 : return "Keterangan";
     default : return null;
  }
}

public void add(DataMember member){
   list.add(member);
   fireTableRowsInserted(getRowCount(), getColumnCount());
}

public void delete(int i, int baris){
     list.remove(i);
     fireTableRowsDeleted(i, baris);
}

public DataMember get(int baris){
     return (DataMember) list.get(baris);
}
}
