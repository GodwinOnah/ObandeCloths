package obandecloths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/clothings")
@CrossOrigin("*")
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

    @GetMapping("{id}")
    public Optional<Clothings> getByIdClothings(@PathVariable("id") Integer id){
        return clothingsRepo.findById(id);
    }

    record NewRequest(
        String clothName,
        Integer clothPrice
    ){
    };

    @PostMapping(
            path = "images/Downloads",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void addClothings(@RequestBody NewRequest newRequest, @RequestParam("file") MultipartFile file){
        Clothings clothings = new Clothings();

        clothings.setClothName(newRequest.clothName);
        clothings.setClothPicture(file.toString());
        clothings.setClothPrice(newRequest.clothPrice);

        clothingsRepo.save(clothings);
    }

    @DeleteMapping("{id}")
    public void deleteClothings(@PathVariable("id") Integer id){
        clothingsRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateClothings(@PathVariable("id") Integer id,@RequestBody NewRequest newRequest){

//        Optional<Clothings> clothings = clothingsRepo.findById(id);
//        clothings.setClothName(newRequest.clothName);
//        clothings.setClothPicture(newRequest.clothPicture);
//        clothings.setClothPrice(newRequest.clothPrice);
//
//        clothingsRepo.save(clothings);
//        clothingsRepo.findById(id).clothings);
    }
}

