package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.reader.ClienteWebService;

@ManagedBean
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	
	public ArgentumBean(){
		
		this.negociacoes = new ClienteWebService().getNegociacoes();
		List<Candlestick> candles = new CandlestickFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
