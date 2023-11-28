package obandecloths;

import org.springframework.data.jpa.repository.JpaRepository;
    public interface SignupRepo extends JpaRepository<User,Integer> {
        public boolean existsByEmail(String email);
        public boolean existsByPassword(String password);
    }

