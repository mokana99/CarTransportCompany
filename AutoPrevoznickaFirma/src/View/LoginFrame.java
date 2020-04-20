package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginFrame extends Stage {
    public LoginFrame(){
        Label lblIme = new Label("Korisničko ime");      
	Label lblSifra = new Label("Šifra");
	Label lblGreska = new Label("Pogrešno korisničko ime ili lozinka!");
	lblGreska.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
			
	TextField tfIme = new TextField();
	tfIme.setMaxWidth(200);
        tfIme.setStyle("-fx-background-radius: 5em;");
		
	PasswordField pfSifra = new PasswordField();
	pfSifra.setMaxWidth(200);
        pfSifra.setStyle("-fx-background-radius: 5em;");
		
	Button btnLogin = new Button("Uloguj se");
        btnLogin.setStyle("-fx-background-radius: 5em;");
		
	VBox vb = new VBox(5);
		
	vb.getChildren().addAll(lblIme,tfIme,lblSifra,pfSifra,btnLogin);
	vb.setAlignment(Pos.CENTER);
		
		
		
	Scene sc = new Scene(vb,400,400);
	setScene(sc);
        
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MainFrame mf = new MainFrame();
                mf.show();
                close();
            }
        });
    }
    
}
