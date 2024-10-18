package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.entity.Vendedor;

public class LancamentoVendasResponseDTO {
	
	private LocalDate data;
	private double valor;
	private String nomeVendedor;
	
	public LancamentoVendasResponseDTO(LancamentoVendas lancamentoVendas) {
		this.data = lancamentoVendas.getData();
		this.valor = lancamentoVendas.getValor();
		this.nomeVendedor = lancamentoVendas.getVendedor().getNome();
		
		
	}
	public LancamentoVendasResponseDTO() {
		super();
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	
	

}
