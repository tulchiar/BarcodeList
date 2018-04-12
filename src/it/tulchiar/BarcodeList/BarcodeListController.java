/**
 * Sample Skeleton for 'BarcodeList.fxml' Controller Class
 */

package it.tulchiar.BarcodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BarcodeListController {

	private Model model;
	private ObservableList<Box> boxes;
	
	public void setModel(Model model) {
		this.model = model;
	}

	public BarcodeListController() {
		boxes = FXCollections.observableArrayList();
		Box box = BoxFactory.create("1234", "customer");
		boxes.add(box);
		
	}
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblCustomer"
    private Label lblCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="txtBarcode"
    private TextField txtBarcode; // Value injected by FXMLLoader
    
    @FXML
    private ImageView imgCsv;
    
    @FXML
    private TableView<Box> tblBoxes;

    @FXML
    private TableColumn<Box, StringProperty> colBoxNumber;

    @FXML
    private TableColumn<Box, StringProperty> colCustomer;

    @FXML
    private TableColumn<Box, ObjectProperty<LocalDate>> colSplitDate;
    
    @FXML
    void doExportFileCsv(MouseEvent event) {
    		System.out.println("Exporto l'elenco in un file CSV");
    }

    @FXML
    void doImageDragOver(DragEvent de) {
    	 Dragboard board = de.getDragboard();
         if (board.hasFiles()) {
           de.acceptTransferModes(TransferMode.ANY);
         }
    }
    
    @FXML
    void doImportFileCsv(DragEvent de) {
    	 try {
    	        Dragboard board = de.getDragboard();
    	        List<File> phil = board.getFiles();
    	        FileInputStream fis;
    	          fis = new FileInputStream(phil.get(0));
    	      } catch (FileNotFoundException e) {
    	        e.printStackTrace();
    	      }
    		System.out.println("Hai appena rilasciato un file sull'icona CSV");
    }
    
    private void setup() { 	
    	
	    	tblBoxesSetup();
	    	
	    	txtBarcode.setOnKeyPressed(new EventHandler<KeyEvent>() {
	    		 @Override
	    		    public void handle(KeyEvent event) {
	    		        if(event.getCode().equals(KeyCode.ENTER)) {
	
	
	    		        	try {
	    						if(txtBarcode.getText().length() > BoxFactory.MIN_BARCODE_LENGHT && txtBarcode.getText().length() < BoxFactory.MAX_BARCODE_LENGHT) {
	    							lblCustomer.setText("Elaborazione");
	    							System.out.println("Text Changed - " + txtBarcode.getText());
	    							
	    							
	    							System.out.println();
	    							
	    							Box box = model.getBox(BoxFactory.create(txtBarcode.getText()).getBoxNumber());
	    							
	    							System.out.println(BoxFactory.create(txtBarcode.getText()).getBoxNumber());
	    							System.out.println("Box: - " + box);
	    							
	    							lblCustomer.setText(box.getCustomer());
	    							
	    							boxes.add(box);
	    							model.setSplitDate(box.getIdBox());
	    							txtBarcode.selectAll();
	    							
	    						}
	    					} catch (Exception e) {
	    						// TODO: handle exception
	    					}
	    		        	
	    		        }
	    		    }
			});
    }
     
    void tblBoxesSetup() {
    		colBoxNumber.setCellValueFactory(
    				new PropertyValueFactory<>("boxNumber"));
    		colCustomer.setCellValueFactory(
    				new PropertyValueFactory<>("customer"));
    		colSplitDate.setCellValueFactory(
    				new PropertyValueFactory<>("splitDate"));
    		
    		
    		tblBoxes.setItems(boxes);
    		
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	setup();
    	
    	
        assert lblCustomer != null : "fx:id=\"lblCustomer\" was not injected: check your FXML file 'BarcodeList.fxml'.";
        assert txtBarcode != null : "fx:id=\"txtBarcode\" was not injected: check your FXML file 'BarcodeList.fxml'.";

    }
}
