package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "Grupo_SLC0001_LiquidProdt")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GrupoSLC0001LiquidProdt {
    @XmlElement(name = "IdentdLinhaBilat")
    private String identdLinhaBilat;
    @XmlElement(name = "TpDeb_Cred")
    private String tpDeb_Cred;
    @XmlElement(name = "ISPBIFCredtd")
    private String ispbifCredtd;
    @XmlElement(name = "ISPBIFDebtd")
    private String ispbifDebtd;
    @XmlElement(name = "VlrLanc")
    private BigDecimal vlrLanc;
    @XmlElement(name = "CNPJNLiqdantDebtd")
    private String cnpjNLiqdantDebtd;
    @XmlElement(name = "NomCliDebtd")
    private String nomCliDebtd;
    @XmlElement(name = "CNPJNLiqdantCredtd")
    private String cnpjNLiqdantCredtd;
    @XmlElement(name = "NomCliCredtd")
    private String nomCliCredtd;
    @XmlElement(name = "TpTranscSLC")
    private String tpTranscSLC;
}
