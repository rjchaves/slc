package br.com.slc.converters;

import br.com.slc.domain.GrupoLiquidacao;
import br.com.slc.domain.GrupoProduto;
import br.com.slc.xml.GrupoSLC0001Liquid;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;

public class CustomGrupoLiquidacaoConverter extends StdConverter<GrupoSLC0001Liquid, GrupoLiquidacao> {
    @Override
    public GrupoLiquidacao convert(GrupoSLC0001Liquid slc0001Liquid) {
        var gl = new GrupoLiquidacao();
        var objectMapper = new ObjectMapper();
        gl.setDataLiquidacao(slc0001Liquid.getDtLiquid());
        gl.setNumeroSequencialCicloLiquidacao(slc0001Liquid.getNumSeqCicloLiquid());
        if(slc0001Liquid.getGrupoSLC0001Prodt() != null) {
            var gps = objectMapper.convertValue(slc0001Liquid.getGrupoSLC0001Prodt(),
                    new TypeReference<List<GrupoProduto>>(){});
            gl.setGrupoProdutos(gps);
        }
        return gl;
    }
}
