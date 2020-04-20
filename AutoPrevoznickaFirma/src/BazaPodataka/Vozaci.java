package BazaPodataka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Vozaci {
    int id;
    String ime, prezime, adresa, mesto;
    int mobilni, pasos, LK, plata;
    String zaposlenOd, datumRodjenja;

    public Vozaci(int id, String ime, String prezime, String adresa, String mesto, int mobilni, int pasos, int LK, int plata, String zaposlenOd, String datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.mesto = mesto;
        this.mobilni = mobilni;
        this.pasos = pasos;
        this.LK = LK;
        this.plata = plata;
        this.zaposlenOd = zaposlenOd;
        this.datumRodjenja = datumRodjenja;
    }

    public Vozaci(String ime, String prezime, String adresa, String mesto, int mobilni, int pasos, int LK, int plata, String zaposlenOd, String datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.mesto = mesto;
        this.mobilni = mobilni;
        this.pasos = pasos;
        this.LK = LK;
        this.plata = plata;
        this.zaposlenOd = zaposlenOd;
        this.datumRodjenja = datumRodjenja;
    }
    public static Vozaci dohvatiZaId(int id){
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.vozaci where id = " + id + ";");
                if(rs.next()){
                    return new Vozaci(
                            rs.getInt("id"),
                            rs.getString("ime"),
                            rs.getString("prezime"),
                            rs.getString("adresa"),
                            rs.getString("mesto"),
                            rs.getInt("mobilni"),
                            rs.getInt("LK"),
                            rs.getInt("pasos"),
                            rs.getInt("plata"),
                            rs.getString("zaposlenOd"),
                            rs.getString("datumRodjenja")
                    );                  
                }
            return null;    
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
    public int snimi() {
        String sql = "INSERT INTO prevoznickafirma_baza.vozaci (ime, prezime, adresa, mesto, mobilni, LK, pasos, plata, zaposlenOd, datumRodjenja)";
        sql += "VALUES (";
        sql += "\"" + this.ime + "\",";
        sql += "\"" + this.prezime + "\",";
        sql += "\"" + this.adresa + "\",";
        sql += "\"" + this.mesto+ "\",";
        sql += this.mobilni + ",";
        sql += this.LK + ",";
        sql += this.pasos + ",";
        sql += this.plata + ",";
        sql += "\"" + this.zaposlenOd+ "\",";
        sql += "\"" + this.datumRodjenja+ "\"";
        sql += ")";
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);//r_g_k => vraca kolone 
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                this.id = rs.getInt(1);//Vrati kolonu 1 or id
                return this.id;
            }
            return 0;
            
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }
    
    public int azuriraj() {
        if(this. id == 0) { return 0; }
        String sql = "update prevoznickafirma_baza.vozaci SET ";
        sql += "ime=\"" + this.ime + "\",";
        sql += "prezime=\"" + this.prezime + "\",";
        sql += "adresa=\"" + this.adresa + "\",";
        sql += "mesto=\"" + this.mesto + "\",";
        sql += "mobilni=" + this.mobilni + ",";
        sql += "LK=" + this.LK + ",";
        sql += "pasos=" + this.pasos + ",";
        sql += "plata=" + this.plata + ",";
        sql += "zaposlenOd=\"" + this.zaposlenOd+ "\"";
        sql += "datumRodjenja=\"" + this.datumRodjenja + "\",";
        sql += " WHERE id = " + this.id;
        
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            return stmt.executeUpdate(sql);
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }

     public static int obrisi(int id) {
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            return stmt.executeUpdate(
                    "DELETE FROM prevoznickafirma_baza.vozaci WHERE id = " + id);
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }
     public static ArrayList<Vozaci> dohvati() {
        ArrayList<Vozaci> vozaci = new ArrayList();
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.vozaci ");
            while(rs.next()) {
                vozaci.add(
                        new Vozaci(
                            rs.getInt("id"),
                            rs.getString("ime"),
                            rs.getString("prezime"),
                            rs.getString("adresa"),
                            rs.getString("mesto"),
                            rs.getInt("mobilni"),
                            rs.getInt("LK"),
                            rs.getInt("pasos"),
                            rs.getInt("plata"),
                            rs.getString("zaposlenOd"),
                            rs.getString("datumRodjenja")));
            }
        } catch(Exception e) {
            System.err.println(e);
        }
        return vozaci;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getMobilni() {
        return mobilni;
    }

    public void setMobilni(int mobilni) {
        this.mobilni = mobilni;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public int getLK() {
        return LK;
    }

    public void setLK(int LK) {
        this.LK = LK;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public String getZaposlenOd() {
        return zaposlenOd;
    }

    public void setZaposlenOd(String zaposlenOd) {
        this.zaposlenOd = zaposlenOd;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return "Vozaci{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", mesto=" + mesto + ", mobilni=" + mobilni + ", pasos=" + pasos + ", LK=" + LK + ", plata=" + plata + ", zaposlenOd=" + zaposlenOd + ", datumRodjenja=" + datumRodjenja + '}';
    }
    
    
}
