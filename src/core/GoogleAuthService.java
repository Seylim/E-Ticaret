package core;

public interface GoogleAuthService {
    void Login(String email,String password);
    void Register (int id, String firstName, String lastName, String email, String password);
}
