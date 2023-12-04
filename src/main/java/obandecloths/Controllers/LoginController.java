package obandecloths.Controllers;

import obandecloths.Services.SignupService;
import obandecloths.UserX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/login")
@CrossOrigin("*")
public class LoginController {

   private final SignupService signupService;

    @Autowired
    public LoginController(SignupService signupService) {
        this.signupService = signupService;
    }

    record NewRequest(
            String email,
            String password
    ){};

    @PostMapping
    public boolean loginUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
       UserX user = signupService.findByEmail(newRequest.email);
        if(user.getPassword().equals(newRequest.password)){
            return true;
        }
        return false;
    }
};

