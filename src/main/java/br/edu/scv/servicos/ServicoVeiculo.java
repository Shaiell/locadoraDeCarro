package br.edu.scv.servicos;


import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.scv.entidades.Marca;
import br.edu.scv.entidades.Veiculo;


@Stateless
public class ServicoVeiculo {
	
	@PersistenceContext
	private EntityManager em;
	
	

	public void cadastrarVeiculo(Veiculo veiculo) {
		this.em.persist(veiculo);
		
	}

	public List<Veiculo> Listar() {
		
		return this.em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
	}
	
	public void excluirVeiculo(Veiculo veiculo) {
		this.em.remove(this.em.merge(veiculo));
	}
	
	public List<Veiculo> listarVeiculosPorMarca(Marca marca) {
		javax.persistence.Query query = this.em.createQuery("SELECT v FROM Veiculo v WHERE v.marca=:p1", Veiculo.class);
		query.setParameter("p1", marca);
		return query.getResultList();
	}

}
