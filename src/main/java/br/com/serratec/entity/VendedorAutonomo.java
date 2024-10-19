package br.com.serratec.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

@Entity
public class VendedorAutonomo extends Vendedor {
	
	@Schema(description = "Comissao do vendedor Autonomo")
	private Double comissao;

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return "VendedorAutonomo [comissao=" + comissao + ", toString()=" + super.toString() + "]";
	}

}
