package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandleStickComUmaNegociacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 2, hoje);
		
		//Com a linha escrita abaixo está sendo feito 
		//o teste de uma negociação apenas
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		

		//Com a linha escrita abaixo está sendo feito 
		//o teste de nenhuma negociação apenas
		//List<Negociacao> negociacoes = Arrays.asList();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println("Abertura   : " + candle.getAbertura()   + "\n" + 
				   "Fechamento : " + candle.getFechamento() + "\n" + 
				   "Minimo     : " + candle.getMinimo()     + "\n" +
				   "Maximo     : " + candle.getMaximo()     + "\n" +
				   "Volume     : " + candle.getVolume());
	}

}
