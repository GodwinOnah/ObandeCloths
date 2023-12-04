package obandecloths.Controllers;

import obandecloths.Clothings;
import obandecloths.Services.SignupService;
import obandecloths.UserX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
            String firstName,
            String lastName,
            String email,
            String address,
            String phone,
            String password
    ){};

    @GetMapping
    public List<UserX> getUsers() {
        return signupService.getUser();
    }

    @GetMapping("{id}")
    public Optional<UserX> getUserById(@PathVariable("id") Integer id) {
        return signupService.getUserById(id);
    }

    @PostMapping
    public  String addUser(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {

        UserX emailExist = signupService.findByEmail(newRequest.email);
        if(emailExist!=null) return "Email already exist";
        UserX user = new UserX();
        user.setFirstName(newRequest.firstName);
        user.setLastName(newRequest.lastName);
        user.setEmail(newRequest.email);
        user.setAddress(newRequest.address);
        user.setPhone(newRequest.phone);
        user.setPassword(newRequest.password);

        boolean success = signupService.addUser(user);

        if(success) return "Registered successfully";

        return "Not registered";
    }
}
