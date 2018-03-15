package it.tulchiar.BarcodeList.Model;

public class BoxFactory {
	
	public enum BoxType {
		type1,
		type2
	}
	
	public static Box create(BoxType boxType, String barcode, String customer) {
		Box box = null;
		
		switch (boxType) {
		case type1:
			box = new Box(barcode, customer);
			return box;
		case type2:
			box = new Box(barcode, customer);
			return box;
		default:
			return null;
		}
	}
}