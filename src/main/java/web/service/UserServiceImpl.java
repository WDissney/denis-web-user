package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Component("user")
public class UserServiceImpl {
    final private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao user) {
        this.userDao = user;
    }

    public List<User> getAllUsers(){
        return userDao.getAll();
    }

    public void removeUser(Long id){
        userDao.removeUser(id);
    }

    public void addUser(User user){
        userDao.addUser(user);
    }

    public User getUserId(Long id){
       return userDao.getUserId(id);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
