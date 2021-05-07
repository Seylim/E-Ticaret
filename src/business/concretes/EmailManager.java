package business.concretes;

import business.abstracts.EmailService;

public class EmailManager implements EmailService {
    @Override
    public void Send (String to) {
        System.out.println(to + " Adresine doğrulama e postası gönderildi.");
    }
}
