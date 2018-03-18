package it.tulchiar.BarcodeList.Test;

import java.sql.SQLException;

import it.tulchiar.BarcodeList.Properties_BarcodeList;
import it.tulchiar.BarcodeList.DB.BoxDAO;
import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.BoxFactory.BoxBarcodeType;
import javafx.collections.ObservableList;

public class BoxDAOTest {
	
	public static void main(String[] args) {
		
		Properties_BarcodeList.inizialize();
		
		try {
			
//			BoxDAO.insertBox(BoxFactory.create(BoxType.type1, "Barcode_nuovo_1", "Customer 1"));
			
			
			
//			ObservableList<Box> boxes = BoxDAO.getBoxList();

			Box box = BoxDAO.getBox("00080339201802293312");
			
//			for (Box box : boxes) {
//				System.out.println(box);
//			}
			
			System.out.println(box);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
