package biblioteka;

import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
//klasa testowa do Calendar - brak zastosowania
public class WypozyczenieCzas  {
    Calendar poczatek;
    Calendar koniec;
    Wypozyczenie w;

    public WypozyczenieCzas(Calendar poczatek, Calendar koniec, Wypozyczenie w) {
        this.w =w;
        this.poczatek = poczatek;
        this.koniec = koniec;
    }
    
    
}
