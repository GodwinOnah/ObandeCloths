package obandecloths.Controllers;
import obandecloths.Clothings;
import obandecloths.Repositories.ClothingsRepo;
import obandecloths.Services.ClothingService;
import obandecloths.bucket.BucketName;
import obandecloths.files.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import static org.springframework.http.MediaType.*;

@SpringBootApplication
@RestController
@RequestMapping("api/clothings")
@CrossOrigin("*")
public class ClothingsController {
    public final ClothingService clothingService;


    @Autowired
    public ClothingsController (ClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @GetMapping
    public List<Clothings> getClothings(){
        return clothingService.getClothings();
    }

    @GetMapping("{id}")
    public Optional<Clothings> getByIdClothings(@PathVariable("id") Integer id){
        return clothingService.getByIdClothings(id);
    }

    record NewRequest(
            String clothName,
            Integer clothPrice,
            String clothPictureId
    ){
    };

    @PostMapping
    public void addClothings(@RequestBody NewRequest newRequest)
            throws URISyntaxException
    {
        Clothings clothings = new Clothings();
        clothings.setClothName(newRequest.clothName);
        clothings.setClothPictureId(newRequest.clothPictureId);
        clothings.setClothPrice(newRequest.clothPrice);

       clothingService.addClothings(clothings);
    }

    @PostMapping(
            path = "{ClothPictureId}/images/Downloads",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadClothingsImage(@PathVariable Integer clothId , @RequestParam("file") MultipartFile file)
            throws URISyntaxException
    {
        clothingService.uploadClothingsImage(clothId,file);

    }

    @DeleteMapping("{id}")
    public boolean deleteClothings(@PathVariable("id") Integer id){
        clothingService.deleteClothings(id);
        return true;
    }

    @PutMapping("{id}")
    public boolean updateClothings(@PathVariable("id") Integer id,@RequestBody NewRequest newRequest){

        Clothings clothings = clothingService.findClothings(id);
        clothings.setClothName(newRequest.clothName);
        clothings.setClothPictureId(newRequest.clothPictureId);
        clothings.setClothPrice(newRequest.clothPrice);

        clothingService.updateClothings(id,clothings);
        return true;
    }
}
