package com.pad.vetor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

//		System.out.println("Informe o tamanho dos vetores:");
//		int size = s.nextInt();
//		int size = 128;
		System.out.println("Informe a quantidade de threads:");
		int threadsNumber = s.nextInt();
		
		executa(threadsNumber);
		

	}
	
	public static void executa(int threadsNumber){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		int size = 13107200;
		
		long startTime = System.currentTimeMillis();
		
		Vetor vetor1 = new Vetor();
		vetor1.generateValues(size);
		
		Vetor vetor2 = new Vetor();
		vetor2.generateValues(size);
		
		int split = size / threadsNumber;
		int splitInit = 0;
		int splitEnd = split;
		int id = 1;
			
		for (int i=0; i<threadsNumber; i++) {	    	
	    	Soma soma = new Soma(vetor1.getValues(), vetor2.getValues(), splitInit, splitEnd, id);
	    	Thread t = new Thread(soma);
	    	threads.add(t);
		    t.start();
		    splitInit = splitEnd;
		    splitEnd += split;
		    id++;
		}
		
		for(int i = 0; i < threads.size(); i++){
			  try {
				  threads.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + totalTime);
	}

}
