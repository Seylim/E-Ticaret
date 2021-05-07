package business.concretes;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void Add(User user) {
        this.userDao.Add(user);
    }

    @Override
    public void Update(User user) {
        this.userDao.Update(user);
    }

    @Override
    public void Delete(User user) {
        this.userDao.Delete(user);
    }

    @Override
    public User GetByEmail(String email) {
        return this.userDao.GetByEmail(email);
    }

    @Override
    public User GetByEmailAndPassword(String email, String password) {
        return this.userDao.GetByEmailAndPassword(email,password);
    }

    @Override
    public User GetUser(int id) {
        return this.userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }
}
