package br.edu.scv.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Cliente {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_CLIENTE", sequenceName = "NUM_SEQ_CLIENTE", allocationSize = 0)
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "CONTADOR_CLIENTE")
	private Integer id;
	
			
	@NotBlank
	private String nome;
	
	@NotBlank
	private String gr;
	
	@NotNull
	private Integer cpf;
	
	@NotBlank
	private String usuario;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private Date data;
	
	@NotBlank
	private String sexo;
	
	@NotBlank
	private String cidade;
	
	@ManyToMany
	private List<Esporte>esportes;
	
	
	
	
	
	public Cliente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGr() {
		return gr;
	}

	public void setGr(String gr) {
		this.gr = gr;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	


	
	
}
