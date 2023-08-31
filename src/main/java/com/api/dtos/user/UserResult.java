package com.api.dtos.user;

import com.api.dtos.base.BaseResult;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class UserResult extends BaseResult<UserDTO> {
    private static final long serialVersionUID = 1L;
    public int _count;
    @XmlElement
    public List<UserDTO> getUsers() {
        return getList();
    }
    public void setUsers(List<UserDTO> dtos) {
        super.setList(dtos);
    }

}
