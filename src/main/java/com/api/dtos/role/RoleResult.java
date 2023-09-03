package com.api.dtos.role;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.api.dtos.base.BaseResult;

@XmlRootElement(name = "roleResult")
public class RoleResult extends BaseResult<RoleDTO> {

    private static final long serialVersionUID = 1L;
    public int _count;

    @XmlElement
    public List<RoleDTO> getRoles() {
        return getList();
    }

    public void setRoles(List<RoleDTO> dtos) {
        super.setList(dtos);
    }

    public int getCount(){
        return _count;
    }

    public void setCantidad(Integer cantidad) {
        _count=cantidad;
    }
}
