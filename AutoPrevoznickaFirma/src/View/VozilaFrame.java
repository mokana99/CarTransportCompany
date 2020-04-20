package View;

import BazaPodataka.Imenik;
import BazaPodataka.Statistika;
import BazaPodataka.VozniPark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VozilaFrame extends Stage{
    int trenutniId = 1;
    public VozilaFrame(){
        BorderPane bp = new BorderPane();
       GridPane gp = new GridPane();
        HBox hbGore = new HBox(30);
        HBox hbSredina = new HBox(30);
        
        Label title = new Label("Vozni Park");
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
        
        TableView<VozniPark> tableView = new TableView();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        TableColumn brVozilaCol = new TableColumn("br Vozila");
        brVozilaCol.setMinWidth(30);
        TableColumn markaCol = new TableColumn("Marka");
        markaCol.setMinWidth(120);
        TableColumn TipCol = new TableColumn("Tip");
        TipCol.setMinWidth(120);
        TableColumn regCol = new TableColumn("Registracija");
        regCol.setMinWidth(120);
        
        tableView.getColumns().addAll(brVozilaCol, markaCol, TipCol, regCol);
        brVozilaCol.setCellValueFactory(new PropertyValueFactory<VozniPark,String>("brVozils"));
        markaCol.setCellValueFactory(new PropertyValueFactory<VozniPark,String>("marka"));
        TipCol.setCellValueFactory(new PropertyValueFactory<VozniPark,String>("tip"));
        regCol.setCellValueFactory(new PropertyValueFactory<VozniPark,String>("regBr"));

        
        ObservableList<VozniPark> VozilaBaza = FXCollections.observableArrayList(VozniPark.dohvati());
        tableView.setItems(VozilaBaza);
        
        Label lblId = new Label("ID: ");
        Label lblBrojVozila = new Label("Broj Vozila:");
        Label lblMarka = new Label("Marka:");
	Label lblTip = new Label("Tip:");
	Label lblTablice = new Label("Reg. Broj:");
	Label lblDatumRegistracije = new Label("Datum reg: ");
	Label lblSledecaReg = new Label("Sledeca reg :");
	Label lblDatumKupovine = new Label("Datum Kupovine:");
        
        TextField txtId = new TextField();
        TextField txtBrVozila = new TextField();
	TextField txtMArka = new TextField();
	TextField txtTip = new TextField();
	TextField txtTablice = new TextField();
	TextField dateRegistracija = new TextField();
        TextField dateSledeca = new TextField();
        TextField dateKupovine = new TextField();
        
        Button btnNazad = new Button("<");
        btnNazad.setPrefSize(60,30);
        Button btnNapred = new Button(">");
        btnNapred.setPrefSize(60,30);
        
        gp.add(lblId,0,0);
        gp.add(txtId, 2, 0);
        gp.add(lblBrojVozila,0,1);
        gp.add(txtBrVozila,2,1);        
        gp.add(lblMarka,0,2);
        gp.add(txtMArka,2,2);       
        gp.add(lblTip,0,3);
        gp.add(txtTip,2,3);       
        gp.add(lblTablice,0,4);
        gp.add(txtTablice,2,4);        
        gp.add(lblDatumRegistracije,0,5);
        gp.add(dateRegistracija,2,5);       
        gp.add(lblSledecaReg,0,6);
        gp.add(dateSledeca,2,6); 
        gp.add(btnNazad, 0, 7);
        gp.add(btnNapred, 2, 7);
       
        
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setHgap(10); 
        gp.setVgap(10); 
        
        hbSredina.getChildren().addAll(tableView, gp);
        hbSredina.setPadding(new Insets(10, 10, 10, 10));
        
        hbGore.getChildren().addAll(title,  btnDodaj, btnSacuvaj, btnIzbrisi, btnIzadji);
        bp.setTop(hbGore);
        bp.setCenter(hbSredina);
        bp.setPadding(new Insets(10, 50, 50, 50));
        
        bp.setPadding(new Insets(10, 50, 50, 50)); 
        Scene sc = new Scene(bp,900,630);
	setScene(sc);
        
        btnIzadji.setOnAction(event ->{
            MainFrame mf = new MainFrame();
            mf.show();
            close();      
        });
        
         this.setOnShown((WindowEvent event1) -> {
            VozniPark i = VozniPark.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");    
            txtBrVozila.setText(i.getBrVozils() + "");
            txtMArka.setText(i.getMarka());
            txtTip.setText(i.getTip());
            txtTablice.setText(i.getRegBr());
            dateRegistracija.setText(i.getDateReg());
            dateSledeca.setText(i.getSlReg());           
            }
        });
          tableView.setOnMouseClicked(event ->{
            txtId.setText(tableView.getSelectionModel().getSelectedItem().getId() + "");
            txtBrVozila.setText(tableView.getSelectionModel().getSelectedItem().getBrVozils() + "");
            txtMArka.setText(tableView.getSelectionModel().getSelectedItem().getMarka());
            txtTip.setText(tableView.getSelectionModel().getSelectedItem().getTip());
            txtTablice.setText(tableView.getSelectionModel().getSelectedItem().getRegBr());
            dateRegistracija.setText(tableView.getSelectionModel().getSelectedItem().getDateReg()+ "");
            dateSledeca.setText(tableView.getSelectionModel().getSelectedItem().getSlReg()+ "");
            
        
        });
         
         btnNapred.setOnAction(event ->{
            trenutniId++;
            VozniPark i = VozniPark.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtBrVozila.setText(i.getBrVozils() + "");
            txtMArka.setText(i.getMarka());
            txtTip.setText(i.getTip());
            txtTablice.setText(i.getRegBr());
            dateRegistracija.setText(i.getDateReg());
            dateSledeca.setText(i.getSlReg());
            }      
        }); 
         
         btnNazad.setOnAction(event ->{
            trenutniId--;
            VozniPark i = VozniPark.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtBrVozila.setText(i.getBrVozils() + "");
            txtMArka.setText(i.getMarka());
            txtTip.setText(i.getTip());
            txtTablice.setText(i.getRegBr());
            dateRegistracija.setText(i.getDateReg());
            dateSledeca.setText(i.getSlReg());
            }      
        }); 
         
         btnDodaj.setOnAction(event ->{
             VozniPark i = new  VozniPark(
                     Integer.parseInt(txtBrVozila.getText()),
                     txtMArka.getText(),
                     txtTip.getText(),
                     txtTablice.getText(),
                     dateRegistracija.getText(),
                     dateSledeca.getText()                   
             );
         int id = i.snimi();
             System.out.println(id + "");
         });
         
         btnSacuvaj.setOnAction(event ->{
             VozniPark i = new  VozniPark(
                     Integer.parseInt(txtId.getText()),
                     Integer.parseInt(txtBrVozila.getText()),
                     txtMArka.getText(),
                     txtTip.getText(),
                     txtTablice.getText(),
                     dateRegistracija.getText(),
                     dateSledeca.getText()           
             );
             int id = i.azuriraj();
             System.out.println(id + "");
         });
         
          btnIzbrisi.setOnAction(event ->{
             VozniPark.obrisi(Integer.parseInt(txtId.getText()));
             
         });
    }
    
}
