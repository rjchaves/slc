package br.com.slc.domain;

import br.com.slc.converters.CustomDocumentoConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@JsonDeserialize(converter = CustomDocumentoConverter.class)
public class Documento {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String identificacaoEmissor;

    @Getter @Setter
    private String identificacaoDestinatario;

    @Getter @Setter
    private Short numeroSequencia;

    @Getter @Setter
    private String indicadorContinuacao;

    @Getter @Setter
    private String dominioDoSistema;

    @Getter @Setter
    private String numeroUnicoOperacao;

    @Getter @Setter
    @OneToOne
    @Cascade(CascadeType.PERSIST)
    private SLC0001 slc0001;
}
