package br.com.caelum.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXML {

	@SuppressWarnings("unchecked")
	public static List<Negociacao> carrega(InputStream inputStream){
		
		XStream xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(Negociacao.class);
		xStream.alias("negociacao", Negociacao.class);
		
		return ((List<Negociacao>) xStream.fromXML(inputStream));	
	}
}
