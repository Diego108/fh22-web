package br.com.caelum.argentum.modelo;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;

public class SerieTemporal {

	private final List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
	
		this.candles = candles;
	}

	public List<Candlestick> getCandles() {
	
		return candles;
	}
	
	public Candlestick getCandles(int position) {
		
		return this.candles.get(position);
	}
	
	public int getUltimaPosicao(){
		
		return this.candles.size() - 1;
	}
}
