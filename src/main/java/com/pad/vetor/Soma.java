package com.pad.vetor;

import java.util.ArrayList;

public class Soma implements Runnable{
	
	private ArrayList<Integer> values1;
	private ArrayList<Integer> values2;
	private ArrayList<Integer> valuesResult;
	private int result;
	private int splitInit;
	private int splitEnd;
	private int id;

	public Soma(ArrayList<Integer> values1, ArrayList<Integer> values2, int splitInit, int splitEnd, int id) {
		this.values1 = values1;
		this.values2 = values2;
		this.splitInit = splitInit;
		this.splitEnd = splitEnd;
		this.id = id;
		valuesResult = new ArrayList<Integer>();
		result = 0;
	}

	public void run() {
//		System.out.println("Inicio da Thread: " + id);
		this.somaVetores();
//		for (Integer value : valuesResult) {
//	    	System.out.println(value);
//		}
//		System.out.println("Fim da Thread: " + id);
	}
	
	public void somaVetores(){		
		for (int i=splitInit; i<splitEnd; i++) {
	    	valuesResult.add(values1.get(i) + values2.get(i));
		}
	}
	
	public void soma(){
		for (Integer value : valuesResult) {
	    	result += value;
		 }
	}

	public ArrayList<Integer> getValues1() {
		return values1;
	}

	public ArrayList<Integer> getValues2() {
		return values2;
	}

	public ArrayList<Integer> getValuesResult() {
		return valuesResult;
	}

	public int getResult() {
		return result;
	}	

}
