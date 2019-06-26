package br.edu.scv.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Representa um veiculo
 * @author jclri
 *
 */

@Entity
public class Veiculo {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_VEICULO", sequenceName = "NUM_SEQ_VEICULO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_VEICULO")
	private Integer id;
	
	@NotNull
	@ManyToOne 
	@JoinColumn(name = "fk_marca")
	private Marca marca;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String placa;
	
	@NotBlank
	private String cor;
	
	@NotNull
	private Integer anoModelo;
	
	@NotNull
	private Integer fabricacaoModelo;
	
	@NotBlank
	private String tipoCombustivel;
	
	@NotNull
	private Double fipe;
	
	
	public Veiculo () {
		
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Integer getFabricacaoModelo() {
		return fabricacaoModelo;
	}

	public void setFabricacaoModelo(Integer fabricacaoModelo) {
		this.fabricacaoModelo = fabricacaoModelo;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Double getFipe() {
		return fipe;
	}

	public void setFipe(Double fipe) {
		this.fipe = fipe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
