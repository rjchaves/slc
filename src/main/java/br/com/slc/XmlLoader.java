package br.com.slc;

import br.com.slc.domain.Documento;
import br.com.slc.repository.DocumentoRepository;
import br.com.slc.xml.DOC;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

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
    public void onApplicationEvent(ContextRefreshedEvent event) throws JAXBException, IOException {
        var doc = loadXml();
        var document = objectMapper.convertValue(doc, Documento.class);
        documentoRepository.save(document);
    }

    public DOC loadXml() throws JAXBException, IOException {
        var is = new ClassPathResource("SLC0001-modelo.xml", this.getClass().getClassLoader()).getInputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(DOC.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (DOC) unmarshaller.unmarshal(is);
    }
}
