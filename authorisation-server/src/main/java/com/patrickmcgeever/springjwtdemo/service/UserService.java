package com.patrickmcgeever.springjwtdemo.service;

import com.patrickmcgeever.springjwtdemo.dao.HibernateDAO;
import com.patrickmcgeever.springjwtdemo.domain.User;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
    private @Autowired HibernateDAO<User> userDAO;

    @Transactional(rollbackFor = Exception.class)
    public void saveDto(@NotNull User user) {
        User newUser = user.withPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.persist(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Loading a user is not implemented yet!");
    }
}
