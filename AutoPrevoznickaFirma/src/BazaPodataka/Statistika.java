package BazaPodataka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Statistika {
    int id;
    String naziv;
    String date;
    int cena;
    String vozac;
    String odradjeno;

    public Statistika(int id, String naziv, String date, int cena, String vozac, String odradjeno) {
        this.id = id;
        this.naziv = naziv;
        this.date = date;
        this.cena = cena;
        this.vozac = vozac;
        this.odradjeno = odradjeno;
    }

    public Statistika(String naziv, String date, int cena, String vozac, String odradjeno) {
        this.naziv = naziv;
        this.date = date;
        this.cena = cena;
        this.vozac = vozac;
        this.odradjeno = odradjeno;
    }
    
    
    
    public static Statistika dohvatiZaId(int id){
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.statistika where id = " + id + ";");
                if(rs.next()){
                    return new Statistika(rs.getInt("id"),
                            rs.getString("naziv"),
                            rs.getString("datum"),
                            rs.getInt("cena"),
                            rs.getString("vozac"),
                            rs.getString("odradjeno"));
                    
                }
            return null;    
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }

    public int snimi() {
        String sql = "INSERT INTO prevoznickafirma_baza.statistika (naziv, datum, cena, vozac, odradjeno)";
        sql += "VALUES (";
        sql += "\"" + this.naziv + "\",";
        sql += "\"" + this.date + "\",";
        sql += this.cena + ",";
        sql += "\"" + this.vozac+ "\",";
        sql += "\"" + this.odradjeno+ "\"";
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
        String sql = "update prevoznickafirma_baza.statistika SET ";
        sql += "naziv=\"" + this.naziv + "\",";
        sql += "datum=\"" + this.date + "\",";
        sql += "cena=" + this.cena + ",";
        sql += "vozac=\"" + this.vozac + "\",";
        sql += "odradjeno=\"" + this.odradjeno+ "\"";
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
                    "DELETE FROM prevoznickafirma_baza.statistika WHERE id = " + id);
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }
    
    public static ArrayList<Statistika> dohvati() {
        ArrayList<Statistika> statistika = new ArrayList();
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.statistika ");
            while(rs.next()) {
                statistika.add(
                        new Statistika(rs.getInt("id"),
                            rs.getString("naziv"),
                            rs.getString("datum"),
                            rs.getInt("cena"),
                            rs.getString("vozac"),
                            rs.getString("odradjeno")));
            }
        } catch(Exception e) {
            System.err.println(e);
        }
        return statistika;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getVozac() {
        return vozac;
    }

    public void setVozac(String vozac) {
        this.vozac = vozac;
    }

    public String getOdradjeno() {
        return odradjeno;
    }

    public void setOdradjeno(String odradjeno) {
        this.odradjeno = odradjeno;
    }

    @Override
    public String toString() {
        return "Statistika{" + "id=" + id + ", naziv=" + naziv + ", date=" + date + ", cena=" + cena + ", vozac=" + vozac + ", odradjeno=" + odradjeno + '}';
    }

    public String getAdresa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
