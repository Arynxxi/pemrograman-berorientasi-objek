public class validasi {

    public void autoNomor(tableDataPenjualan modelDataPenjualan, String strAwal, Integer pnj, javax.swing.JTextField text ) {

        String s, sl;
        Integer j;

        s = Integer.toString(modelDataPenjualan.getRowCount() + 1);

        j = s.length();

        sl = "";

        for (int i = 1; i <= pnj; i++){
            sl = sl + "0";
        }

        text.setText(strAwal+sl+s);

    }

}
