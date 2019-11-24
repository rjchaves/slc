package br.com.slc.resource;

import br.com.slc.domain.Documento;
import br.com.slc.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class DocumentoResourceImpl implements DocumentoResource {

    private DocumentoRepository documentoRepository;

    @Autowired
    public DocumentoResourceImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseEntity<Page<Documento>> getDocumentos(Optional<Integer> page, Optional<Integer> size) {
        var pageRequest = PageRequest.of(page.orElse(ResourceDefaults.DEFAULT_PAGE),
                size.orElse(ResourceDefaults.DEFAULT_PAGE_SIZE));
        var pageResponse = documentoRepository.findAll(pageRequest);
        if(pageResponse.getSize() > 0) return new ResponseEntity<>(pageResponse, HttpStatus.OK);
            else return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseEntity<Documento> getDocumento(Long id) {
        var documento = documentoRepository.findById(id);
        return documento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
