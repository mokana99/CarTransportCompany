package View;

import BazaPodataka.Statistika;
import BazaPodataka.Vozaci;
import BazaPodataka.VozniPark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
import javafx.stage.WindowEvent;

public class VozaciFrame extends Stage{
    int trenutniId = 1;
    public VozaciFrame(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        HBox hbGore = new HBox(30);
        HBox hbSredina = new HBox(30);
        
        Label title = new Label("Vozaci");
        title.setFont(new Font("Tw Cen MT",35));
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
        
        TableView<Vozaci> tableView = new TableView();
        
        TableColumn firstNameCol = new TableColumn("Ime");
        TableColumn lastNameCol = new TableColumn("Prezime");
        TableColumn mobilniCol = new TableColumn("Mobilni");
        
        tableView.getColumns().addAll(firstNameCol, lastNameCol, mobilniCol);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Vozaci,String>("ime"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Vozaci,String>("prezime"));
        mobilniCol.setCellValueFactory(new PropertyValueFactory<Vozaci,String>("mobilni"));
        
        
         ObservableList<Vozaci> VozaciBaza = FXCollections.observableArrayList(Vozaci.dohvati());
        tableView.setItems(VozaciBaza);
        
        Label lblId = new Label("ID: ");
        Label lblIme = new Label("Ime");
        Label lblPrezime = new Label("Prezime:");
        Label lblAdresa = new Label("Adresa:");
	Label lblMesto = new Label("Mesto:");
	Label lblMobilni = new Label("Mobilni:");
	Label lblBrPasosa = new Label("br. Pasosa:");
	Label lblBrLK = new Label("br. LK:");
	Label lblZaposlen = new Label("Zaposlen od:");
        Label lblRodjen = new Label("Datum Rodjenja:");
        Label lblPlata = new Label("Plata:");
        
        TextField txtId = new TextField();
        TextField txtIme = new TextField();
	TextField txtPrezime = new TextField();
	TextField txtAdresa = new TextField();
	TextField txtMesto = new TextField();
	TextField txtMobilni = new TextField();
	TextField txtBrPasosa = new TextField();
	TextField txtBrLK = new TextField();
        TextField dateZaposlen = new TextField();
        TextField dateRodjen = new TextField();
        TextField txtPlata = new TextField();
        
        Button btnNazad = new Button("<");
        btnNazad.setPrefSize(60,30);
        Button btnNapred = new Button(">");
        btnNapred.setPrefSize(60,30);
        
        gp.add(lblId,0,0);
        gp.add(txtId,2,0);  
        gp.add(lblIme,0,1);
        gp.add(txtIme,2,1);        
        gp.add(lblPrezime,0,2);
        gp.add(txtPrezime,2,2);       
        gp.add(lblAdresa,0,3);
        gp.add(txtAdresa,2,3);       
        gp.add(lblMesto,0,4);
        gp.add(txtMesto,2,4);        
        gp.add(lblMobilni,0,5);
        gp.add(txtMobilni,2,5);       
        gp.add(lblBrPasosa,0,6);
        gp.add(txtBrPasosa,2,6);      
        gp.add(lblBrLK,0,7);
        gp.add(txtBrLK,2,7);
        gp.add(lblZaposlen,0,8);
        gp.add(dateZaposlen,2,8);
        gp.add(lblRodjen,0,9);
        gp.add(dateRodjen,2,9);
        gp.add(lblPlata,0,10);
        gp.add(txtPlata,2,10);
        gp.add(btnNazad,0,11);
        gp.add(btnNapred,2,11);
        
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(10); 
        gp.setVgap(10); 
        
        hbSredina.getChildren().addAll(tableView, gp);
        hbSredina.setPadding(new Insets(10, 10, 10, 10));
        
        hbGore.getChildren().addAll(title,  btnDodaj, btnSacuvaj, btnIzbrisi, btnIzadji);
        bp.setTop(hbGore);
        bp.setCenter(hbSredina);
        bp.setPadding(new Insets(10, 50, 50, 50));

        Scene sc = new Scene(bp,900,630);
        setScene(sc);
        
         btnIzadji.setOnAction(event ->{
            MainFrame mf = new MainFrame();
            mf.show();
            close();
        
        });
          this.setOnShown((WindowEvent event1) -> {
            Vozaci i = Vozaci.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtIme.setText(i.getIme());
            txtPrezime.setText(i.getPrezime());
            txtAdresa.setText(i.getAdresa());
            txtMesto.setText(i.getMesto());
            txtMobilni.setText(i.getMobilni() + "");
            txtBrLK.setText(i.getLK()+ "");
            txtBrPasosa.setText(i.getPasos() + "");
            txtPlata.setText(i.getPlata()+ "");
            dateZaposlen.setText(i.getZaposlenOd());
            dateRodjen.setText(i.getDatumRodjenja());      
            }
    });
          tableView.setOnMouseClicked(event ->{
            txtId.setText(tableView.getSelectionModel().getSelectedItem().getId() + "");
            txtIme.setText(tableView.getSelectionModel().getSelectedItem().getIme());
            txtPrezime.setText(tableView.getSelectionModel().getSelectedItem().getPrezime());
            txtAdresa.setText(tableView.getSelectionModel().getSelectedItem().getAdresa());
            txtMesto.setText(tableView.getSelectionModel().getSelectedItem().getMesto());
            txtMobilni.setText(tableView.getSelectionModel().getSelectedItem().getMobilni()+ "");
            txtBrLK.setText(tableView.getSelectionModel().getSelectedItem().getLK()+ "");
            txtBrPasosa.setText(tableView.getSelectionModel().getSelectedItem().getPasos()+ "");
            txtPlata.setText(tableView.getSelectionModel().getSelectedItem().getPlata()+ "");
            dateZaposlen.setText(tableView.getSelectionModel().getSelectedItem().getZaposlenOd());
            dateRodjen.setText(tableView.getSelectionModel().getSelectedItem().getDatumRodjenja());
        
        });
           
