package com.api.services.base;

import com.api.dtos.base.BaseDTO;
import com.api.dtos.base.BaseResult;
import org.springframework.data.domain.Pageable;

public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
    public DTO save(DTO dto);

    public DTO getById(Integer id);

    public R getAll(Pageable pageable);

    public R find(String search, Pageable pageable);

}
