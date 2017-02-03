package br.com.caelum.incadores.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.GerardorDeSerie;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void mediaMovelSImplesTest() {
		
		SerieTemporal serie = GerardorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		
		MediaMovelSimples mms = new MediaMovelSimples();
		
		Assert.assertEquals(2.0,  mms.calcula(2, serie), 0.00001);
		Assert.assertEquals(3.0,  mms.calcula(3, serie), 0.00001);
		Assert.assertEquals(10.0 / 3,  mms.calcula(4, serie), 0.00001);
		Assert.assertEquals(11.0 / 3,  mms.calcula(5, serie), 0.00001);
		Assert.assertEquals(4.0,  mms.calcula(6, serie), 0.00001);
		Assert.assertEquals(13.0 / 3,  mms.calcula(7, serie), 0.00001);
		Assert.assertEquals(4.0,  mms.calcula(8, serie), 0.00001);
	}
	
	@Test
	public void mediaMovelPonderadaTest() {
		
		SerieTemporal serie = GerardorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		
		MediaMovelPonderada mmp = new MediaMovelPonderada();
		
		Assert.assertEquals(14.0/6,  mmp.calcula(2, serie), 0.00001);
		Assert.assertEquals(20.0/6, mmp.calcula(3, serie), 0.00001);
		Assert.assertEquals(26.0/6,  mmp.calcula(4, serie), 0.00001);
		Assert.assertEquals(32.0/6,  mmp.calcula(5, serie), 0.00001);
		}
	
	@Test
	public void listaDeSerieNaoPodeSerNula(){
		
		SerieTemporal serie = GerardorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		Assert.assertNotNull(serie);
	}
}
