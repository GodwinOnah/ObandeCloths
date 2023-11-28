package obandecloths.Repositories;

import obandecloths.Clothings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ClothingsRepo extends JpaRepository<Clothings,Integer> {}


