package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.EmailService;
import business.abstracts.UserService;
import business.abstracts.UserValidService;
import core.utils.BusinessRules;
import entities.concretes.User;

public class AuthManager implements AuthService {

    private UserService userService;
    private UserValidService userValidService;
    private EmailService emailService;

    public AuthManager(UserService userService, UserValidService userValidService, EmailService emailService) {
        this.userService = userService;
        this.userValidService = userValidService;
        this.emailService = emailService;
    }

    @Override
    public void Register(User user) {
        if (!userValidService.validate(user)){
            System.out.println("Validasyon işlemi başarısız.");
            return;
        }
        if (!BusinessRules.Run(checkIfUserExists(user.geteMail()))){
            System.out.println("Bu e posta adresi sisteme kayıtlı.");
            return;
        }

        System.out.println("Kayıt işlemi başarılı. Doğrulama adresi epostanıza gönderilmiştir.");
        emailService.Send(user.geteMail());
        userService.Add(user);
    }

    @Override
    public void Login(String email, String password) {
        User getUser = userService.GetByEmailAndPassword(email,password);

        if (getUser == null){
            System.out.println("Eposta veya parola hatalı!");
            return;
        }

        if (!checkIfUserVerified(getUser)){
            System.out.println("Giriş başarısız. Hesabınız doğrulamadınız.");
            return;
        }

        System.out.println("Hoşgeldiniz " + getUser.getFirstName() + getUser.getLastName());
    }

    private boolean checkIfUserExists(String email) {
        return userService.GetByEmail(email) == null;
    }
    private boolean checkIfUserVerified(User user) {
        return user.isVerified();
    }
}
