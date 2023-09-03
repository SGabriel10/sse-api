package com.api.dtos.user;

import com.api.dtos.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class UserDTO extends BaseDTO {
    private static final long serialVersionUID = 1L;
    private Integer _id;
    private String _name;
    private String _phone;

    private String _course;

    private String _email;

    private String _semester;

    private String _password;
    private Boolean _accountLocked;
    private List<Integer> _rolesId;

    @XmlElement
    public List<Integer> getRolesId() {
        return _rolesId;
    }
    public void setRolesId(List<Integer> rolesId) {
        _rolesId = rolesId;
    }
    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id=id;
    }

    @XmlElement
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name=name;
    }

    @XmlElement
    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone=phone;
    }

    public String getEmail(){ return _email;}

    public void setEmail(String email){_email = email;}

    public String getCourse(){return _course;}

    public void setCourse(String course){_course = course;}

    public String getSemester(){return _semester;}

    public void setSemester(String semester){_semester=semester;}

    @XmlElement
    public String getPassword() {
        return _password;
    }
    public void setPassword(String password) {
        _password = password;
    }

    @XmlElement
    public Boolean getAccountLocked() {
        return _accountLocked;
    }
    public void setAccountLocked(Boolean accountLocked) {
        _accountLocked = accountLocked;
    }
}
