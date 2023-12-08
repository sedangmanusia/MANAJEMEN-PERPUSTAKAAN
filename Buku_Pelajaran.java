/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUGASPRAKTIKUM;

/**
 *
 * @author finaa
 */
public class Buku_Pelajaran extends Buku{
    String tingkat, matapelajaran;
    private String edisi;
    
    public Buku_Pelajaran()
    {
        edisi = "Khusus";
    }
    
    public String getEdisi()
    {
        return edisi;
    }
    
    public void setEdisi(String edisi)
    {
        this.edisi = edisi;
    }
    
    void dataTingkat(String tingkat)
    { 
        this.tingkat = tingkat; 
    }
    
    boolean cekEdisi(String edisi)
    {
        if(edisi.equals(getEdisi()))
        {
            return true;
        }
        return false;
    }
    
    void dataEdisi(String edisi)
    { 
        this.edisi = edisi; 
    }
    
    void dataMapel(String matapelajaran)
    { 
        this.matapelajaran = matapelajaran; 
    }
    
    String cetakTingkat()
    { 
        return tingkat;
    }
    
     String cetakEdisi()
    { 
        return edisi;
    }
     
     String cetakMapel()
    { 
        return matapelajaran;
    }

    @Override
    public void cetakInfo() 
    {
        System.out.println("Info Buku Pelajaran:");
        System.out.println("Judul: " + judulBuku);
        super.cetakInfo();   
    }
     
}
