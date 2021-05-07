package business.abstracts;

import entities.concretes.User;

public interface AuthService {
    void Register(User user);
    void Login(String email, String password);
}
