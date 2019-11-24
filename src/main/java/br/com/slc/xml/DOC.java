package br.com.slc.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DOC")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DOC {
    @XmlElement(name = "BCMSG")
    BCMSG bcmsg;

    @XmlElement(name = "SISMSG")
    SISMSG sismsg;
}
