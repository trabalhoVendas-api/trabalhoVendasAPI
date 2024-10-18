package br.com.serratec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "vendedor_id")
public class VendedorAutonomo extends Vendedor {
    private Double comissao;

    // Getters e Setters
    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
}
