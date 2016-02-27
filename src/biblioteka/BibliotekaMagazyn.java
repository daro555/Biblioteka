/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class BibliotekaMagazyn implements Comparable, Serializable {

    private String imie;
    private String nazwisko;
    private String tytul;

    List<Osoba> listaOsob;
    List<Ksiązka> listaKsiazek;
    List<BibliotekaMagazyn> listaWypozyczen;

    BibliotekaMagazyn() {
        listaOsob = new ArrayList<>();
        listaKsiazek = new ArrayList<>();
        listaWypozyczen = new ArrayList<>();

    }

    public BibliotekaMagazyn(Osoba o, Ksiązka k) {

        this.imie = o.getImie();
        this.nazwisko = o.getNazwisko();
        this.tytul = k.getTytul();

    }

    public void dodajKsiazke(Ksiązka p) {
        listaKsiazek.add(p);

    }

    public void listaKsiązek() {
        System.out.println(listaKsiazek);
    }

    public void usunKsiązke(Ksiązka p) {
        listaKsiazek.remove(p);
    }

    public void dodajOsoba(Osoba o) {
        listaOsob.add(o);
    }

    public void usunWszystkieOsoby() {
        listaOsob.removeAll(listaOsob);
    }

    public void zapisDoPlikuBinarnieOsoby() throws FileNotFoundException, IOException {

        FileOutputStream fileoutpustream = new FileOutputStream("Osoby.bin");
        try (ObjectOutputStream objectoutputsream = new ObjectOutputStream(fileoutpustream)) {
            objectoutputsream.writeObject(listaOsob);
        }
    }

    public void zapisDoPlikuBinarnieKsiązki() throws FileNotFoundException, IOException {
        FileOutputStream fileoutpustream = new FileOutputStream("Książki.bin");
        ObjectOutputStream objectoutputsream = new ObjectOutputStream(fileoutpustream);
        objectoutputsream.writeObject(listaKsiazek);
        objectoutputsream.close();
    }

    public void zapiszDoPlikuText() throws IOException {//metoda zdefiniowana tylko testowo
        FileWriter filewider = new FileWriter("Produkty.csv");
        PrintWriter printwriter = new PrintWriter(filewider);

        printwriter.println(listaOsob);

        printwriter.close();
    }

    public void otworzPlikBinarnyOsoby() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileinputstream = new FileInputStream("Osoby.bin");
        ObjectInputStream objectinputsream = new ObjectInputStream(fileinputstream);
        listaOsob = (List<Osoba>) objectinputsream.readObject();
        objectinputsream.close();

    }

    public void dodajWypozyczenie(Osoba o, String tytul) {
        if(listaOsob.contains(o)&& listaKsiazek.contains(tytul)){

            listaWypozyczen.add(this);
        } else {
            System.out.println("Brak ksiązki w bibliotece lub wypozyczjącego");
        }

    }

    public void usunWyporzyczenie(BibliotekaMagazyn w) {
        listaWypozyczen.remove(w);

    }

    public void wyswietlWypozyczenia() {
        System.out.println(listaWypozyczen);
    }
    public void wyswietlKsiązkiWolne(){
        System.out.println(listaKsiazek);
    }

    

    public void dodajCzytelnika(Osoba o) {
        dodajOsoba(o);
      
    }

    public void usunCzytelnika(Osoba o) {
        listaOsob.remove(o);
    }

    public void wyswietlOsobyZapisane() {
        System.out.println(listaOsob);
    }

    public void wyswieltKsiazkiWBibliotece() {
        System.out.println(listaKsiazek);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
