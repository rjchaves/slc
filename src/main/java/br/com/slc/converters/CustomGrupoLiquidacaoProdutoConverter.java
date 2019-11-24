package br.com.slc.converters;

import br.com.slc.domain.GrupoLiquidacaoProduto;
import br.com.slc.xml.GrupoSLC0001LiquidProdt;
import com.fasterxml.jackson.databind.util.StdConverter;

public class CustomGrupoLiquidacaoProdutoConverter extends StdConverter<GrupoSLC0001LiquidProdt, GrupoLiquidacaoProduto> {

    @Override
    public GrupoLiquidacaoProduto convert(GrupoSLC0001LiquidProdt liquidProdt) {
        var glp = new GrupoLiquidacaoProduto();
        glp.setCnpjNaoLiquidanteCreditado(liquidProdt.getCnpjNLiqdantCredtd());
        glp.setCnpjNaoLiquidanteDebitado(liquidProdt.getCnpjNLiqdantDebtd());
        glp.setIdentificadorLinheBilateral(liquidProdt.getIdentdLinhaBilat());
        glp.setIspbIfCreditada(liquidProdt.getIspbifCredtd());
        glp.setIspbIfDebitada(liquidProdt.getIspbifDebtd());
        glp.setNomeClienteCreditado(liquidProdt.getNomCliCredtd());
        glp.setNomeClienteDebitado(liquidProdt.getNomCliDebtd());
        glp.setTipoDebitoCredito(liquidProdt.getTpDeb_Cred());
        glp.setTipoTransacaoSLC(liquidProdt.getTpTranscSLC());
        glp.setValorLancamento(liquidProdt.getVlrLanc());
        return glp;
    }
}
