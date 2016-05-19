package com.pad.conta;

public class Produtor extends Thread {
	private Conta conta;
	private int depositos = 0;

	public Produtor(Conta conta) {
		this.conta = conta;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (conta) {
				while (conta.getValor() >= 0 && conta.getValor() <= conta.getLimiteMaximo() && depositos < 100) {
					conta.deposita();
					// try {
					// Thread.sleep(100);
					// } catch (InterruptedException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					depositos++;
					System.out.println("Produzindo -> " + conta.getValor() + " depositos " + depositos);

				}
			}
		}

	}

//	public void init() {
//		new Thread(this, "Produtor").start();
//	}

}
