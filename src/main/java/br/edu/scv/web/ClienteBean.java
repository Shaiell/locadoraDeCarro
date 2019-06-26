package br.edu.scv.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.scv.entidades.Cliente;
import br.edu.scv.entidades.Esporte;
import br.edu.scv.entidades.Marca;
import br.edu.scv.servicos.ServicoCliente;

@Named
@RequestScoped
public class ClienteBean {
	
	@EJB
	private ServicoCliente servicocliente;
		
	private Cliente cliente;
	
	private List<Esporte> esportes;
	
	public ClienteBean() {
		this.cliente = new Cliente();
	}
	
	@PostConstruct
	public void init() {
		this.esportes = this.servicocliente.listarEsportes();
	}
	
	public void cadastrarCliente() {
		
		try {
		this.servicocliente.cadastrarCliente(getCliente());
		JSFUtils.enviarMensagemDeInformacao("Cliente Cadastrado!");
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	public void excluirCLiente(Cliente cliente) {
		
		this.servicocliente.excluirCliente(cliente);
		JSFUtils.enviarMensagemDeInformacao("Marca excluida com Sucesso!!");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	

}
