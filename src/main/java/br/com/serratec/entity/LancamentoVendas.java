package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LancamentoVendas {
	
	@Schema(description = "Identificador único do usuário")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@Schema(description = "Data do lançamento da venda")
	
	private LocalDate data;
	
	@Schema(description = "Valor das vendas")
	private Double valor;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false )
	private VendedorAutonomo vendedor;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorAutonomo vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "LancamentoVendas [id=" + id + ", data=" + data + ", valor=" + valor + ", vendedor=" + vendedor + "]";
	}

}
