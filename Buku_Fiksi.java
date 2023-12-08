/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUGASPRAKTIKUM;

/**
 *
 * @author finaa
 */
public class Buku_Fiksi extends Buku{
    String genre;
    private String rating;
    
    public Buku_Fiksi()
    {
        rating = "5";
    }
    
    public String getRating()
    {
        return rating;
    }
    
    public void setRating(String rating)
    {
        this.rating = rating;
    }
    
     boolean cekRating(String rating)
    {
        if(rating.equals(getRating()))
        {
            return true;
        }
        return false;
    }
    
    void dataGenre(String genre)
    { 
        this.genre = genre; 
    }
    
    String cetakGenre()
    { 
        return genre;
    }

    @Override
    public void cetakInfo() 
    {
        System.out.println("Info Buku Fiksi:");
        System.out.println("Judul: " + judulBuku);
        super.cetakInfo();
    }  
}
