package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
		
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;
		
		for(Negociacao n : negociacoes){

			volume += n.getVoume();

			if(n.getPreco() > maximo){
				
				maximo = n.getPreco();
			}
			if(n.getPreco() < minimo){
				
				minimo = n.getPreco();
			}
		}
		
		if(minimo == Double.MAX_VALUE){
			
			minimo = 0;
		}
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size()-1).getPreco();
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
