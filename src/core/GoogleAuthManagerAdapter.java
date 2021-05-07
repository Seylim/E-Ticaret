package core;

import Google.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements GoogleAuthService {
    @Override
    public void Login(String email, String password) {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.Login(email,password);
    }

    @Override
    public void Register(int id, String firstName, String lastName, String email, String password) {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.Register(email,password);
    }
}
