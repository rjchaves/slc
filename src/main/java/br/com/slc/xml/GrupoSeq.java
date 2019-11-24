package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Grupo_Seq")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GrupoSeq {
    @XmlElement
    private Short NumSeq;
    @XmlElement
    private String IndrCont;


}
