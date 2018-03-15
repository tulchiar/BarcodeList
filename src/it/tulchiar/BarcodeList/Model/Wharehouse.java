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
			throw(new RuntimeException("Box non può essere Null"));
		}

		if(boxList.contains(box)) {
			throw(new RuntimeException("Box già esistente"));
		} 
				
		boxList.add(box);
	}
	
}
