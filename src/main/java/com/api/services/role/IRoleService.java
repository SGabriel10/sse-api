package com.api.services.role;

import com.api.dtos.role.RoleDTO;
import com.api.dtos.role.RoleResult;
import com.api.services.base.IBaseService;

public interface IRoleService extends IBaseService<RoleDTO, RoleResult> {
    public RoleDTO getByNombre(String nombre);
    public RoleResult getCount();
}