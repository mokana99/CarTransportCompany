package BazaPodataka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Imenik {
    private int id;
    private String naziv;
    private String adresa;
    private int telefon1;
    private int telefon2;
    private int racun;
    private String mail;

    public Imenik(int id, String naziv, String adresa, int telefon1, int telefon2, int racun, String mail) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.racun = racun;
        this.mail = mail;
    }

    public Imenik(String naziv, String adresa, int telefon1, int telefon2, int racun, String mail) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.racun = racun;
        this.mail = mail;
    }
    
    public static Imenik dohvatiZaId(int id){
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.imenik where id = " + id + ";");
                if(rs.next()){
                    return new Imenik(
                            rs.getInt("id"),
                            rs.getString("naziv"),
                            rs.getString("adresa"),
                            rs.getInt("telefon1"),
                            rs.getInt("telefon2"),
                            rs.getInt("racun"),
                            rs.getString("email"));
                }
            return null;    
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
   
     public int snimi() {
        String sql = "INSERT INTO prevoznickafirma_baza.imenik (naziv, adresa, telefon1, telefon2, racun, email)";
        sql += "VALUES (";
        sql += "\"" + this.naziv + "\",";
        sql += "\"" + this.adresa + "\",";
        sql += this.telefon1 + ",";
        sql += this.telefon2 + ",";
        sql += this.racun + ",";
        sql += "\"" + this.mail+ "\"";
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
        String sql = "update prevoznickafirma_baza.imenik SET ";
        sql += "naziv=\"" + this.naziv + "\",";
        sql += "adresa=\"" + this.adresa + "\",";
        sql += "telefon1=" + this.telefon1 + ",";
        sql += "telefon2=" + this.telefon2 + ",";
        sql += "racun=" + this.racun + ",";
        sql += "email=\"" + this.mail+ "\"";
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
                    "DELETE FROM prevoznickafirma_baza.imenik WHERE id = " + id);
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }
     
     public static ArrayList<Imenik> dohvati() {
        ArrayList<Imenik> imenik = new ArrayList();
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.imenik ");
            while(rs.next()) {
                imenik.add(new Imenik(
                            rs.getInt("id"),
                            rs.getString("naziv"),
                            rs.getString("adresa"),
                            rs.getInt("telefon1"),
                            rs.getInt("telefon2"),
                            rs.getInt("racun"),
                            rs.getString("email")
                ));
            }
        } catch(Exception e) {
            System.err.println(e);
        }
        return imenik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getTelefon1() {
        return telefon1;
    }

    public void setTelefon1(int telefon1) {
        this.telefon1 = telefon1;
    }

    public int getTelefon2() {
        return telefon2;
    }

    public void setTelefon2(int telefon2) {
        this.telefon2 = telefon2;
    }

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Imenik{" + "id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", telefon1=" + telefon1 + ", telefon2=" + telefon2 + ", racun=" + racun + ", mail=" + mail + '}';
    }
    
}
