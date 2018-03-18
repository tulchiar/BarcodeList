package it.tulchiar.BarcodeList.Test;

import it.tulchiar.BarcodeList.Model.Box;
import it.tulchiar.BarcodeList.Model.BoxFactory;
import it.tulchiar.BarcodeList.Model.Model;

public class BoxFactoryTest {

	public static void main(String[] args) {
// 00080339201802293312
		
		Box box = BoxFactory.create("00080339201802293312");
		
		System.out.println(box);
	
		Model model = new Model();
		
		String boxNumber = box.getBoxNumber();
		System.out.println("BoxNumber :" + boxNumber);
		Box box2 = model.getBox(boxNumber);
		System.out.println(box2);
		
	}
}
