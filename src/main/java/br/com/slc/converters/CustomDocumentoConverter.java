package br.com.slc.converters;

import br.com.slc.domain.Documento;
import br.com.slc.domain.SLC0001;
import br.com.slc.xml.DOC;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;

public class CustomDocumentoConverter extends StdConverter<DOC, Documento> {
    @Override
    public Documento convert(DOC doc) {
        var documento = new Documento();
        var objectMapper = new ObjectMapper();
        var bcmsg = doc.getBcmsg();
        documento.setDominioDoSistema(bcmsg.getDomSist());
        documento.setIdentificacaoDestinatario(bcmsg.getIdentdDestinatario());
        documento.setIdentificacaoEmissor(bcmsg.getIdentdEmissor());
        documento.setIndicadorContinuacao(bcmsg.getGrupo_SeqObject().getIndrCont());
        documento.setNumeroSequencia(bcmsg.getGrupo_SeqObject().getNumSeq());
        documento.setNumeroUnicoOperacao(bcmsg.getNUOp());
        if(doc.getSismsg() != null) {
            documento.setSlc0001(objectMapper.convertValue(doc.getSismsg().getSlc0001(), SLC0001.class));
        }
        return documento;
    }
}