/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class Produkt implements Serializable{//błąd wynikał z braku implementacji Serializable w klasie produkt; czemu?
    public String tytul;

    public Produkt(String tytul) {
        this.tytul = tytul;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tytul);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {//remove i contains zależą od equals z List 
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;//porównanie 2 klas
        }
        final Produkt other = (Produkt) obj;//rzutowanie na docelowy produkt z Object
        if (!Objects.equals(this.tytul, other.tytul)) {
            return false;
        }
        return true;//5 punktów z dokumentacji
    }
    

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    
    
}
