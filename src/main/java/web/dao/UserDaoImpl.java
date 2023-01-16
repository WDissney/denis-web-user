package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.*;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao{

    final EntityManager entityManager;
    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<User> getAll() {
        return  (List<User>) entityManager.createQuery("from User").getResultList();

    }

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUser(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        try {
            if (!entityManager.getTransaction().isActive())
                entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        }
    }

    public User getUserId(Long id){
        if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        return entityManager.find(User.class, id);
    }
}
