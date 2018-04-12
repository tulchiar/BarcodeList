package it.tulchiar.BarcodeList.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
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
		
		String sql = "SELECT `idBox`, `number`, `customer`, `inDate`, `splitDate`, `note` FROM boxes";
		
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
	
		ResultSet rs = ps.executeQuery();
		
		ObservableList<Box> boxes = FXCollections.observableArrayList();
		
		while (rs.next()) {
			
			Integer idBox = rs.getInt(Column.idBox.toString());
			String number = rs.getString(Column.number.toString());
			String customer = rs.getString(Column.customer.toString());
			LocalDate inDate = rs.getDate(Column.inDate.toString()).toLocalDate();
			
			LocalDate splitDate;
			if(rs.getDate(Column.splitDate.toString()) != null) {
				splitDate = rs.getDate(Column.splitDate.toString()).toLocalDate();
			} else {
				splitDate = null;
			}
			
			String note = rs.getString(Column.note.toString());
			
			
			Box b = BoxFactory.create(number, customer);
		
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
		
		conn.getConnection().close();
		return boxes;
	}
	
	
	public static Boolean insertBox(Box box) {
		
		
		String sql = "INSERT INTO `BarcodeList`.`Boxes`" + 
				" (`number`," + 
				" `inDate`," + 
				" `splitDate`," + 
				" `customer`," + 
				" `note`)" + 
				" VALUES" + 
				" (?,?,?,?,?);";
		
		DBConnection conn = new DBConnection();
		
		try {
			
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, box.getBoxNumber());
			
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
			
			Boolean result = ps.executeUpdate() > 0;
			if(result) {
				conn.getConnection().close();
				return true;
			} else {
				conn.getConnection().close();
				return false;
			}
			
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
	public static Box getBox(String boxNumber) throws SQLException {
		
		DBConnection conn = new DBConnection();
		
		String sql = "SELECT `idBox`, `number`, `customer`, `inDate`, `splitDate`, `note` FROM boxes"
				+ " WHERE `number` = ?";
		
		PreparedStatement ps = conn.getConnection().prepareStatement(sql);
		ps.setString(1, boxNumber);
		
		ResultSet rs = ps.executeQuery();
			
		while (rs.next()) {
			
			Integer idBox = rs.getInt(Column.idBox.toString());
			String number = rs.getString(Column.number.toString());
			String customer = rs.getString(Column.customer.toString());
			LocalDate inDate = rs.getDate(Column.inDate.toString()).toLocalDate();
			
			LocalDate splitDate;
			if(rs.getDate(Column.splitDate.toString()) != null) {
				splitDate = rs.getDate(Column.splitDate.toString()).toLocalDate();
			} else {
				splitDate = null;
			}
			
			String note = rs.getString(Column.note.toString());
			
			
			Box b = BoxFactory.createFromBoxNumber(number);
		
			b.setIdBox(rs.getInt(Column.idBox.toString()));
			b.setIdBox(idBox);
			b.setCustomer(customer);
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
			
			conn.getConnection().close();
			return b;
		}
		
		conn.getConnection().close();
		return null;
	}

	public static Boolean setSplitDate(Integer idBox) throws SQLException {
		
		String sql = "UPDATE `BarcodeList`.`Boxes` SET `splitDate`= ? WHERE `idBox`=?;";
		
		DBConnection conn = new DBConnection();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setDate(1, Date.valueOf(LocalDate.now()));
			ps.setInt(2, idBox);
			
			if(ps.executeUpdate() > 0) {
				return true;
			}
			
			conn.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(!conn.getConnection().isClosed()) conn.getConnection().close();
				
			e.printStackTrace();
			return false;
		}

		return false;
		
	}

}
