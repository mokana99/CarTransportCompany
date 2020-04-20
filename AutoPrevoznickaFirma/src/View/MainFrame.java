package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainFrame extends Stage{
    public MainFrame(){
        
        VBox vbLevo = new VBox(30);
        VBox vbSredina = new VBox();
	VBox vbDesno = new VBox(30);
		
	BorderPane bp = new BorderPane();
		
	Label lblNaziv = new Label("Jevtovic Autoprevoznicka Firma ");
	lblNaziv.setFont(new Font("Tw Cen MT",70));
	lblNaziv.setTextFill(Color.web("#edc939"));
        lblNaziv.setTranslateY(50);
		
	ImageView Image = new ImageView();
        Image image1 = new Image(getClass().getResourceAsStream("/Images/slika.png"));
        Image.setFitHeight(350);
        Image.setFitWidth(350);
        Image.setImage(image1);
		
	Button btnImenik = new Button("Imenik Firme");
	btnImenik.setPrefSize(270,100);  
        btnImenik.setStyle("-fx-background-color: #ebd16c; ");
	Button btnTure = new Button("Statistika Tura");
	btnTure.setPrefSize(270, 100);
        btnTure.setStyle("-fx-background-color: #ebd16c; ");
	Button btnVozila = new Button("Vozni Park");
	btnVozila.setPrefSize(270, 100);
        btnVozila.setStyle("-fx-background-color: #ebd16c; ");
	Button btnVozaci = new Button("Evidencija Vozaca");
	btnVozaci.setPrefSize(270, 100);
        btnVozaci.setStyle("-fx-background-color: #ebd16c; ");
	Button btnIzlaz = new Button("Izlaz");
	btnIzlaz.setPrefSize(100, 40);
        btnIzlaz.setStyle("-fx-background-color: #ebd16c; ");
		
        Image imenikImage = new Image(getClass().getResourceAsStream("/Images/book.png"));
        ImageView imenikView = new ImageView(imenikImage);
        imenikView.setFitHeight(50);
        imenikView.setFitWidth(50);
        btnImenik.setGraphic(imenikView);
        
        Image statistikaImage = new Image(getClass().getResourceAsStream("/Images/statistic.png"));
        ImageView statistikaView = new ImageView(statistikaImage);
        statistikaView.setFitHeight(50);
        statistikaView.setFitWidth(50);
        btnTure.setGraphic(statistikaView);
        
        Image vozilaImage = new Image(getClass().getResourceAsStream("/Images/truck.png"));
        ImageView vozilaView = new ImageView(vozilaImage);
        vozilaView.setFitHeight(50);
        vozilaView.setFitWidth(50);
        btnVozila.setGraphic(vozilaView);
        
        Image vozaciImage = new Image(getClass().getResourceAsStream("/Images/drivers.png"));
        ImageView vozaciView = new ImageView(vozaciImage);
        vozaciView.setFitHeight(50);
        vozaciView.setFitWidth(50);
        btnVozaci.setGraphic(vozaciView);
        
        Image exitImage = new Image(getClass().getResourceAsStream("/Images/exit.png"));
        ImageView exitView = new ImageView(exitImage);
        exitView.setFitHeight(30);
        exitView.setFitWidth(30);
        btnIzlaz.setGraphic(exitView);
	
		
	vbLevo.getChildren().addAll(btnImenik, btnVozaci);
        vbSredina.getChildren().add(Image);
	vbDesno.getChildren().addAll(btnTure, btnVozila);
				
		
		
	vbLevo.setAlignment(Pos.CENTER_LEFT);
	vbDesno.setAlignment(Pos.CENTER_RIGHT);
	btnIzlaz.setAlignment(Pos.CENTER);
	bp.setAlignment(btnIzlaz, Pos.TOP_CENTER);
        bp.setAlignment(lblNaziv,Pos.CENTER);
		
		
	bp.setTop(lblNaziv);
	bp.setCenter(Image);
	bp.setLeft(vbLevo);
	bp.setRight(vbDesno);
	bp.setBottom(btnIzlaz);
		
	bp.setPadding(new Insets(10, 50, 50, 50));
             
        Scene sc = new Scene(bp,1200,680);
	setScene(sc);

        btnImenik.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ImenikFrame IF = new ImenikFrame();
                IF.show();
                close();
            }
        });
        btnTure.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                StatistikaFrame sf = new StatistikaFrame();
                sf.show();
                close();
            }
        });  
        btnVozaci.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               VozaciFrame vf = new VozaciFrame();
                vf.show();
                close();
            }
        });
        btnVozila.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                VozilaFrame vozilaF = new VozilaFrame();
                vozilaF.show();
                close();
            }
        });
         btnIzlaz.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginFrame lg = new LoginFrame();
                 lg.show();
                close();
            }
        });
    }
    
}
