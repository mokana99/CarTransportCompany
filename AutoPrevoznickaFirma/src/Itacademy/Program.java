package Itacademy;

import BazaPodataka.Imenik;
import BazaPodataka.Statistika;
import BazaPodataka.Vozaci;
import View.LoginFrame;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       // Imenik i1 = Imenik.dohvatiZaId(6);
        //System.out.println(i1);
        
       // Imenik i2 = new Imenik("nesto", "nestoo", 1244124, 124124, 11224, "neso@nesto.com");
       // System.out.println(i2.snimi());
        
        LoginFrame lf = new LoginFrame();
	lf.show();
        
       // Imenik i3 = Imenik.dohvatiZaId(3);
       // System.out.println(i3);
       // i3.setNaziv("ovo je promena");
       // System.out.println("izmena "+ i3.azuriraj());
       // System.out.println(i3);
        
       // System.out.println("Obrisi: " + Imenik.obrisi(6));
       //ArrayList<Vozaci> imenik = Vozaci.dohvati();
       //for(Vozaci i : imenik){
           //System.out.println(i);
        //}
    }
    
}
