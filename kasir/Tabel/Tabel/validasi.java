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
public class validasi {
    public void autoNomor(TabelDataKasir ModelDataKasir,String strAwal,Integer pnj,javax.swing.JTextField text) {
        String s,sl;
        Integer j;
        s=Integer.toString(ModelDataKasir.getRowCount()+1);
        j=s.length();
        sl="";
        for(int i=1; i<=pnj-j;i++){
            sl=sl+"0";
            
        }
        text.setText(strAwal+sl+s);
    }
}
