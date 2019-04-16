
package at.ac.tuwien.dmap.dmapbackend.re3data.dto.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for repositoryTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="repositoryTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="disciplinary"/>
 *     &lt;enumeration value="institutional"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "repositoryTypes", namespace = "http://www.re3data.org/schema/2-2")
@XmlEnum
public enum RepositoryTypes {

    @XmlEnumValue("disciplinary")
    DISCIPLINARY("disciplinary"),
    @XmlEnumValue("institutional")
    INSTITUTIONAL("institutional"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    RepositoryTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RepositoryTypes fromValue(String v) {
        for (RepositoryTypes c: RepositoryTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
