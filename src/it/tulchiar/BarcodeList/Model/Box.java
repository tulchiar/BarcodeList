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
	private StringProperty barcode = new SimpleStringProperty();
	private ObjectProperty<LocalDate> creationDate = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> splitDate = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<Customer> customer = new SimpleObjectProperty<Customer>();

	
	public Box() {
		this.idBox.setValue(0);
		this.barcode.setValue("New_Barcode");
		this.creationDate.setValue(LocalDate.now());
		this.splitDate.setValue(null);
		this.customer.setValue(new Customer());
	}

	public Box(String barcode) {
		this.idBox.setValue(0);
		this.barcode.setValue(barcode);
		this.creationDate.setValue(LocalDate.now());
		this.splitDate.setValue(null);
		this.customer.setValue(new Customer());
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
	
	public final StringProperty barcodeProperty() {
		return this.barcode;
	}
	
	public final String getBarcode() {
		return this.barcodeProperty().get();
	}
	
	public final void setBarcode(final String barcode) {
		this.barcodeProperty().set(barcode);
	}
	
	public final ObjectProperty<LocalDate> creationDateProperty() {
		return this.creationDate;
	}
	
	public final LocalDate getCreationDate() {
		return this.creationDateProperty().get();
	}
	
	public final void setCreationDate(final LocalDate creationDate) {
		this.creationDateProperty().set(creationDate);
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
	
	public final ObjectProperty<Customer> customerProperty() {
		return this.customer;
	}
	
	public final Customer getCustomer() {
		return this.customerProperty().get();
	}
	
	public final void setCustomer(final Customer customer) {
		this.customerProperty().set(customer);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
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
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Box [idBox=" + idBox.getValue() + ", barcode=" + barcode.getValue() + ", creationDate=" + creationDate.getValue() + ", splitDate="
				+ splitDate.getValue() + ", customer=" + customer.getValue() + "]";
	}
	
}
