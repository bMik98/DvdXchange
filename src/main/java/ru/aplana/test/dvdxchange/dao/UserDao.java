package ru.aplana.test.dvdxchange.dao;

import org.springframework.data.repository.CrudRepository;
import ru.aplana.test.dvdxchange.domain.User;

/**
 * DAO для сущности ПОЛЬЗОВАТЕЛЬ
 */
public interface UserDao extends CrudRepository<User, Long>, UserDaoExtension {
    User findByEmail(String email);
}
