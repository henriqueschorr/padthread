package com.pad.conta;

public class Main {
	public static void main(String[] args) {
	
				Conta conta = new Conta(0, 1000);
				Produtor p = new Produtor(conta);
				Consumidor c = new Consumidor(conta);
				p.start();
				c.start();
				

	}

}
