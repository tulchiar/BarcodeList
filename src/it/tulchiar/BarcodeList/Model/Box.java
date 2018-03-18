package it.tulchiar.BarcodeList.Model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Box {
	private IntegerProperty idBox = new SimpleIntegerProperty();
	private StringProperty boxNumber = new SimpleStringProperty();
	private StringProperty customer = new SimpleStringProperty();
	private StringProperty note = new SimpleStringProperty();
	private ObjectProperty<LocalDate> inDate = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> splitDate = new SimpleObjectProperty<LocalDate>();

	
	public Box() {
		this.idBox.setValue(0);
		this.boxNumber.setValue("New_Barcode");
		this.customer.setValue("");
		this.note.setValue("");
		this.inDate.setValue(LocalDate.now());
		this.splitDate.setValue(null);
	}

	public Box(String boxNumber) {
		this.idBox.setValue(0);
		this.boxNumber.setValue(boxNumber);
		this.customer.setValue("");
		this.note.setValue("");
		this.inDate.setValue(LocalDate.now());
		this.splitDate.setValue(null);
	}
	
	public Box(String boxNumber, String customer) {
		this.idBox.setValue(0);
		this.boxNumber.setValue(boxNumber);
		this.customer.setValue(customer);
		this.note.setValue("");
		this.inDate.setValue(LocalDate.now());
		this.splitDate.setValue(null);
	}
	
	public final IntegerProperty idBoxProperty() {
		return this.idBox;
	}
	
	public final int getIdBox() {
		return this.idBoxProperty().get();
	}
	
	public final void setIdBox(final int idBox) {
		this.idBoxProperty().set(idBox);
	}
	
	public final StringProperty boxNumberProperty() {
		return this.boxNumber;
	}
	
	public final String getBoxNumber() {
		return this.boxNumberProperty().get();
	}
	
	public final void setBoxNumber(final String boxNumber) {
		this.boxNumberProperty().set(boxNumber);
	}
	
	public final ObjectProperty<LocalDate> inDateProperty() {
		return this.inDate;
	}
	
	public final LocalDate getInDate() {
		return this.inDateProperty().get();
	}
	
	public final void setInDate(final LocalDate inDate) {
		this.inDateProperty().set(inDate);
	}
	
	public final ObjectProperty<LocalDate> splitDateProperty() {
		return this.splitDate;
	}
	
	public final LocalDate getSplitDate() {
		return this.splitDateProperty().get();
	}
	
	public final void setSplitDate(final LocalDate splitDate) {
		this.splitDateProperty().set(splitDate);
	}
	
	public final StringProperty customerProperty() {
		return this.customer;
	}
	

	public final String getCustomer() {
		return this.customerProperty().get();
	}
	

	public final void setCustomer(final String customer) {
		this.customerProperty().set(customer);
	}
	

	public final StringProperty noteProperty() {
		return this.note;
	}
	
	
	public final String getNote() {
		return this.noteProperty().get();
	}
	
	
	public final void setNote(final String note) {
		this.noteProperty().set(note);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boxNumber.getValue() == null) ? 0 : boxNumber.getValue().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		if (boxNumber == null) {
			if (other.boxNumber.getValue() != null)
				return false;
		} else if (boxNumber.getValue() != other.boxNumber.getValue())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Box [idBox=" + idBox.getValue() + ", barcode=" + boxNumber.getValue() + ", creationDate=" + inDate.getValue() + ", splitDate="
				+ splitDate.getValue() + ", customer=" + customer.getValue() + "]";
	}

	
	
}
