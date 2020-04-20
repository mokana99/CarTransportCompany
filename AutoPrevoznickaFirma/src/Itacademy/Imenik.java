package Itacademy;

public class Imenik {
    private int id;
    private String naziv;
    private String adresa;
    private int telefon1;
    private int telefon2;
    private String mail;
    private int racun;
    private String www;

    public Imenik(int id, String naziv, String adresa, int telefon1, int telefon2, String mail, int racun, String www) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.mail = mail;
        this.racun = racun;
        this.www = www;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getTelefon1() {
        return telefon1;
    }

    public int getTelefon2() {
        return telefon2;
    }

    public String getMail() {
        return mail;
    }

    public int getRacun() {
        return racun;
    }

    public String getWww() {
        return www;
    }

     
    
}
