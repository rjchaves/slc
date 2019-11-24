package br.com.slc.resource;

import br.com.slc.domain.Documento;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface DocumentoResource {
    @GetMapping("/documento")
    ResponseEntity<Page<Documento>> getDocumentos(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size);

    @GetMapping("/documento/{id}")
    ResponseEntity<Documento> getDocumento(@PathVariable Long id);
}
