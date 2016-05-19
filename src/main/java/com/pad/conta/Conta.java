package com.pad.conta;

public class Conta {
	private int valor;
	private int limiteMaximo;
	private int limiteMinimo;
	public Conta(int limiteMinimo, int limiteMaximo){
		this.limiteMinimo = limiteMinimo;
		this.limiteMaximo = limiteMaximo;
	}
	public synchronized void saca(){
		if(valor > limiteMinimo){
			valor--;		
			notifyAll();
		}		
	}
	public synchronized void deposita(){
		if(valor < limiteMaximo){
			valor++;	
			notifyAll();
		}
	}
	public int getValor(){
		return valor;
	}
	public int getLimiteMaximo() {
		return limiteMaximo;
	}

	public void setLimiteMaximo(int limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}

	public int getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(int limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}
}
