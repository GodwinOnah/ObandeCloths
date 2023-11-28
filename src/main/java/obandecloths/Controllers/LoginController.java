package obandecloths.Controllers;

import obandecloths.Clothings;
import obandecloths.SignupRepo;
import obandecloths.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/login")
@CrossOrigin("*")
public class LoginController {
    public final SignupRepo signupRepo;

    public LoginController(SignupRepo signupRepo) {
        this.signupRepo = signupRepo;
    }

    record NewRequest(
            String Email,
            String Password
    ){};

    @PostMapping
    public boolean loginUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
        User user = new User();
        boolean emailExist = signupRepo.existsByEmail(newRequest.Email);
        boolean passwordExist = signupRepo.existsByPassword(newRequest.Password);

        if(emailExist && passwordExist){
            return true;
        }
        return false;
    }
};

