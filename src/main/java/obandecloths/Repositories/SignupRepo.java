package obandecloths.Repositories;

import obandecloths.UserX;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface SignupRepo extends JpaRepository<UserX,Integer> {
         UserX findByEmail(String email);
         UserX findByPassword(String password);
    }

