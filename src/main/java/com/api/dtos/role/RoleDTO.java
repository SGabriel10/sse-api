package com.api.dtos.role;

import com.api.dtos.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "role")
public class RoleDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private String _nombre;
    private String _descripcion;

    @XmlElement
    public String getNombre() {
        return _nombre;
    }
    public void setNombre(String nombre) {
        _nombre = nombre;
    }

    @XmlElement
    public String getDescripcion() {
        return _descripcion;
    }
    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;
    }
}
