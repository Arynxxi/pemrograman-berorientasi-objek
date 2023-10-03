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
public class DataMember {
    private String Id, Nama, Keterangan;
    
    public DataMember(){    
    }
    public String getId(){
        return Id;
    }
    public void setId(String Id){
        this.Id = Id;
    }
    public String getNama(){
        return Nama;
    }
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    public String getKeterangan(){
        return Keterangan;
    }
    public void setKeterangan(String Keterangan){
        this.Keterangan = Keterangan;
    }
}
