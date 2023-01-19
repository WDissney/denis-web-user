package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao user) {
        this.userDao = user;
    }
    @Override
    public List<User> getAllUsers(){
        return userDao.getAll();
    }
    @Override
    @Transactional
    public void removeUser(Long id){
        userDao.removeUser(id);
    }
    @Override
    @Transactional
    public void addUser(User user){
        userDao.addUser(user);
    }
    @Override
    public User getUserId(Long id){
       return userDao.getUserId(id);
    }
    @Override
    @Transactional
    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
