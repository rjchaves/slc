package br.com.slc.domain;

import br.com.slc.converters.CustomGrupoLiquidacaoConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonDeserialize(converter = CustomGrupoLiquidacaoConverter.class)
public class GrupoLiquidacao {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Temporal(TemporalType.DATE)
    private Date dataLiquidacao;

    @Getter @Setter
    private Short numeroSequencialCicloLiquidacao;

    @Setter
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "grupo_liquidacao_id")
    List<GrupoProduto> grupoProdutos;

    public List<GrupoProduto> getGrupoProdutos() {
        if(grupoProdutos == null) {
            grupoProdutos = new ArrayList<>();
        }
        return grupoProdutos;
    }
}
