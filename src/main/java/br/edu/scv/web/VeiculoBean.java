package br.edu.scv.web;


import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.edu.scv.entidades.Veiculo;
import br.edu.scv.servicos.ServicoVeiculo;

@Named
@RequestScoped
public class VeiculoBean {
	
	@EJB
	private ServicoVeiculo servicoVeiculo;
	
	private Veiculo veiculo;
	
	public VeiculoBean() {
		this.setVeiculo(new Veiculo());
	}

	public void cadastraVeiculo() {
		this.servicoVeiculo.cadastrarVeiculo(veiculo);
		JSFUtils.enviarMensagemDeInformacao("Veiculo cadastrado com sucesso!");
		this.veiculo = new Veiculo();
	}
	
	public List<Veiculo> listar() {
		return this.servicoVeiculo.Listar();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
