package obandecloths.Repositories;

import obandecloths.User;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface SignupRepo extends JpaRepository<User,Integer> {
         User findByEmail(String Email);
         User findByPassword(String Password);
    }

