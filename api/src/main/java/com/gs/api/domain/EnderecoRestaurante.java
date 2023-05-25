package com.gs.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "endereco_restaurante")
@Table(name="tb_endereco_restaurantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoRestaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_endereco")
    private Long id;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name="numero")
    private String numero;
    @Column(name = "uf", nullable = false)
    @Enumerated(EnumType.STRING)
    private Uf uf;
    @Column(name = "complemento")
    private String complemento;
    @JoinColumn(name = "id_restaurante")
    @OneToOne(mappedBy = "enderecoRestaurante")
    @JsonBackReference
    private Restaurante restaurante;
    @Column(name = "alimento_ativo", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean ativo;

    public void desativarEndereco(){
        this.ativo = false;
    }
}