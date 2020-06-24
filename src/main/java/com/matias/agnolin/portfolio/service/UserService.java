package com.matias.agnolin.portfolio.service;

import com.matias.agnolin.portfolio.model.UserEntity;
import com.matias.agnolin.portfolio.repository.IUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    Logger LOGGER =
            LoggerFactory.getLogger(UserService.class);
    @Autowired
    IUser userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUsername(s);

        if(user == null){
            LOGGER.error("LOGIN : User not found {}",s);
            throw new UsernameNotFoundException("LOGIN : User not found "+s);
        }

        List<GrantedAuthority> roles = user.getRoles()
                .stream()
                .map(e-> new SimpleGrantedAuthority(e.getName()))
                .collect(Collectors.toList());

        return new User(user.getUsername(),user.getPassword(),user.isEnabled()
                ,true,true,true,roles);
    }
}
