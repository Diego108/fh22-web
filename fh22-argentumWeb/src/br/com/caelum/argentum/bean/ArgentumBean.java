package br.com.caelum.argentum.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.ClienteWebService;

@ManagedBean
public class ArgentumBean {

	List<Negociacao> negociacoes;
	
	public ArgentumBean(){
		
		negociacoes = new ClienteWebService().getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}
}
