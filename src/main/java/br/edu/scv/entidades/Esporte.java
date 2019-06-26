package br.edu.scv.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

/**
 * Representa um @link Esporte prefwrido de @link cliente
 * @author jclri
 *
 */
@Entity
public class Esporte {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_ESPORTE", sequenceName = "NUM_SEQ_ESPORTE" , allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_ESPORTE")
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@ManyToMany (mappedBy ="esportes" )
	private List<Cliente>clientes;
	
	public Esporte() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	

}
