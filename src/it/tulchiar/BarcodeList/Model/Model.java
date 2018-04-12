package it.tulchiar.BarcodeList.Model;

import java.sql.SQLException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import it.tulchiar.BarcodeList.DB.BoxDAO;
import it.tulchiar.BarcodeList.DB.ExcelDAO;
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
	
	public Boolean setSplitDate(Integer idBox) throws SQLException {
		return BoxDAO.setSplitDate(idBox);
	}
	
	public int loadDataFromExcelFile() {
		
		ExcelDAO excelDAO = new ExcelDAO();
		
		return excelDAO.loadDataFromExcelFile();
	}
	
}
