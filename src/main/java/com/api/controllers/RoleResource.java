package com.api.controllers;

import com.api.dtos.role.RoleDTO;
import com.api.dtos.role.RoleResult;
import com.api.services.role.IRoleService;
import com.api.utils.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/roles")
public class RoleResource {
    @Autowired
    private IRoleService roleService;

    @GetMapping(path="/{id}", produces = { "application/xml" })
    public RoleDTO getById(@PathVariable(value = "id") Integer roleId) {
        return roleService.getById(roleId);
    }

    @GetMapping(path="/nombre/{nombre}", produces = { "application/xml" })
    public RoleDTO getByNombre(@PathVariable(value = "nombre") String nombre) {
        return roleService.getByNombre(nombre);
    }

    @GetMapping(path = "/page/{page_num}", produces = { "application/xml" })
    public RoleResult getRoles(@PathVariable(value = "page_num")Integer pageNum) {
        return roleService.getAll(PageRequest.of(pageNum-1, Setting.PAGE_SIZE));
    }

    @GetMapping(produces = { "application/xml" })
    public RoleResult getAll() {
        return roleService.getAll(PageRequest.of(0, Setting.PAGE_SIZE));
    }

    @GetMapping(path = "/search/{size}/{page_num}/{textToFind}", produces = { "application/xml" })
    public com.api.dtos.role.RoleResult search(@PathVariable(value = "textToFind")String textToFind, @PathVariable(value = "page_num")Integer pageNum, @PathVariable(value = "size")Integer size) {
        return roleService.find(textToFind, PageRequest.of(pageNum-1, size));
    }

    @GetMapping(path="/count", produces= "application/xml")
    @Secured({ "ROLE_ADMIN", "ROLE_USER"})
    public RoleResult getCount(){
        return roleService.getCount();
    }
}