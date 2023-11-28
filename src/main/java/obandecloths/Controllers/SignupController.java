package obandecloths.Controllers;

import obandecloths.Services.SignupService;
import obandecloths.User;
import obandecloths.Repositories.SignupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@SpringBootApplication
@RestController
@RequestMapping("api/signup")
@CrossOrigin("*")
public class SignupController {

private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService= signupService;
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
    public String addUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
        User emailExist = signupService.findByEmail(newRequest.Email);
        if(emailExist!=null) return "Email already exist";
        User user = new User();
        user.setFirstName(newRequest.FirstName);
        user.setLastName(newRequest.LastName);
        user.setEmail(newRequest.Email);
        user.setAddress(newRequest.Address);
        user.setPhone(newRequest.Phone);
        user.setPassword(newRequest.Password);

        boolean success = signupService.addUser(user);

        if(success) return "Registered successfully";

        return "Not registered";


    }


}
