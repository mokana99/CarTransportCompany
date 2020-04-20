package View;

import BazaPodataka.Statistika;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StatistikaFrame extends Stage{
    int trenutniId = 1;
    public StatistikaFrame(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        HBox hbGore = new HBox(30);
        HBox hbSredina = new HBox(30);
        
        Label title = new Label("Ture");
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
        
        TableView<Statistika> tableView = new TableView<Statistika>();
        tableView.setMaxWidth(700);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        TableColumn<Statistika,String> NazivCol = new TableColumn("Naziv");
        NazivCol.setMinWidth(130);
        NazivCol.setResizable(false);
        TableColumn<Statistika,String> DatumCol = new TableColumn("Datum");
        DatumCol.setMinWidth(100);
        TableColumn<Statistika,String> CenaCol = new TableColumn("Cena");
        CenaCol.setMinWidth(100);
        TableColumn<Statistika,String> VozacCol = new TableColumn("Vozac");
        VozacCol.setMinWidth(130);
        TableColumn<Statistika,String> OdradjenoCol = new TableColumn("Odr.");
        OdradjenoCol.setMinWidth(40);
        
        
        
        tableView.getColumns().addAll(NazivCol, DatumCol, CenaCol, VozacCol, OdradjenoCol);
        NazivCol.setCellValueFactory(new PropertyValueFactory<Statistika,String>("naziv"));
        DatumCol.setCellValueFactory(new PropertyValueFactory<Statistika,String>("date"));
        CenaCol.setCellValueFactory(new PropertyValueFactory<Statistika,String>("cena"));
        VozacCol.setCellValueFactory(new PropertyValueFactory<Statistika,String>("vozac"));
        OdradjenoCol.setCellValueFactory(new PropertyValueFactory<Statistika,String>("odradjeno"));
        
        ObservableList<Statistika> StatistikaBaza = FXCollections.observableArrayList(Statistika.dohvati());
        tableView.setItems(StatistikaBaza);
        
        
        Label lblId = new Label("ID: ");
        Label lblNaziv = new Label("Naziv-Relacija");
        Label lblDatum = new Label("Datum:");
	Label lblCena = new Label("Cena:");
	Label lblVozac = new Label("Vozac:");
	Label lblOdradjeno = new Label("Odradjeno:");
	
        TextField txtId = new TextField();
        TextField txtNaziv = new TextField();
	TextField dateDatum = new TextField();
	TextField txtCena = new TextField();
	TextField txtVozac = new TextField();
	TextField txtOdradjeno = new TextField();
        
        Button btnNazad = new Button("<");
        btnNazad.setPrefSize(60,30);
        Button btnNapred = new Button(">");
        btnNapred.setPrefSize(60,30);
        
        gp.add(lblId, 0, 0);
        gp.add(txtId, 2, 0);
        gp.add(lblNaziv,0,1);
        gp.add(txtNaziv,2,1);        
        gp.add(lblDatum,0,2);
        gp.add(dateDatum,2,2);       
        gp.add(lblCena,0,3);
        gp.add(txtCena,2,3);       
        gp.add(lblVozac,0,4);
        gp.add(txtVozac,2,4);        
        gp.add(lblOdradjeno,0,5);
        gp.add(txtOdradjeno,2,5);       
        gp.add(btnNazad,0,6);
        gp.add(btnNapred,2,6);
        
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
            Statistika i = Statistika.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");    
            txtNaziv.setText(i.getNaziv());
            dateDatum.setText(i.getDate());
            txtCena.setText(i.getCena() + "");
            txtVozac.setText(i.getVozac());
            txtOdradjeno.setText(i.getOdradjeno());           
            }
    });
       tableView.setOnMouseClicked((MouseEvent event) ->{

            txtId.setText(tableView.getSelectionModel().getSelectedItem().getId() + "");
           // txtNaziv.setText(tableView.getSelectionModel().getSelectedCells().getNaziv());
            dateDatum.setText(tableView.getSelectionModel().getSelectedItem().getDate());
            txtCena.setText(tableView.getSelectionModel().getSelectedItem().getCena() + "");
            txtVozac.setText(tableView.getSelectionModel().getSelectedItem().getVozac());
            txtOdradjeno.setText(tableView.getSelectionModel().getSelectedItem().getOdradjeno());
           
        
        });
       
       
         
         btnNapred.setOnAction(event ->{
            trenutniId++;
            Statistika i = Statistika.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtNaziv.setText(i.getNaziv());
            dateDatum.setText(i.getDate());
            txtCena.setText(i.getCena() + "");
            txtVozac.setText(i.getVozac());
            txtOdradjeno.setText(i.getOdradjeno());
            
            }
    });
         
        btnNazad.setOnAction(event ->{
             if(trenutniId > 1 ){
            trenutniId--;
           Statistika i = Statistika.dohvatiZaId(trenutniId);
            if(i != null){
            txtId.setText(i.getId() + "");   
            txtNaziv.setText(i.getNaziv());
            dateDatum.setText(i.getDate());
            txtCena.setText(i.getCena() + "");
            txtVozac.setText(i.getVozac());
            txtOdradjeno.setText(i.getOdradjeno());
            }
            
             }
        }); 
         btnDodaj.setOnAction(event ->{
             Statistika i = new  Statistika(
                     txtNaziv.getText(),
                     dateDatum.getText(),
                     Integer.parseInt(txtCena.getText()),
                     txtVozac.getText(),
                     txtOdradjeno.getText()
                     
             );
         int id = i.snimi();
             System.out.println(id + "");
         });
         
          btnSacuvaj.setOnAction(event ->{
             Statistika i = new  Statistika(
                     Integer.parseInt(txtId.getText()),
                     txtNaziv.getText(),
                     dateDatum.getText(),
                     Integer.parseInt(txtCena.getText()),
                     txtVozac.getText(),
                     txtOdradjeno.getText()           
             );
             int id = i.azuriraj();
             System.out.println(id + "");
         });
          
          btnIzbrisi.setOnAction(event ->{
             Statistika.obrisi(Integer.parseInt(txtId.getText()));
             
         });
    }
}
