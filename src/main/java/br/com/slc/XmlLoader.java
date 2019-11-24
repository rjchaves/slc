package br.com.slc;

import br.com.slc.domain.Documento;
import br.com.slc.repository.DocumentoRepository;
import br.com.slc.xml.DOC;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlLoader {
    private DocumentoRepository documentoRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public XmlLoader(DocumentoRepository documentoRepository, ObjectMapper objectMapper) {
        this.documentoRepository = documentoRepository;
        this.objectMapper = objectMapper;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws JAXBException {
        var doc = loadXml();
        var document = objectMapper.convertValue(doc, Documento.class);
        documentoRepository.save(document);
    }

    public DOC loadXml() throws JAXBException {
        File file = new File(SlcApplication.class.getClassLoader().getResource("SLC0001-modelo.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(DOC.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (DOC) unmarshaller.unmarshal(file);

    }
}
