package br.edu.scv.servicos;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.scv.entidades.Marca;
import br.edu.scv.entidades.Veiculo;


@Stateless
public class ServicoMarca {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private ServicoVeiculo servicoVeiculo;
	
	@EJB
	private ServicoMarca servicoMarca;

	
	public void cadastrarMarca(Marca marca) throws Exception {
		
		List<Marca> marcas = this.listarMarcaPorNome(marca);
		
		if(marcas.isEmpty()) {
			this.em.persist(marca);
		}else {
			
		throw new Exception("Marca ja esta cadastrada!");
		}
		
	}
	
	public List<Marca> listarMarcaPorNome(Marca marca) {
		javax.persistence.Query query = this.em.createQuery("SELECT m FROM Marca m WHERE m.nome=:p1", Marca.class);
		query.setParameter("p1", marca.getNome());
		return query.getResultList();
	}

	public List<Marca> Listar() {
		
		return this.em.createQuery("SELECT m FROM Marca m",Marca.class).getResultList();
				
	}
	
	public void excluirMarca(Marca marca) throws Exception {
		
		List<Veiculo> veiculos = this.servicoVeiculo.listarVeiculosPorMarca(marca);
		
		if(veiculos.isEmpty()) {
		this.em.remove(this.em.merge(marca));
		}else {
			throw new Exception("Não foi possivel excluir a marca porque existe veiculos associados!");
		}
	}
	
	

}
