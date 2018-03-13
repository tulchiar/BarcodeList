package it.tulchiar.BarcodeList.Model;

public class WarehouseTest {

	public static void main(String[] args) {
		Wharehouse warehouse = new Wharehouse();
		
		warehouse.addBox(new Box());
		warehouse.addBox(new Box("Barcode__123456"));
		warehouse.addBox(new Box("Barcode__123456"));
		warehouse.addBox(new Box("Barcode__123456"));
		warehouse.addBox(new Box("Barcode__123456"));

		System.out.println(warehouse);
		
		
	}

}
