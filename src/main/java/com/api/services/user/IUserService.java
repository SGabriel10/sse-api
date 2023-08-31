package com.api.services.user;

import com.api.dtos.student.StudentDTO;
import com.api.dtos.student.StudentResult;
import com.api.dtos.user.UserDTO;
import com.api.dtos.user.UserResult;
import com.api.services.base.IBaseService;

import java.awt.print.Pageable;

public interface IUserService extends IBaseService<UserDTO, UserResult>  {

    public UserDTO delete(Integer id);
    public UserResult find(String search, Pageable pageable);
    public UserResult getCount();

}