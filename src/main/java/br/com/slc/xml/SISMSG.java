package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SISMSG")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SISMSG {
    @XmlElement(name = "SLC0001")
    SLC0001 slc0001;
}
