package br.com.slc.domain;

import br.com.slc.converters.CustomGrupoProdutoConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonDeserialize(converter = CustomGrupoProdutoConverter.class)
public class GrupoProduto {
    @Id
    @Getter @Setter
    @Column(name = "codigo_produto")
    private String codigoProduto;

    @Setter
    @OneToMany
    @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "codigo_produto")
    private List<GrupoLiquidacaoProduto> grupoLiquidacaoProdutos;

    public List<GrupoLiquidacaoProduto> getGrupoLiquidacaoProdutos() {
        if (grupoLiquidacaoProdutos == null) {
            grupoLiquidacaoProdutos = new ArrayList<>();
        }
        return grupoLiquidacaoProdutos;
    }
}
