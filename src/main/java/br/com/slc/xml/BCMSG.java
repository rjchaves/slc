package br.com.slc.xml;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BCMSG")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BCMSG {
    @XmlElement
    private String IdentdEmissor;
    @XmlElement
    private String IdentdDestinatario;
    @XmlElement(name = "Grupo_Seq")
    GrupoSeq grupo_SeqObject;
    @XmlElement
    private String DomSist;
    @XmlElement
    private String NUOp;
}
