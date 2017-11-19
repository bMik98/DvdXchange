package ru.aplana.test.dvdxchange.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aplana.test.dvdxchange.dao.UserDaoExtension;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class UserDaoImpl implements UserDaoExtension {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public long numberOf() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        return 0;
    }
}
