package it.tulchiar.BarcodeList.Test;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.BoxFactory.BoxBarcodeType;
import it.tulchiar.BarcodeList.Model.Wharehouse;

public class WarehouseTest {

	public static void main(String[] args) {
		Wharehouse warehouse = new Wharehouse();
		
		int x = 0;
	
		try {
			
			Box box = BoxFactory.create(BoxBarcodeType.type1, "Barcode__123456", "Bronx");
			warehouse.addBox(box);
			
			System.out.println("Box nr : " + ++x + " --- " + box);

			box = BoxFactory.create(BoxBarcodeType.type1, "Barcode__222222", "Bronx");
			warehouse.addBox(box);
			
			System.out.println("Box nr : " + ++x + " --- " + box);
			
			box = BoxFactory.create(BoxBarcodeType.type1, "Barcode__333333", "Sanquian");
			warehouse.addBox(box);
			
			System.out.println("Box nr : " + ++x + " --- " + box);
			
			box = BoxFactory.create(BoxBarcodeType.type1, "Barcode_444444", "Bronx");
			warehouse.addBox(box);
			
			System.out.println("\n---- Warehouse ----");
	
			System.out.println(warehouse);
			
		} catch(Exception ex) {
			System.out.println("Errore: " + ex.getMessage());
		}
		
	}

}
