/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUGASPRAKTIKUM;

/**
 *
 * @author finaa
 */
public class Buku extends Harga implements Petugas{
    //atribut
     String judulBuku, pengarang, penerbit, jenisBuku, bahasa,namaPetugas; 
     int tahunTerbit;
     
     private String statusKetersediaan; //enkapsulasi
     
     //method
    void dataJudul(String judulBuku){ 
        this.judulBuku = judulBuku; 
    }     
    void dataPengarang(String Pengarang){ 
        this.pengarang = Pengarang; 
    }  
    void dataPenerbit(String Penerbit){ 
        this.penerbit = Penerbit; 
    }
    int datathnTerbit(int thnTerbit){ 
       return this.tahunTerbit = thnTerbit; 
    } 
    void dataJenisBuku(String JenisBuku){ 
        this.jenisBuku = JenisBuku; 
    }
    void dataBahasa(String Bahasa){ 
        this.bahasa = Bahasa; 
    }
  
     String cetakJudul(){ 
        return judulBuku; 
    } 
    String cetakPengarang(){ 
        return pengarang; 
    } 
    String cetakPenerbit(){ 
        return penerbit; 
    }
    int cetakThnterbit(){ 
        return tahunTerbit; 
    }
    String cetakJenisBuku(){ 
        return jenisBuku; 
    } 
    String cetakBahasa(){ 
        return bahasa;
    }
    
    //enkapsulasi
    public String getStatusKetersediaan()
    {
        return statusKetersediaan;
    }
    
    public void setStatusKetersediaan(String tersedia)
    {
        this.statusKetersediaan = tersedia;
    }
    
    boolean cekKetersediaan(String statusKetersediaan)
    {
        if(this.statusKetersediaan.equals(statusKetersediaan))
        {
            return true;
        }
        return false;
    }
    
    //konstruktor
    public Buku()
    {
     this.judulBuku = "Laut Bercerita"; 
     this.pengarang = "Leila S. Chudori"; 
     this.penerbit = "Kepustakaan Populer Gramedia"; 
     this.tahunTerbit = 2022;
     this.jenisBuku = "Fiksi";
     this.bahasa = "Indonesia";
     statusKetersediaan = "Tersedia";
    }
    
    //ovverloading
    public void cetakInfo() 
    {
        System.out.println("Info Buku:");
        System.out.println("Judul: " + judulBuku);
    }
    
    public void cetakInfo(String keterangan) 
    {
        System.out.println("Info Buku:");
        System.out.println("Judul: " + judulBuku);
        System.out.println(keterangan);
    }
    
    //abstract
    @Override
    public double hargaBuku()
    {
        pajak = 0.1*hargaBuku;
        total = hargaBuku + pajak;
        return total;
    }
    
    public double getHargaBuku() {
        return hargaBuku;
    }
    
    public void setHargaBuku(double hargaBuku) {
        this.hargaBuku = hargaBuku;
    }
    
    //interface
    @Override
    public String namaPetugas()
    {
        return namaPetugas;
    }
    
    public String getnamaPetugas()
    {
        return namaPetugas;
    }
    
    public void setnamaPetugas(String namaPetugas)
    {
        this.namaPetugas = namaPetugas;
    }
}
