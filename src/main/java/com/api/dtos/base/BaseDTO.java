package com.api.dtos.base;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer _id;

    @XmlElement
    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

}