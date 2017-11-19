package ru.aplana.test.dvdxchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aplana.test.dvdxchange.dao.UserDao;
import ru.aplana.test.dvdxchange.domain.User;

@Service
public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User registerUser(final String userName) {
        final User user = new User();
        user.setLogin(userName);
        user.setName(userName);
        return userDao.save(user);
    }

    public long countUsers() {
        return userDao.numberOf();
    }
}
