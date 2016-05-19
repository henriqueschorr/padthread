package com.pad.conta;

public class Consumidor extends Thread{
	private Conta conta;
	private int saques = 0;
	public Consumidor(Conta conta){
		this.conta = conta;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (conta) {

				while (
						conta.getValor() > 0 && 
						saques < 100) {
					conta.saca();
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					saques++;
					System.out.println("Consumindo -> " + conta.getValor() + " saques " + saques );
					
				}
			}
		}
		
	}
//	public void init() {
//		new Thread(this, "Consumidor").start();
//	}
}
