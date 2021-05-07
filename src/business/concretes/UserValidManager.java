package business.concretes;

import business.abstracts.UserValidService;
import core.utils.ValidationRules;
import entities.concretes.User;

import java.util.regex.Pattern;

public class UserValidManager implements UserValidService {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean validate(User user) {
        boolean result = ValidationRules.Run(
                eMailFormatValid(user.geteMail()),
                passwordLengthValid(user.getPassword()),
                firstNameLengthValid(user.getFirstName()),
                lastNameLengthValid(user.getLastName()),
                allFieldsFilled(user.getFirstName(), user.getLastName(), user.geteMail(), user.getPassword())
        );
        return result;
    }

    private boolean eMailFormatValid(String email){
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }

    private boolean passwordLengthValid(String password) {
        return password.length() > 6;
    }
    private boolean firstNameLengthValid(String firstName) {
        return firstName.length() > 2;
    }
    private boolean lastNameLengthValid(String lastName) {
        return lastName.length() > 2;
    }
    private boolean allFieldsFilled(String firstName,String lastName,String email, String password) {
        if(firstName == null || lastName == null || email == null || password == null) {
            return false;
        }return true;
    }
}
