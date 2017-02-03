package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("negociacao")
public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar)this.data.clone();
	}
	
	public double getVoume(){
		
		return this.preco * this.quantidade;
	}

	public Negociacao(double preco, int quantidade, Calendar data) {
		
		if(data == null){
			
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public boolean isMesmoDia(Calendar mesmoMomento) {
		// TODO Auto-generated method stub
		return this.data.get(Calendar.DAY_OF_MONTH) ==
							 	mesmoMomento.get(Calendar.DAY_OF_MONTH) &&
							 this.data.get(Calendar.MONTH) ==
							 	mesmoMomento.get(Calendar.MONTH) &&
							 this.data.get(Calendar.YEAR) ==
								 mesmoMomento.get(Calendar.YEAR);
	}
}
