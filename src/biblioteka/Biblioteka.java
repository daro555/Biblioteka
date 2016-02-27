/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Biblioteka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        BibliotekaMagazyn s = new BibliotekaMagazyn();
        int wybor;
        String imie;
        String nazwisko;
        String tytul;
        int iloscDostepna;
        // TODO code application logic here
        Scanner scaner = new Scanner(System.in);
        System.out.println("Zapisanie się do biblioteki - 1");
        System.out.println("Dodanie ksiązki - 2");
        System.out.println("Lista osób w bibliotece - 3 ");
        System.out.println("Wypozyczenie książki - 4");
        wybor = scaner.nextInt();
        switch (wybor) {
            case 1:
                System.out.println("zapisanie się do biblioteki");
                Scanner skaner1 = new Scanner(System.in);
                imie = skaner1.next();
                Scanner skaner2 = new Scanner(System.in);
                nazwisko = skaner2.next();
                Osoba osoba = new Osoba(imie, nazwisko);
                //s.usunWszystkieOsoby();
                //s.otworzPlikBinarnyOsoby();
                //s.usunWszystkieOsoby();
                s.dodajCzytelnika(osoba);// czemu nie można wywołać metody bez s? i czemu obie linijki kodu dają błąd
                s.zapisDoPlikuBinarnieOsoby();
                //s.zapiszDoPlikuText();
                s.wyswietlOsobyZapisane();

                break;
            case 2:
                System.out.println("Dodanie ksiązki");
                Scanner skaner3 = new Scanner(System.in);
                tytul = skaner3.next();
                Scanner skaner4 = new Scanner(System.in);
                iloscDostepna = skaner4.nextInt();
                Ksiązka ksiazka = new Ksiązka(tytul, iloscDostepna);
                s.dodajKsiazke(ksiazka);// będy bez Comparable, Serializable!

                s.zapisDoPlikuBinarnieKsiązki();

                break;
            case 3:
                System.out.println("Lista osób w bibliotece");
                //s.wyswietlOsobyZapisane();
                s.otworzPlikBinarnyOsoby();
                s.wyswietlOsobyZapisane();
                //s.usunWszystkieOsoby();
                //s.zapisDoPlikuBinarnieOsoby();

                break;
            case 4:

                System.out.println("Dodanie wypożyczenia");
                System.out.print("Wybierz ksiązkę z listy");
                s.wyswietlKsiązkiWolne();
                Scanner skaner5 = new Scanner(System.in);
                tytul = skaner5.next();
                //s.wyswietlOsobyZapisane();
                Scanner skaner7 = new Scanner(System.in);
                imie = skaner7.nextLine();
                Scanner skaner8 = new Scanner(System.in);
                nazwisko = skaner8.nextLine();
                Osoba o = new Osoba(imie, nazwisko);
                s.dodajWypozyczenie(o, tytul);

                break;
            case 9:
                return;
        }
    }

}
