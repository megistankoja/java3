/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Book {
    private String titulli;
    private String autori;
    private int faqet;
    private String kategoria;
    private String rafti;

    /*public Book(String titulli, String autori, int faqet, String kategoria, int rafti) {
        super();
        this.titulli = titulli;
        this.autori = autori;
        this.faqet = faqet;
        this.kategoria = kategoria;
        this.rafti = rafti;
    }*/
    //get dhe set
    public String getTitulli() {
        return titulli;
    }

    public void setTitulli(String titulli) {
        this.titulli = titulli;
    }

    public String getAutori() {
        return autori;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public int getFaqet() {
        return faqet;
    }

    public void setFaqet(int faqet) {
        this.faqet = faqet;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getRafti() {
        return rafti;
    }

    public void setRafti(String rafti) {
        this.rafti = rafti;
    }
}
    
