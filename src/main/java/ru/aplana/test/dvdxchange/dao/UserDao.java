package ru.aplana.test.dvdxchange.dao;

import org.springframework.data.repository.CrudRepository;
import ru.aplana.test.dvdxchange.domain.User;

public interface UserDao extends CrudRepository<User, Long>, UserDaoExtension {
}
