package it.tulchiar.BarcodeList.Model;

public class BoxFactory {
	
	public static final Integer MIN_BARCODE_LENGHT = 10;
	public static final Integer MAX_BARCODE_LENGHT = 21;
	
	public enum BoxBarcodeType {
		type1, //00080339201802293312
		type2  //XU004029804
	}
	
	
	private static BoxBarcodeType detectBarcodeType(String barcode) {
		
		if(barcode == null) return null;
		
		if(barcode.length() < 11) {
			throw(new RuntimeException("Lunghezza Barcode minore di 11 caratteri, tipo di Barcode non gestito"));
		}
		
		if(barcode.length() > 20) {
			throw(new RuntimeException("Lunghezza Barcode maggiore di 20 caratteri, tipo di Barcode non gestito"));
		}
		
		if(barcode.length() == 20) {
			return BoxBarcodeType.type1;
		}

		if(barcode.length() == 11) {
			return BoxBarcodeType.type2;
		}

		return null;
	}
	
	public static Box create(String barcode) {
		
		Box box = null;
		String boxNumber = "";
		
		BoxBarcodeType barcodeType = detectBarcodeType(barcode);
		
		switch (barcodeType) {
		case type1: //00080339201802293312
			
			boxNumber = barcode.substring(13, 19);
			
			box = new Box(boxNumber);
			return box;
		case type2: //XU004029804
			
			boxNumber = barcode.substring(4, 11);
			
			box = new Box(boxNumber);
			return box;
		default:
			return null;
		}
	}
	
	
	public static Box createFromBoxNumber(String boxNumber) {
		
		return new Box(boxNumber);
		
	}
	
	public static Box create(String boxNumber, String customer) {
				
		return new Box(boxNumber, customer);
		
	}
	
}