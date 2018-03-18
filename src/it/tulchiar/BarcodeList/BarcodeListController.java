/**
 * Sample Skeleton for 'BarcodeList.fxml' Controller Class
 */

package it.tulchiar.BarcodeList;

import java.net.URL;
import java.util.ResourceBundle;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class BarcodeListController {

	private Model model;
		
	public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblCustomer"
    private Label lblCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="txtBarcode"
    private TextField txtBarcode; // Value injected by FXMLLoader
    
    
    private void setup() { 	
    	
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
    						}
    					} catch (Exception e) {
    						// TODO: handle exception
    					}
    		        	
    		        }
    		    }
		});
    }
       

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	setup();
    	
        assert lblCustomer != null : "fx:id=\"lblCustomer\" was not injected: check your FXML file 'BarcodeList.fxml'.";
        assert txtBarcode != null : "fx:id=\"txtBarcode\" was not injected: check your FXML file 'BarcodeList.fxml'.";

    }
}
