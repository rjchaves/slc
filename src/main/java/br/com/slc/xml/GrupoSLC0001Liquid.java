package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Grupo_SLC0001_Liquid")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GrupoSLC0001Liquid {
    @XmlElement
    private Date DtLiquid;
    @XmlElement
    private Short NumSeqCicloLiquid;
    @XmlElement(name = "Grupo_SLC0001_Prodt")
    List<GrupoSLC0001Prodt> GrupoSLC0001Prodt = new ArrayList ();
}
