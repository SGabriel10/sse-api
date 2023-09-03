package com.api.domains.role;

import com.api.domains.base.BaseDomain;
import com.api.domains.user.UserDomain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleDomain implements BaseDomain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer _id;

    @ManyToMany(mappedBy = "_roles")
    private Set<UserDomain> _users = new HashSet<UserDomain>();

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion")
    private String _descripcion;

    public Integer getId() {
        return _id;
    }
    public void setId(Integer id) {
        _id = id;
    }

    public Set<UserDomain> getUsers() {
        return _users;
    }
    public void setUsers(Set<UserDomain> users) {
        _users = users;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }
    public void setDescripcion(String descripcion) {
        _descripcion = descripcion;
    }
}