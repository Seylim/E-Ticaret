package business.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserService {
    void Add(User user);
    void Update(User user);
    void Delete(User user);
    User GetByEmail(String email);
    User GetByEmailAndPassword(String email, String password);
    User GetUser(int id);
    List<User> getAll();
}
