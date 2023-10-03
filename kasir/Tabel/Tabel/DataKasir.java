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
public class DataKasir {
    private String kode, nama_brg;
    private Integer harga, stok;
    
    public DataKasir(){
    }
    public String getKode(){
    return kode;    
    }
    public void setkode(String kode){
    this.kode = kode;
    }
    public String getnama_brg(){
    return nama_brg;
    }
    public void setnama_brg(String nama_brg){
    this.nama_brg = nama_brg;
    } 
    public Integer getharga(){
    return harga;
    }
    public void setharga(Integer harga){
    this.harga = harga;
    }
    public Integer getstok(){
    return stok;
    }
    public void setstok(Integer stok){
    this.stok = stok;
    }

}
