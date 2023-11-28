package obandecloths.Controllers;

import obandecloths.User;
import obandecloths.SignupRepo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@SpringBootApplication
@RestController
@RequestMapping("api/signup")
@CrossOrigin("*")
public class SignupController {
    public final SignupRepo signupRepo;
    public SignupController(SignupRepo signupRepo) {
        this.signupRepo = signupRepo;
    }

    record NewRequest(
            String FirstName,
            String LastName,
            String Email,
            String Address,
            String Phone,
            String Password
    ){};

    @PostMapping
    public boolean addUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
        User signup = new User();
        signup.setFirstName(newRequest.FirstName);
        signup.setLastName(newRequest.LastName);
        signup.setEmail(newRequest.Email);
        signup.setAddress(newRequest.Address);
        signup.setPhone(newRequest.Phone);
        signup.setPassword(newRequest.Password);
        signupRepo.save(signup);
        return true;
    }
}
