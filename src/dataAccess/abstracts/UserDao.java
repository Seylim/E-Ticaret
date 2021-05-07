package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserDao {
    void Add(User user);
    void Update(User user);
    void Delete(User user);
    User GetByEmail(String email);
    User GetByEmailAndPassword(String email, String password);
    User get(int id);
    List<User> getAll();
}
