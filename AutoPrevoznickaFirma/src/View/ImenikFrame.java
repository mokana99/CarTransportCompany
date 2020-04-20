package View;

import BazaPodataka.Imenik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ImenikFrame extends Stage{
    int trenutniId = 1;   
    public ImenikFrame(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        HBox hbGore = new HBox(30);
        HBox hbSredina = new HBox(30);
        
        Label title = new Label("Imenik Firme");
        title.setFont(new Font("Tw Cen MT",25));
        title.setTextFill(Color.web("#edc939"));       
        
        Button btnDodaj = new Button("Dodaj");
        btnDodaj.setPrefSize(130,70);
        btnDodaj.setFont(new Font(15));
        Button btnSacuvaj = new Button("Sacuvaj");
        btnSacuvaj.setPrefSize(130,70);
        btnSacuvaj.setFont(new Font(15));
        Button btnIzbrisi = new Button("Izbrisi");
        btnIzbrisi.setPrefSize(130,70);  
        btnIzbrisi.setFont(new Font(15));
        Button btnIzadji = new Button("Izadji");
        btnIzadji.setPrefSize(130,70);
        btnIzadji.setFont(new Font(15));
        
        Image dodajImage = new Image(getClass().getResourceAsStream("/Images/add.png"));
        ImageView dodajView = new ImageView(dodajImage);
        btnDodaj.setGraphic(dodajView);
        
        Image SacuvajImage = new Image(getClass().getResourceAsStream("/Images/download.png"));
        ImageView sacuvajView = new ImageView(SacuvajImage);
        btnSacuvaj.setGraphic(sacuvajView);
        
        Image izbrisiImage = new Image(getClass().getResourceAsStream("/Images/delete-button.png"));
        ImageView izbrisiView = new ImageView(izbrisiImage);
        btnIzbrisi.setGraphic(izbrisiView);
        
        Image izadjiImage = new Image(getClass().getResourceAsStream("/Images/logout.png"));
        ImageView izaznjiView = new ImageView(izadjiImage);
        btnIzadji.setGraphic(izaznjiView);
        
        TableView<Imenik> tableView = new TableView<Imenik>();
            
        TableColumn<Imenik,String> firstNameCol = new TableColumn<Imenik,String>("Naziv");
        firstNameCol.setMinWidth(150);
        TableColumn<Imenik,String> lastNameCol = new TableColumn<Imenik,String>("Adresa");
        lastNameCol.setMinWidth(150);
        TableColumn<Imenik,String> emailCol = new TableColumn<Imenik,String>("Email");
        emailCol.setMinWidth(150);
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Imenik,String>("naziv"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Imenik,String>("adresa"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Imenik,String>("mail"));
        
        tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        ObservableList<Imenik> ImenikBaza = FXCollections.observableArrayList(Imenik.dohvati());
        tableView.setItems(ImenikBaza);
       // tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        Label lblId = new Label("ID: ");
        Label lblNaziv = new Label("Naziv: ");
        Label lblAdresa = new Label("Adresa:");
	Label lblTelefon1 = new Label("telefon1:");
	Label lblTelefon2 = new Label("Telefon2:");
	Label lblMail = new Label("Mail:");
	Label lblRacun = new Label("Racun:");
        
        TextField txtId = new TextField();
        TextField txtNaziv = new TextField();   
	TextField txtAdresa = new TextField();
        txtAdresa.setPrefWidth(200);
        txtAdresa.setMaxWidth(200);
	TextField txtTelefon1 = new TextField();
	TextField txtTelefon2 = new TextField();
	TextField txtMail = new TextField();
	TextField txtRacun = new TextField();
        
        Button btnNazad = new Button("<");
        btnNazad.setPrefSize(60,30);
        Button btnNapred = new Button(">");
        btnNapred.setPrefSize(60,30);
        
        gp.add(lblId, 0,0);
        gp.add(txtId, 2,0);
        gp.add(lblNaziv,0,1);
        gp.add(txtNaziv,2,1);        
        gp.add(lblAdresa,0,2);
        gp.add(txtAdresa,2,2);       
        gp.add(lblTelefon1,0,3);
        gp.add(txtTelefon1,2,3);       
        gp.add(lblTelefon2,0,4);
        gp.add(txtTelefon2,2,4);        
        gp.add(lblMail,0,5);
        gp.add(txtMail,2,5);       
        gp.add(lblRacun,0,6);
        gp.add(txtRacun,2,6);      
        gp.add(btnNazad,0,7);
        gp.add(btnNapred,2,7);
        
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(10); 
        gp.setVgap(10); 
        
        hbSredina.getChildren().addAll(tableView, gp);
        hbSredina.setPadding(new Insets(10, 10, 10, 10));
        
        hbGore.getChildren().addAll(title,  btnDodaj, btnSacuvaj, btnIzbrisi, btnIzadji);
        bp.setTop(hbGore);
        bp.setCenter(hbSredina);
        bp.setPadding(new Insets(10, 50, 50, 50));
        Scene sc = new Scene(bp,900,630, Color.AQUA);
        
	setScene(sc);
        
        
        
        btnIzadji.setOnAction(event ->{
            MainFrame mf = new MainFrame();
            mf.show();
            close();
        
        });
        this.setOnShown((WindowEvent event1) -> {
            Imenik i = Imenik.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");    
            txtNaziv.setText(i.getNaziv());
            txtAdresa.setText(i.getAdresa());
            txtTelefon1.setText(i.getTelefon1() + "");
            txtTelefon2.setText(i.getTelefon2() + "");
            txtMail.setText(i.getMail());
            txtRacun.setText(i.getRacun() + "");
            }
      
    });
        tableView.setOnMouseClicked(event ->{
            txtId.setText(tableView.getSelectionModel().getSelectedItem().getId() + "");
            txtNaziv.setText(tableView.getSelectionModel().getSelectedItem().getNaziv() + "");
            txtAdresa.setText(tableView.getSelectionModel().getSelectedItem().getAdresa() + "");
            txtTelefon1.setText(tableView.getSelectionModel().getSelectedItem().getTelefon1()+ "");
            txtTelefon2.setText(tableView.getSelectionModel().getSelectedItem().getTelefon2() + "");
            txtMail.setText(tableView.getSelectionModel().getSelectedItem().getMail()+ "");
            txtRacun.setText(tableView.getSelectionModel().getSelectedItem().getRacun()+ "");
        
        });
       
        
         btnNapred.setOnAction(event ->{
            trenutniId++;
            Imenik i = Imenik.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtNaziv.setText(i.getNaziv());
            txtAdresa.setText(i.getAdresa());
            txtTelefon1.setText(i.getTelefon1() + "");
            txtTelefon2.setText(i.getTelefon2() + "");
            txtMail.setText(i.getMail());
            txtRacun.setText(i.getRacun() + "");
            }      
        
        }); 
         btnNazad.setOnAction(event ->{
             if(trenutniId > 1 ){
            trenutniId--;
            Imenik i = Imenik.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");    
            txtNaziv.setText(i.getNaziv());
            txtAdresa.setText(i.getAdresa());
            txtTelefon1.setText(i.getTelefon1() + "");
            txtTelefon2.setText(i.getTelefon2() + "");
            txtMail.setText(i.getMail());
            txtRacun.setText(i.getRacun() + "");
            }  
            
             }
        }); 
         btnDodaj.setOnAction(event ->{
             Imenik i = new Imenik(
                     txtNaziv.getText(),
                     txtAdresa.getText(),
                     Integer.parseInt(txtTelefon1.getText()),
                     Integer.parseInt(txtTelefon2.getText()),
                     Integer.parseInt(txtRacun.getText()),
                     txtMail.getText()
             );
         int id = i.snimi();
             System.out.println(id + "");
         });
         
         btnSacuvaj.setOnAction(event ->{
             Imenik i = new Imenik(
                     Integer.parseInt(txtId.getText()),
                     txtNaziv.getText(),
                     txtAdresa.getText(),
                     Integer.parseInt(txtTelefon1.getText()),
                     Integer.parseInt(txtTelefon2.getText()),
                     Integer.parseInt(txtRacun.getText()),
                     txtMail.getText()
             );
             int id = i.azuriraj();
             System.out.println(id + "");
         });
         
         btnIzbrisi.setOnAction(event ->{
             Imenik.obrisi(Integer.parseInt(txtId.getText()));
             
         });
         
    }
    
}
