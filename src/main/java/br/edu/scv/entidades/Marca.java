package br.edu.scv.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

/**
 * Representa a {@link Marca} de um veiculo
 * @author jclri
 *
 */

@Entity
public class Marca {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_MARCA", sequenceName = "NUM_SEQ_MARCA" , allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_MARCA")
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;

	public Marca() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
