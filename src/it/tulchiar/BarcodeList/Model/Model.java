package it.tulchiar.BarcodeList.Model;

import java.sql.SQLException;

import it.tulchiar.BarcodeList.DB.BoxDAO;
import javafx.collections.ObservableList;

public class Model {

	public ObservableList<Box> getBoxes() {
		
		try {
			ObservableList<Box> boxes = BoxDAO.getBoxList();
			return boxes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Box getBox(String boxNumber) {
		
		try {
			Box box = BoxDAO.getBox(boxNumber);
			return box;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
