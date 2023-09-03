package com.api.daos.role;

import com.api.domains.role.RoleDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleDao extends PagingAndSortingRepository<RoleDomain, Integer> {
    Page<RoleDomain> findByNombreContaining(String nombre, Pageable pageable);
    Optional<RoleDomain> findByNombre(String nombre);
}