/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Ksiązka extends Produkt implements Serializable {

    private int iloscDostepna;

    public Ksiązka(String tytul, int iloscDostepna) {
        super(tytul);
        this.iloscDostepna = iloscDostepna;

    }

    @Override
    public String toString() {
        return "tytuł: "+ tytul + ";" +"iloscDostepna" +iloscDostepna;
    }

    public void setIloscDostepna(int iloscDostepna) {
        this.iloscDostepna = iloscDostepna;
    }

    public int getIloscDostepna() {
        return iloscDostepna;
    }
    
    
    
    

}
