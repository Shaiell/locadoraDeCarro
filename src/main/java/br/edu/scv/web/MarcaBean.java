package br.edu.scv.web;



import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.scv.entidades.Marca;
import br.edu.scv.servicos.ServicoMarca;
import br.edu.scv.web.JSFUtils;

@Named
@RequestScoped
public class MarcaBean {
	
	@EJB
	private ServicoMarca servicoMarca;
	
	private Marca marca;
	
	private List<Marca> marcas;
	
	public MarcaBean() {
		this.marca = new Marca();
	}
	
	public void cadastrarMarca() {
		
		try {
		this.servicoMarca.cadastrarMarca(marca);
		JSFUtils.enviarMensagemDeInformacao("Marca cadastrada com sucesso!");
		this.marca =new Marca();
		}catch (Exception e) {
		JSFUtils.enviarMensagemDeAtencao(e.getMessage());	
		}
		
	}
	
	public List<Marca> listar() {
		return this.servicoMarca.Listar();
	}
	
	public void excluirMarca(Marca marca) {
		try {
		this.servicoMarca.excluirMarca(marca);
		JSFUtils.enviarMensagemDeInformacao("Marca excluida com Sucesso!!");
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		if(this.marcas==null) {
			this.marcas = this.servicoMarca.Listar();
		}
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

}
