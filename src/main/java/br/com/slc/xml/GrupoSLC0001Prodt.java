package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Grupo_SLC0001_Prodt")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GrupoSLC0001Prodt {
    @XmlElement(name = "CodProdt")
    private String codProdt;

    @XmlElement(name = "Grupo_SLC0001_LiquidProdt")
    List<GrupoSLC0001LiquidProdt> grupoSLC0001LiquidProdts = new ArrayList<>();
}
