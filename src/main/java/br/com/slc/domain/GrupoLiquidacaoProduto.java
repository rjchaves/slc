package br.com.slc.domain;

import br.com.slc.converters.CustomGrupoLiquidacaoProdutoConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@JsonDeserialize(converter = CustomGrupoLiquidacaoProdutoConverter.class)
public class GrupoLiquidacaoProduto {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String identificadorLinheBilateral;

    @Getter @Setter
    private String tipoDebitoCredito;

    @Getter @Setter
    private String ispbIfCreditada;

    @Getter @Setter
    private String ispbIfDebitada;

    @Getter @Setter
    private BigDecimal valorLancamento;

    @Getter @Setter
    private String cnpjNaoLiquidanteDebitado;

    @Getter @Setter
    private String nomeClienteDebitado;

    @Getter @Setter
    private String cnpjNaoLiquidanteCreditado;

    @Getter @Setter
    private String nomeClienteCreditado;

    @Getter @Setter
    private String tipoTransacaoSLC;

    @Getter @Setter
    @ManyToOne
    @JoinColumns(@JoinColumn(name="codigo_produto", referencedColumnName="codigo_produto"))
    @JsonIgnore
    private GrupoProduto grupoProduto;
}
