package obandecloths.Controllers;

import obandecloths.Repositories.SignupRepo;
import obandecloths.Services.SignupService;
import obandecloths.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@SpringBootApplication
@RestController
@RequestMapping("api/login")
@CrossOrigin("*")
public class LoginController {
    public final SignupService signupService;

    @Autowired
    public LoginController(SignupService signupService) {
        this.signupService = signupService;
    }

    record NewRequest(
            String Email,
            String Password
    ){};

    @PostMapping
    public boolean loginUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
       User emailExist = signupService.findByEmail(newRequest.Email);
        User passwordExist = signupService.findByPassword(newRequest.Password);

        if(emailExist!=null && passwordExist!=null){
            return true;
        }
        return false;
    }
};

