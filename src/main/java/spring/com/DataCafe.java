package spring.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bro")
public class DataCafe {
    private int id;
    private String name;
    private int code;


    public DataCafe() {
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    @XmlElement
    public void setCode(int code) {
        this.code = code;
    }
}
