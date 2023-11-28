package obandecloths.Services;

import obandecloths.Repositories.SignupRepo;
import obandecloths.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;
@Service
public class SignupService {

    public final SignupRepo signupRepo;

    @Autowired
    public SignupService(SignupRepo signupRepo) {
        this.signupRepo = signupRepo;
    }

    public boolean addUser(User user)
            throws URISyntaxException {
        signupRepo.save(user);
        return true;
    }

    public User findByEmail(String Email) {
        return signupRepo.findByEmail(Email);
    };

    public User findByPassword(String Password) {
        return signupRepo.findByPassword(Password);
    }

    ;
}