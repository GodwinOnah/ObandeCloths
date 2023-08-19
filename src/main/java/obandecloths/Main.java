package obandecloths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/clothings")
public class Main {

    public final ClothingsRepo clothingsRepo;

    public Main(ClothingsRepo clothingsRepo) {
        this.clothingsRepo = clothingsRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @GetMapping
    public List<Clothings> getClothings(){
        return clothingsRepo.findAll();
    }
}
