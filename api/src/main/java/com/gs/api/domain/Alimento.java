package com.gs.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "alimentos")
@Table(name = "tb_alimentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_alimento")
    private Long id;
    @CreatedDate
    @Column(name = "data_doacao", nullable = false)
    private LocalDate dataDoacao;
    @ElementCollection
    @CollectionTable(name = "alimento_tags", joinColumns = @JoinColumn(name = "id_alimento"))
    @Column(name = "tag")
    private List<String> tags;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_doador_id", nullable = false)
    private Restaurante restauranteDoador;
    @Column(name = "alimento_ativo", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean ativo;

    public Alimento(AlimentoDTO dadosAlimento) {
        this.tags = dadosAlimento.tags();
    }


    public void desativarAlimento(){
        this.ativo = false;
    }
}
