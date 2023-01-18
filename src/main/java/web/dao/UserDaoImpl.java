package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
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
        entityManager.persist(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
            entityManager.merge(user);

    }
    @Override
    public User getUserId(Long id){
        return entityManager.find(User.class, id);
    }
}
