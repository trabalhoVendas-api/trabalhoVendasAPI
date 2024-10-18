package br.com.serratec.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Email(message = "Email deve ser válido")
    private String email;

    @DecimalMin(value = "1412.00", message = "O salário não pode ser menor que o salário mínimo")
    private Double salario;

    @OneToMany(mappedBy = "vendedor")
    private List<LancamentoVendas> lancamentos = new ArrayList<>();

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<LancamentoVendas> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<LancamentoVendas> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
