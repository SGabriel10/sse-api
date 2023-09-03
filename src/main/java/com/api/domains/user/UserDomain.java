package com.api.domains.user;

import com.api.domains.base.BaseDomain;
import com.api.domains.role.RoleDomain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class UserDomain implements BaseDomain {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer _id;

    @Column(name= "name")
    private String _name;

    @Column(name= "course")
    private String _course;

    @Column(name= "email")
    private String _email;

    @Column(name="phone")
    private String _phone;

    @Column(name="semester")
    private String _semester;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<RoleDomain> _roles = new HashSet<RoleDomain>();

    public Set<RoleDomain> getRoles() {
        return _roles;
    }
    public void setRoles(Set<RoleDomain> roles) {
        _roles = roles;
    }

    @Column(name="password")
    private String _password;

    @Column(name="accountLocked")
    private Boolean _accountLocked;

    @Column(name="correo", unique = true)
    private String correo;

    public Integer getId(){return _id;}
    public String getName(){return _name;}

    public void setName(String name){_name=name;}

    public String getCourse(){return _course;}

    public void setCourse(String course){_course=course;}

    public String getEmail(){return _email;}

    public void setEmail(String email){_email=email;}

    public String getPhone(){ return _phone;}

    public void setPhone(String phone){ _phone=phone;}

    public String getSemester(){return _semester;}

    public void setSemester(String semester){_semester=semester;}
    public String getPassword() {
        return _password;
    }
    public void setPassword(String password) {
        _password = password;
    }

    public Boolean getAccountLocked() {
        return _accountLocked;
    }
    public void setAccountLocked(Boolean accountLocked) {
        _accountLocked = accountLocked;
    }
}