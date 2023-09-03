package com.api.services.user;

import com.api.daos.user.IUserDao;
import com.api.domains.user.UserDomain;
import com.api.dtos.user.UserDTO;
import com.api.dtos.user.UserResult;
import com.api.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserResult>implements IUserService {
   @Autowired
   private IUserDao userDao;

    @Override
    protected UserDTO convertDomainToDto(UserDomain domain) {
        try {
            final UserDTO dto = new UserDTO();
            dto.setId(domain.getId());
            dto.setName(domain.getName());
            dto.setCourse(domain.getCourse());
            dto.setEmail(domain.getEmail());
            dto.setPhone(domain.getPhone());
            dto.setSemester(domain.getSemester());
            dto.setPassword(domain.getPassword());
            dto.setAccountLocked(domain.getAccountLocked());
            return dto;
        }catch(NullPointerException exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        }
    }

    @Override
    protected UserDomain convertDtoToDomain(UserDTO dto) {
        try {
            final UserDomain domain = new UserDomain();
            domain.setName(dto.getName());
            domain.setCourse(dto.getCourse());
            domain.setEmail(dto.getEmail());
            domain.setPhone(dto.getPhone());
            domain.setSemester(dto.getSemester());
            domain.setAccountLocked(dto.getAccountLocked());
            domain.setPassword(dto.getPassword());
            return domain;
        }catch(NullPointerException exc) {
          throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        }
    }
    @Override
    public UserDTO save(UserDTO dto) {

        try {
            final UserDomain domain = convertDtoToDomain(dto);
            final UserDomain UserDomain = userDao.save(domain);
            UserDTO UserDTO = convertDomainToDto(UserDomain);
            return UserDTO;

        }catch (InvalidDataAccessApiUsageException exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        }
    }

    @Override
    public UserDTO getById(Integer id) {
        return null;
    }

    @Override
    public UserResult getAll(Pageable pageable) {
        try{
            final Page<UserDomain> list =  userDao.findAll(pageable);
            final List<UserDTO> dtos= new ArrayList<UserDTO>();
            for(UserDomain domain : list){
                UserDTO UserDTO = convertDomainToDto(domain);
                dtos.add(UserDTO);
            }
            UserResult UserResult =new UserResult();
            UserResult.setUsers(dtos);
            return UserResult;

        }catch (ArrayIndexOutOfBoundsException exc){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,exc.getMessage());
        }
    }

    @Override
    public UserResult find(String search, Pageable pageable) {
        return null;
    }

    @Override
    public UserDTO delete(Integer id) {
        return null;
    }

    @Override
    public UserResult find(String search, java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public UserResult getCount() {
        return null;
    }
}
