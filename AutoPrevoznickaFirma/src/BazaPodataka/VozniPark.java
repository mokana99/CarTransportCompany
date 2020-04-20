package BazaPodataka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VozniPark {
    int id;
    int brVozils;
    String marka;
    String tip;
    String regBr;
    String dateReg;
    String slReg;

    public VozniPark(int id, int brVozils, String marka, String tip, String regBr, String dateReg, String slReg) {
        this.id = id;
        this.brVozils = brVozils;
        this.marka = marka;
        this.tip = tip;
        this.regBr = regBr;
        this.dateReg = dateReg;
        this.slReg = slReg;
    }

    public VozniPark(int brVozils, String marka, String tip, String regBr, String dateReg, String slReg) {
        this.brVozils = brVozils;
        this.marka = marka;
        this.tip = tip;
        this.regBr = regBr;
        this.dateReg = dateReg;
        this.slReg = slReg;
    }
    public static VozniPark dohvatiZaId(int id){
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.vozila where id = " + id + ";");
                if(rs.next()){
                    return new VozniPark(
                            rs.getInt("id"),
                            rs.getShort("brVozila"),
                            rs.getString("marka"),
                            rs.getString("tip"),
                            rs.getString("regBr"),
                            rs.getString("registracija"),
                            rs.getString("sledeca")
                    );                  
                }
            return null;    
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public int snimi() {
        String sql = "INSERT INTO prevoznickafirma_baza.vozila (brVozila, marka, tip, regBr, registracija, sledeca)";
        sql += "VALUES (";
        sql += this.brVozils + ",";
        sql += "\"" + this.marka + "\",";
        sql += "\"" + this.tip + "\",";
        sql += "\"" + this.regBr+ "\",";
        sql += "\"" + this.dateReg+ "\",";
        sql += "\"" + this.slReg+ "\"";
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
        String sql = "update prevoznickafirma_baza.vozila SET ";
        sql += "brVozila=" + this.brVozils + ",";
        sql += "marka=\"" + this.marka + "\",";
        sql += "tip=\"" + this.tip + "\",";
        sql += "regBr=\"" + this.regBr + "\",";
        sql += "registracija=\"" + this.dateReg+ "\"";
        sql += "sledeca=\"" + this.slReg + "\",";
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
                    "DELETE FROM prevoznickafirma_baza.vozila WHERE id = " + id);
        } catch(Exception e) {
            System.err.println(e);
            return 0;
        }
    }
     
     public static ArrayList<VozniPark> dohvati() {
        ArrayList<VozniPark> vozniPark = new ArrayList();
        try {
            Statement stmt = BazaPodataka.get().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prevoznickafirma_baza.vozila ");
            while(rs.next()) {
                vozniPark.add(
                        new VozniPark(
                            rs.getInt("id"),
                            rs.getInt("brVozila"),
                            rs.getString("marka"),
                            rs.getString("tip"),
                            rs.getString("regBr"),
                            rs.getString("registracija"),
                            rs.getString("sledeca")));
            }
        } catch(Exception e) {
            System.err.println(e);
        }
        return vozniPark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrVozils() {
        return brVozils;
    }

    public void setBrVozils(int brVozils) {
        this.brVozils = brVozils;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRegBr() {
        return regBr;
    }

    public void setRegBr(String regBr) {
        this.regBr = regBr;
    }

    public String getDateReg() {
        return dateReg;
    }

    public void setDateReg(String dateReg) {
        this.dateReg = dateReg;
    }

    public String getSlReg() {
        return slReg;
    }

    public void setSlReg(String slReg) {
        this.slReg = slReg;
    }

    @Override
    public String toString() {
        return "VozniPark{" + "id=" + id + ", brVozils=" + brVozils + ", marka=" + marka + ", tip=" + tip + ", regBr=" + regBr + ", dateReg=" + dateReg + ", slReg=" + slReg + '}';
    }
    
    
}
