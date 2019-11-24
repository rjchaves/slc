package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "SLC0001")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SLC0001 {
    @XmlElement(name = "CodMsg")
    private String codMsg;

    @XmlElement(name = "NumCtrlSLC")
    private String numCtrlSLC;

    @XmlElement(name = "ISPBIF")
    private String ispbIf;

    @XmlElement(name = "TpInf")
    private String tpInf;

    @XmlElement(name = "Grupo_SLC0001_Liquid")
    List<GrupoSLC0001Liquid> gruposSLC0001Liquid;

    @XmlElement(name = "DtHrSLC")
    private Date dtHrSLC;

    @XmlElement(name = "DtMovto")
    private Date dtMovto;
}
