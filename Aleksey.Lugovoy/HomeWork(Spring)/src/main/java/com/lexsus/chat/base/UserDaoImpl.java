package com.lexsus.chat.base;

import com.lexsus.chat.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void remove(UserEntity userEntity) {
         entityManager.remove(userEntity);
    }

    public UserEntity save(UserEntity userEntity) {
        if(userEntity.getCreationTime()==null){
            userEntity.setCreationTime(new Timestamp(System.currentTimeMillis()));
        }
        entityManager.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> getUsers() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
        query.from(UserEntity.class);
        return entityManager.createQuery(query).getResultList();
    }

    public UserEntity findUser(String id) {
        return entityManager.find(UserEntity.class, id);
    }

}
