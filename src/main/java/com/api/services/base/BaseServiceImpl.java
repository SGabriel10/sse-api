package com.api.services.base;


import com.api.domains.base.BaseDomain;
import com.api.dtos.base.BaseDTO;
import com.api.dtos.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO,   RESULT> {

    protected abstract DTO convertDomainToDto(DOMAIN domain);

    protected abstract DOMAIN convertDtoToDomain(DTO dto);

}