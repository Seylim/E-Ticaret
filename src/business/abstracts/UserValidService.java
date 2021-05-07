package business.abstracts;

import entities.concretes.User;

public interface UserValidService {
    public boolean validate(User user);
}
