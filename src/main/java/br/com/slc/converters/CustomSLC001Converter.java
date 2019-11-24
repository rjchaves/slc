package br.com.slc.converters;

import br.com.slc.domain.GrupoLiquidacao;
import br.com.slc.domain.SLC0001;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.util.List;

public class CustomSLC001Converter
        extends StdConverter<br.com.slc.xml.SLC0001, br.com.slc.domain.SLC0001> {
    @Override
    public SLC0001 convert(br.com.slc.xml.SLC0001 slc0001) {
        var entity = new br.com.slc.domain.SLC0001();
        var objectMapper = new ObjectMapper();
        entity.setCodigoMensagem(slc0001.getCodMsg());
        entity.setDataHoraSLC(slc0001.getDtHrSLC());
        entity.setDataMovimentacao(slc0001.getDtMovto());
        entity.setIspbif(slc0001.getIspbIf());
        entity.setNumeroControleSLC(slc0001.getNumCtrlSLC());
        entity.setTpInf(slc0001.getTpInf());

        var gls = objectMapper.convertValue(slc0001.getGruposSLC0001Liquid(), new TypeReference<List<GrupoLiquidacao>>() {});
        entity.setGrupoLiquidacoes(gls);
        return entity;
    }
}
