package com.gs.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "restaurante")
@Table(name = "tb_restaurantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_restaurante")
    private Long id;
    @Column(name = "nome_restaurante")
    private String nome;
    @Column(name = "email_restaurante")
    private String email;
    @Column(name = "senha_restaurante")
    private String senha;
    @Column(name = "cnpj_restaurante")
    private String cnpj;
    @JoinColumn(name = "id_endereco")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private EnderecoRestaurante enderecoRestaurante;
    @OneToMany(mappedBy = "restauranteDoador", cascade = CascadeType.ALL)
    private List<Alimento> alimentos;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private LocalDate dataCadastro;
    @Column(name = "alimento_ativo", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean ativo;

    public Restaurante(RestauranteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.enderecoRestaurante = dados.endereco();
        this.cnpj = dados.cnpj();
    }

    public void desativarRestaurante(){
        this.ativo = false;
    }
}