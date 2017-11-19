package ru.aplana.test.dvdxchange.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.aplana.test.dvdxchange.dao.UserDaoExtension;
import ru.aplana.test.dvdxchange.domain.Disk;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class UserDaoImpl implements UserDaoExtension {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public long numberOfDisks() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        return 0;
    }
}
