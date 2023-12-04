package obandecloths.Services;

import obandecloths.Repositories.SignupRepo;
import obandecloths.UserX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class SignupService {

    private final SignupRepo signupRepo;

    @Autowired
    public SignupService(SignupRepo signupRepo) {
        this.signupRepo = signupRepo;
    }

    public boolean addUser(UserX user)
            throws URISyntaxException {
        signupRepo.save(user);
        return true;
    }

    public List<UserX> getUser() {
        return signupRepo.findAll();
    }

    public Optional<UserX> getUserById(Integer id) {
        return  Optional.ofNullable(signupRepo.findById(id).orElseThrow(RuntimeException::new));
    }


    public UserX findByEmail(String email) {
        return signupRepo.findByEmail(email);
    };

    public UserX findByPassword(String password) {
        return signupRepo.findByPassword(password);
    }

    ;
}