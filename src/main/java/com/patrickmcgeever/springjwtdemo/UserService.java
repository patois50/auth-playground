package com.patrickmcgeever.springjwtdemo;

import com.patrickmcgeever.springjwtdemo.dao.HibernateDAO;
import com.patrickmcgeever.springjwtdemo.domain.User;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
    private @Autowired HibernateDAO<User> userDAO;

    @Transactional(rollbackFor = Exception.class)
    public void saveDto(@NotNull User user) {
        User newUser = user.withPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.persist(newUser);
    }
}
