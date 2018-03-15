package it.tulchiar.BarcodeList.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.BoxFactory.BoxType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoxDAO {
	
	/**
	 * Ottiene l'elenco di tutte le spedizioni
	 * @return ObservableList<Shipment>
	 * @throws SQLException
	 */
	public static ObservableList<Box> getBoxList() throws SQLException {
		
		DBConnection conn = new DBConnection();
		
		String sql = "SELECT `idBox`, `barcode`, `customer`, `inDate`, `splitDate`, `note` FROM boxes";
		
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
	
		ResultSet rs = ps.executeQuery();
		
		ObservableList<Box> boxes = FXCollections.observableArrayList();
		
		while (rs.next()) {
			
			Integer idBox = rs.getInt(Column.idBox.toString());
			String barcode = rs.getString(Column.barcode.toString());
			String customer = rs.getString(Column.customer.toString());
			LocalDate inDate = rs.getDate(Column.inDate.toString()).toLocalDate();
			
			LocalDate splitDate;
			if(rs.getDate(Column.splitDate.toString()) != null) {
				splitDate = rs.getDate(Column.splitDate.toString()).toLocalDate();
			} else {
				splitDate = null;
			}
			
			String note = rs.getString(Column.note.toString());
			
			
			Box b = BoxFactory.create(BoxType.type1, barcode, customer);
		
			b.setIdBox(rs.getInt(Column.idBox.toString()));
			b.setIdBox(idBox);
			b.setInDate(inDate);
			b.setSplitDate(splitDate);
			b.setNote(note);
			
//			Status Date
			LocalDate date = null;			
			if (rs.getDate(Column.inDate.toString()) != null) {
				
				date = rs.getDate(Column.inDate.toString()).toLocalDate();
				b.inDateProperty().set(date);
			} else {
				date = LocalDate.parse("2000-01-01");
				b.inDateProperty().set(date);
			}
			
						
			boxes.add(b);			
		}
		
		return boxes;
	}
	
	
	public static Boolean insertBox(Box box) {
		
		
		String sql = "INSERT INTO `BarcodeList`.`Boxes`" + 
				" (`barcode`," + 
				" `inDate`," + 
				" `splitDate`," + 
				" `customer`," + 
				" `note`)" + 
				" VALUES" + 
				" (?,?,?,?,?);";
		
		DBConnection conn = new DBConnection();
		
		try {
			
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, box.getBarcode());
			
			if(box.getInDate() != null) {				
				ps.setDate(2, Date.valueOf(box.getInDate()));
			} else {
				ps.setNull(2, java.sql.Types.DATE);
			}
			
			if(box.getSplitDate() != null) {				
				ps.setDate(3, Date.valueOf(box.getSplitDate()));
			} else {
				ps.setNull(3, java.sql.Types.DATE);
			}
			
			ps.setString(4, box.getCustomer());
			ps.setString(5, box.getNote());
			
			return (ps.executeUpdate() > 0) ? true : false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;	
		
	}
	
	/**
	 * Ottiene l'elenco di tutte le spedizioni
	 * @return ObservableList<Shipment>
	 * @throws SQLException
	 */
	public static Box getBox(String barcodeToFind) throws SQLException {
		
		DBConnection conn = new DBConnection();
		
		String sql = "SELECT `idBox`, `barcode`, `customer`, `inDate`, `splitDate`, `note` FROM boxes"
				+ " WHERE `barcode` = ?";
		
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
		ps.setString(1, barcodeToFind);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			Integer idBox = rs.getInt(Column.idBox.toString());
			String barcode = rs.getString(Column.barcode.toString());
			String customer = rs.getString(Column.customer.toString());
			LocalDate inDate = rs.getDate(Column.inDate.toString()).toLocalDate();
			
			LocalDate splitDate;
			if(rs.getDate(Column.splitDate.toString()) != null) {
				splitDate = rs.getDate(Column.splitDate.toString()).toLocalDate();
			} else {
				splitDate = null;
			}
			
			String note = rs.getString(Column.note.toString());
			
			
			Box b = BoxFactory.create(BoxType.type1, barcode, customer);
		
			b.setIdBox(rs.getInt(Column.idBox.toString()));
			b.setIdBox(idBox);
			b.setInDate(inDate);
			b.setSplitDate(splitDate);
			b.setNote(note);
			
//			Status Date
			LocalDate date = null;			
			if (rs.getDate(Column.inDate.toString()) != null) {
				
				date = rs.getDate(Column.inDate.toString()).toLocalDate();
				b.inDateProperty().set(date);
			} else {
				date = LocalDate.parse("2000-01-01");
				b.inDateProperty().set(date);
			}		
			return b;
		}
		
		return null;
	}
}
