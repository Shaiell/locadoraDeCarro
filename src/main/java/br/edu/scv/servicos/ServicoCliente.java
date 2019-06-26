package br.edu.scv.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.scv.entidades.Cliente;
import br.edu.scv.entidades.Esporte;
import br.edu.scv.entidades.Veiculo;

@Stateless
public class ServicoCliente {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void cadastrarCliente(Cliente cliente) throws Exception {
		List<Cliente> clientes = this.listarClientePorCpf(cliente);
		
		if(clientes.isEmpty()) {
			this.em.persist(cliente);
		}else {
			throw new Exception("Cliente Ja cadastrado!");
		}
		
	}

	
	public List<Cliente> listarClientePorCpf(Cliente cliente){
		Query query = this.em.createNamedQuery("SELECT c FROM Cliente c WHERE c.cpf=:p1", Cliente.class);
		query.setParameter("p1", cliente.getCpf());
		return query.getResultList();
	}
	
	public void excluirCliente(Cliente cliente) {
		this.em.remove(this.em.merge(cliente));
	}
	
	public List<Esporte> listarEsportes(){
		return this.em.createQuery("SELECT e FROM Esporte e", Esporte.class).getResultList();
	}
}
