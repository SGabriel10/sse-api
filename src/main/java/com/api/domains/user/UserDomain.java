package com.api.domains.user;

import com.api.domains.base.BaseDomain;

import javax.persistence.*;

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

}