         btnNazad.setOnAction(event ->{
            trenutniId--;
            Vozaci i = Vozaci.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtIme.setText(i.getIme());
            txtPrezime.setText(i.getPrezime());
            txtAdresa.setText(i.getAdresa());
            txtMesto.setText(i.getMesto());
            txtMobilni.setText(i.getMobilni() + "");
            txtBrLK.setText(i.getLK()+ "");
            txtBrPasosa.setText(i.getPasos() + "");
            txtPlata.setText(i.getPlata()+ "");
            dateZaposlen.setText(i.getZaposlenOd());
            dateRodjen.setText(i.getDatumRodjenja()); 
            }      
        }); 
          
          btnNapred.setOnAction(event ->{
            trenutniId++;
            Vozaci i = Vozaci.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtIme.setText(i.getIme());
            txtPrezime.setText(i.getPrezime());
            txtAdresa.setText(i.getAdresa());
            txtMesto.setText(i.getMesto());
            txtMobilni.setText(i.getMobilni() + "");
            txtBrLK.setText(i.getLK()+ "");
            txtBrPasosa.setText(i.getPasos() + "");
            txtPlata.setText(i.getPlata()+ "");
            dateZaposlen.setText(i.getZaposlenOd());
            dateRodjen.setText(i.getDatumRodjenja()); 
            }      
        }); 
          
          btnDodaj.setOnAction((ActionEvent event) ->{
             Vozaci i = new  Vozaci(
                     txtIme.getText(),
                     txtPrezime.getText(),
                     txtAdresa.getText(),
                     txtMesto.getText(),
                     Integer.parseInt(txtMobilni.getText()),
                     Integer.parseInt(txtBrLK.getText()),
                     Integer.parseInt(txtBrPasosa.getText()),
                     Integer.parseInt(txtPlata.getText()),
                     dateZaposlen.getText(),
                     dateRodjen.getText()         
             );
         int id = i.snimi();
             System.out.println(id + "");
         }); 
          
          btnSacuvaj.setOnAction(event ->{
             Vozaci i = new  Vozaci(
                     txtIme.getText(),
                     txtPrezime.getText(),
                     txtAdresa.getText(),
                     txtMesto.getText(),
                     Integer.parseInt(txtMobilni.getText()),
                     Integer.parseInt(txtBrLK.getText()),
                     Integer.parseInt(txtBrPasosa.getText()),
                     Integer.parseInt(txtPlata.getText()),
                     dateZaposlen.getText(),
                     dateRodjen.getText()                
             );
             int id = i.azuriraj();
             System.out.println(id + "");
         });
          
          btnIzbrisi.setOnAction(event ->{
             Vozaci.obrisi(Integer.parseInt(txtId.getText()));
             
         });
    }
}
