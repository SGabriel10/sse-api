package com.api.daos.user;

import com.api.domains.user.UserDomain;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends PagingAndSortingRepository<UserDomain, Integer> {
}
