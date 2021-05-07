import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.EmailManager;
import business.concretes.UserManager;
import business.concretes.UserValidManager;
import core.GoogleAuthService;
import core.GoogleAuthManagerAdapter;
import dataAccess.concretes.DatabaseDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new DatabaseDao());
        AuthService authService = new AuthManager(userService,new UserValidManager(),new EmailManager());

        User user = new User(1,"Emre Kaan","Seylim","seylimemre@gmail.com","1234",false);

        authService.Register(user);

        authService.Login("seylimemre@gmail.com", "1234");

        GoogleAuthService googleAuthService = new GoogleAuthManagerAdapter();
        googleAuthService.Register(2,"Emre Kaan","Seylim","seylimemre@gmail.com","1234");
        googleAuthService.Login("seylimemre@gmail.com","1234");
    }
}
