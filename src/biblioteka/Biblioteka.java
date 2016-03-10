/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.Serializable;//ddddd

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
        try {
            s.otworzPlikBinarnyOsoby();

        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku z osobami");
        }
        try {
            s.otworzPlikBinarnyKsiązki();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku ksiązki");
        }
        try {
            s.otworzPlikBinarnyWypozyczenia();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku wypozyczenia");
        }

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
        System.out.println("zwrot ksiązki - 5");
        System.out.println("Lista ksiązek w bibliotece - 6");
        System.out.println("Lista wypozyczen -7");

        wybor = scaner.nextInt();
        switch (wybor) {
            case 1:
                System.out.println("zapisanie się do biblioteki");
                System.out.println("Podaj imię:");
                Scanner skaner1 = new Scanner(System.in);
                imie = skaner1.next();
                System.out.println("Podaj nazwisko:");
                Scanner skaner2 = new Scanner(System.in);
                nazwisko = skaner2.next();

                //s.usunWszystkieOsoby();
                //s.otworzPlikBinarnyOsoby();
                //s.usunWszystkieOsoby();
                s.dodajCzytelnika(imie, nazwisko);// czemu nie można wywołać metody bez s? i czemu obie linijki kodu dają błąd
                //s.zapisDoPlikuBinarnieOsoby();
                //s.zapiszDoPlikuText();
                s.wyswietlOsobyZapisane();

                break;
            case 2:
                System.out.println("Dodanie ksiązki");
                Scanner skaner3 = new Scanner(System.in);
                tytul = skaner3.next();
                Scanner skaner4 = new Scanner(System.in);
                iloscDostepna = skaner4.nextInt();

                s.dodajKsiazke(tytul, iloscDostepna);// będy bez Comparable, Serializable!
                s.wyswieltKsiazkiWBibliotece();

                s.zapisDoPlikuBinarnieKsiązki();

                break;
            case 3:
                System.out.println("Lista osób w bibliotece");
                //s.wyswietlOsobyZapisane();
                //s.otworzPlikBinarnyOsoby();
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
                System.out.println("Osoby zapisane:");
                s.wyswietlOsobyZapisane();
                System.out.println("Podaj dane uzytkownika: imie");
                Scanner skaner7 = new Scanner(System.in);
                imie = skaner7.nextLine();
                System.out.println("Podaj dane uzytkownika: nazwisko");
                Scanner skaner8 = new Scanner(System.in);
                nazwisko = skaner8.nextLine();

                //Osoba o = new Osoba(imie, nazwisko);//dodanie wypozyczenia
                s.dodajWypozyczenie(imie, nazwisko, tytul);

                break;
            case 5:
                System.out.println("Podaj dane osoby zwracającej");
                Scanner skaner9 = new Scanner(System.in);
                imie = skaner9.next();
                Scanner skaner10 = new Scanner(System.in);
                nazwisko = skaner10.next();
                Scanner skaner11 = new Scanner(System.in);
                tytul = skaner11.next();
                s.zwrotWyporzyczenia(imie, nazwisko, tytul);
            case 6:
                s.wyswietlKsiązkiWolne();
                break;
            case 7:
                s.wyswietlWypozyczenia();
                return;
        }
        s.zapisDoPlikuBinarnieOsoby();
        s.zapisDoPlikuBinarnieKsiązki();
        s.zapisDoPlikuBinarnieWypozyczenie();
    }

}
