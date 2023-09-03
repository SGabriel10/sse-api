package com.api.services.role;



import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.api.daos.role.IRoleDao;
import com.api.domains.role.RoleDomain;
import com.api.dtos.role.RoleDTO;
import com.api.dtos.role.RoleResult;
import com.api.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;



@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDomain, RoleResult> implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override

    public RoleDTO getById(Integer id) {
        try {
            final RoleDomain domain = roleDao.findById(id).get();
            return convertDomainToDto(domain);

        } catch(NoSuchElementException exc) {
          throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Role con id="+id+" no encontrado");
        }
    }

    @Override
    protected RoleDTO convertDomainToDto(RoleDomain domain) {
        try {
            final RoleDTO dto = new RoleDTO();
            dto.setId(domain.getId());
            dto.setNombre(domain.getNombre());
            dto.setDescripcion(domain.getDescripcion());
            return dto;

        }catch(NullPointerException exc) {
         throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        }
    }

    @Override
    protected RoleDomain convertDtoToDomain(RoleDTO dto) {
        try {
            final RoleDomain domain = new RoleDomain();
            domain.setId(dto.getId());
            domain.setNombre(dto.getNombre());
            domain.setDescripcion(dto.getDescripcion());
            return domain;

        }catch(NullPointerException exc) {
          throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        }
    }

    @Override
    public RoleResult getAll(Pageable pageable) {
        try {
            final Page<RoleDomain> list = roleDao.findAll(pageable);
            final List<RoleDTO> dtos= new ArrayList<RoleDTO>();

            for(RoleDomain domain : list) {
                RoleDTO roleDTO = convertDomainToDto(domain);
                dtos.add(roleDTO);
          }

            RoleResult roleResult = new RoleResult();
            roleResult.setRoles(dtos);
            return roleResult;

        }catch(ArrayIndexOutOfBoundsException exc) {
        throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage());
        }
    }

    @Override
    public RoleResult find(String search, Pageable pageable) {
        try {
            final Page<RoleDomain> list = roleDao.findByNombreContaining(search, pageable);
            final List<RoleDTO> dtos= new ArrayList<RoleDTO>();

            for(RoleDomain domain : list) {
                dtos.add(convertDomainToDto(domain));
            }

            RoleResult roleResult = new RoleResult();
            roleResult.setRoles(dtos);
            return roleResult;

        }catch(ArrayIndexOutOfBoundsException exc) {
          throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage());
        }
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoleDTO getByNombre(String nombre) {
        final RoleDomain domain = roleDao.findByNombre(nombre).get();
        return convertDomainToDto(domain);
    }

    @Override
    public RoleResult getCount() {
        final RoleResult rol = new RoleResult();
        rol.setCantidad((int)roleDao.count());
        return rol;
    }
}

