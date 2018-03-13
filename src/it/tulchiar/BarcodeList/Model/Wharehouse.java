package it.tulchiar.BarcodeList.Model;

import java.util.LinkedHashSet;

public class Wharehouse {
	private LinkedHashSet<Box> boxList;

	public Wharehouse() {
		this.boxList = new LinkedHashSet<Box>();
	}
	
	
	public LinkedHashSet<Box> getBoxList() {
		return boxList;
	}


	public void setBoxList(LinkedHashSet<Box> boxList) {
		this.boxList = boxList;
	}


	@Override
	public String toString() {
		String temp = "";
		
		for (Box box : this.boxList) {
			temp += box + "\n";
		}
		
		return temp;
	}


	public void addBox(Box box) throws RuntimeException {
		
		if(box == null) {
			System.out.println("Box non può essere Null");
			throw(new RuntimeException("Box non può essere Null"));
		} else {
//			System.out.println(box);
		}

		if(boxList.contains(box)) {
			System.out.println("Box già esistente");
			throw(new RuntimeException("Box già esistente"));
		} else {
//			System.out.println(box);
		}
		
		
		boxList.add(box);
	}
	
}
