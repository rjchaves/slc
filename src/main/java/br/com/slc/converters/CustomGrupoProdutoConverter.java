package br.com.slc.converters;

import br.com.slc.domain.GrupoLiquidacaoProduto;
import br.com.slc.domain.GrupoProduto;
import br.com.slc.xml.GrupoSLC0001Prodt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;

public class CustomGrupoProdutoConverter extends StdConverter<GrupoSLC0001Prodt, GrupoProduto> {

    @Override
    public GrupoProduto convert(GrupoSLC0001Prodt grupoSLC0001Prodt) {
        var gp = new GrupoProduto();
        var objectMapper = new ObjectMapper();
        var glps = objectMapper.convertValue(grupoSLC0001Prodt.getGrupoSLC0001LiquidProdts(), new TypeReference<List<GrupoLiquidacaoProduto>>() {});

        gp.setCodigoProduto(grupoSLC0001Prodt.getCodProdt());
        gp.setGrupoLiquidacaoProdutos(glps);
        return gp;
    }
}
