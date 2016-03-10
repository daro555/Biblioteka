package biblioteka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;

public class BibliotekaMagazyn implements Comparable, Serializable {

    private String imie;
    private String nazwisko;
    private String tytul;
    private int iloscDostepna;

    List<Osoba> listaOsob;
    //List<Ksiązka> listaKsiazek;
    List<Wypozyczenie> listaWypozyczen;//
    Map<Ksiązka, Integer> dostepnoscKsiazki;

    BibliotekaMagazyn() {
        listaOsob = new ArrayList<>();
        //listaKsiazek = new ArrayList<>();//usunac!
        listaWypozyczen = new ArrayList<>();
        dostepnoscKsiazki = new HashMap<>();

    }

    //public BibliotekaMagazyn(Osoba o, Ksiązka k) {//przerobic na klase wypozyczenie; 
    //this.imie = o.getImie();
    //this.nazwisko = o.getNazwisko();
    //this.tytul = k.getTytul();
    //}
    public void dodajKsiazke(String tytul, int iloscDostepna) {
        Ksiązka k = new Ksiązka(tytul, iloscDostepna);

        if (dostepnoscKsiazki.containsKey(k)) {//czy ksiązka już jest w bibliotece
            int ilosc;
            ilosc = dostepnoscKsiazki.get(k);
            dostepnoscKsiazki.put(k, ilosc + iloscDostepna);
        } else {
            dostepnoscKsiazki.put(k, iloscDostepna);// dodaje ilosc do ilosci w bibliotece
        }
    }

    public void listaKsiązek() {
        System.out.println("Lista wszystkich ksiązek w bibliotece:");
        System.out.println(dostepnoscKsiazki);
    }

    public void usunKsiązkeZBiblioteki(String tytul) {
        Ksiązka k = new Ksiązka(tytul, 0);//Czy mozna przekazać produkt; chyba nie?
        if (listaWypozyczen.contains(k)) {
            System.out.println("Ksiązka została wczesniej wypozyczona");
            System.out.println("Osoba przechowująca ksiązkę");//jak to sprawdzić kto ma ksiązkę?
        }
        dostepnoscKsiazki.remove(k);
    }

    //public void dodajOsoba(Osoba o) {
    //    listaOsob.add(o);
    //}
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
        FileOutputStream fileoutpustream = new FileOutputStream("Ksiazki.bin");
        ObjectOutputStream objectoutputsream = new ObjectOutputStream(fileoutpustream);
        objectoutputsream.writeObject(dostepnoscKsiazki);
        objectoutputsream.close();
    }

    public void zapisDoPlikuBinarnieWypozyczenie() throws FileNotFoundException, IOException {
        FileOutputStream fileoutpustream = new FileOutputStream("ListaWypozyczen.bin");
        ObjectOutputStream objectoutputsream = new ObjectOutputStream(fileoutpustream);
        objectoutputsream.writeObject(listaWypozyczen);
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

    public void otworzPlikBinarnyWypozyczenia() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileinputstream = new FileInputStream("ListaWypozyczen.bin");
        ObjectInputStream objectinputsream = new ObjectInputStream(fileinputstream);
        listaWypozyczen = (List<Wypozyczenie>) objectinputsream.readObject();
        objectinputsream.close();

    }

    public void otworzPlikBinarnyKsiązki() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileinputstream = new FileInputStream("Ksiazki.bin");
        ObjectInputStream objectinputsream = new ObjectInputStream(fileinputstream);
        dostepnoscKsiazki = (Map<Ksiązka, Integer>) objectinputsream.readObject();
        objectinputsream.close();

    }

    public void zwrotWyporzyczenia(String imie, String nazwisko, String tytul) {//czy ksiązka jest dostepna + korekta ilosci; imie + nazwisko
        Ksiązka k = new Ksiązka(tytul, 0);
        Osoba o = new Osoba(imie, nazwisko);
        if (listaOsob.contains(o) && dostepnoscKsiazki.containsKey(k)) {//trzeba zdefiniować equals!!

            int ilosc;
            ilosc = dostepnoscKsiazki.get(k);
            ilosc++;
            dostepnoscKsiazki.put(k, ilosc);

            Wypozyczenie w = new Wypozyczenie(o, k);

            listaWypozyczen.add(w);
            Calendar koniec = Calendar.getInstance();//dopisane
            //WypozyczenieCzas wcz = new WypozyczenieCzas(null,koniec,w);//dopisane
        } else {
            System.out.println("Brak ksiązki w bibliotece lub wypozyczjącego");
        }

    }

    public void dodajWypozyczenie(String imie, String nazwisko, String tytul) {
        Osoba o = new Osoba(imie, nazwisko);
        Ksiązka k = new Ksiązka(tytul, 0);
        
        if (listaOsob.contains(o) && dostepnoscKsiazki.containsKey(k)) {// trzeba zdefiniować equals!!

            int ilosc;
            ilosc = dostepnoscKsiazki.get(k);

            dostepnoscKsiazki.put(k, ilosc - iloscDostepna);

            Wypozyczenie w = new Wypozyczenie(o, k);

            listaWypozyczen.add(w);
            Calendar poczatek = Calendar.getInstance();//dopisane
            //WypozyczenieCzas wcz = new WypozyczenieCzas(poczatek,null,w);//dopisane test
        } else {
            System.out.println("Podano zły tytuł lub czytelnika");
        
    }

    }

    public void wyswietlWypozyczenia() {
        System.out.println("Lista wszystkich wypozyczeń:");
        System.out.println(listaWypozyczen.toString());
    }

    public void wyswietlKsiązkiWolne() {
        System.out.println("Lista dostepnych książek:");
        int iloscDostepna;
        for (Ksiązka k   : dostepnoscKsiazki.keySet()) {
            if (k.getIloscDostepna()!= 0) {
                System.out.println(k);
            } else {
                System.out.println("Brak wolnych ksiązek do wypożyczenia");
            }
        }
    }

    public void dodajCzytelnika(String imie, String nazwisko) {
        Osoba o = new Osoba(imie, nazwisko);
        if (listaOsob.contains(o)) {
            System.out.println("Osoba już jest w bibliotece");
        } else {
            listaOsob.add(o);
        }

    }

    public void usunCzytelnika(String imie, String nazwisko) {
        Osoba o = new Osoba(imie, nazwisko);
        if (listaOsob.contains(o) && !listaWypozyczen.contains(o)) {

            listaOsob.remove(o);

        } else {
            System.out.println("Takiego czytelnika nie ma w bibiotece lub nie zrócił książki");
        }
    }

    public void wyswietlOsobyZapisane() {
        System.out.println(listaOsob);
    }

    public void wyswieltKsiazkiWBibliotece() {
        System.out.println(dostepnoscKsiazki);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
