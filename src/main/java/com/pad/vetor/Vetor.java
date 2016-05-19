package com.pad.vetor;

import java.util.ArrayList;
import java.util.Random;

public class Vetor {
	
	private ArrayList<Integer> values;

	
	public Vetor() {
		values = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getValues() {
		return values;
	}



	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}

	public void generateValues(int size){
		Random gerador = new Random();
		for (int i = 0; i < size; i++) {
	    	values.add(gerador.nextInt(100));
		 }
	}
	
	

}
