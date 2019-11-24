package br.com.slc.domain;

import br.com.slc.converters.CustomSLC001Converter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonDeserialize(converter = CustomSLC001Converter.class)
public class SLC0001 {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String codigoMensagem;

    @Getter @Setter
    private String numeroControleSLC;

    @Getter @Setter
    private String ispbif;

    @Getter @Setter
    private String tpInf;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraSLC;

    @Getter @Setter
    @Temporal(TemporalType.DATE)
    private Date dataMovimentacao;

    @Setter
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "slc0001_id")
    List<GrupoLiquidacao> grupoLiquidacoes;

    public List<GrupoLiquidacao> getGgrupoLiquidacoes() {
        if(grupoLiquidacoes == null) {
            grupoLiquidacoes = new ArrayList<>();
        }
        return grupoLiquidacoes;
    }
}
