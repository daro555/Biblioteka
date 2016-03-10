package biblioteka;

import java.io.*;
import java.util.Calendar;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Wypozyczenie implements Serializable{
    private Osoba osoba;
    private Ksiązka ksiazka;
    
   

    public Wypozyczenie(Osoba osoba, Ksiązka ksiazka) {
        this.osoba = osoba;
        this.ksiazka = ksiazka;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.osoba);
        hash = 47 * hash + Objects.hashCode(this.ksiazka);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wypozyczenie other = (Wypozyczenie) obj;
        if (!Objects.equals(this.osoba, other.osoba)) {
            return false;
        }
        if (!Objects.equals(this.ksiazka, other.ksiazka)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" + "osoba=" + osoba + ", ksiazka=" + ksiazka + '}';
    }
    
    
    
    
}
