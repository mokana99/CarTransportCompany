package BazaPodataka;

import java.sql.*;

public class BazaPodataka {
    private Connection connection; 
    private static BazaPodataka instanca;
    
    public static Connection get() {
        if(instanca == null) {
            instanca = new BazaPodataka();
        }
        return instanca.connection;
    }
    
    
    private BazaPodataka(){

            try{
                //String driver = "com.mysql.jdbc.Driver";
                String connString = "jdbc:mysql://localhost:3306/prevoznickafirma_baza";
                String user = "root";
                String password = "root";
               //Class.forName(driver);
                this.connection = DriverManager.getConnection(connString, user, password);
                System.out.println("Uspesno ste se povezali");
            }catch(Exception ex){
                System.err.println(ex);
                System.exit(1);
            }
    }
}
