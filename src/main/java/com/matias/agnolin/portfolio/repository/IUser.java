package com.matias.agnolin.portfolio.repository;

import com.matias.agnolin.portfolio.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<UserEntity,Long> {

    public UserEntity findByUsername(String username);
}
