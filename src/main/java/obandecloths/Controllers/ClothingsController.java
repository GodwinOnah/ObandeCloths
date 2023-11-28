package obandecloths.Controllers;
import obandecloths.Clothings;
import obandecloths.ClothingsRepo;
import obandecloths.bucket.BucketName;
import obandecloths.files.Files;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
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
    public final ClothingsRepo clothingsRepo;
    public final Files files;

    public ClothingsController (ClothingsRepo clothingsRepo, Files files) {

        this.clothingsRepo = clothingsRepo;
        this.files = files;
    }



    @GetMapping
    public List<Clothings> getClothings(){

        return clothingsRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Clothings> getByIdClothings(@PathVariable("id") Integer id){

        return Optional.ofNullable(clothingsRepo.findById(id).orElseThrow(RuntimeException::new));
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
        clothingsRepo.save(clothings);
    }

    @PostMapping(
            path = "{ClothPictureId}/images/Downloads",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadClothingsImage(@PathVariable Integer clothId , @RequestParam("file") MultipartFile file)
            throws URISyntaxException
    {
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file ["+file.getSize()+"]");
        }

        if(Arrays.asList(IMAGE_JPEG.getType(),IMAGE_PNG.getType(),IMAGE_GIF.getType()).contains(file.getContentType())){
            throw new IllegalStateException("Cannot upload none image file");
        }

        if(!clothingsRepo.existsById(clothId)){
            throw new IllegalStateException("Cloth does not exist");
        };

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length",String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(),clothId);
        String fileName = String.format("%s-%s",file.getName(),UUID.randomUUID());
        try{ files.saveFiles(path,fileName, Optional.of(metadata),file.getInputStream());}
        catch (IOException e){
            throw new IllegalStateException(e);

        }

    }

    @DeleteMapping("{id}")
    public void deleteClothings(@PathVariable("id") Integer id){
        clothingsRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateClothings(@PathVariable("id") Integer id,@RequestBody NewRequest newRequest){

        Clothings clothings = clothingsRepo.findById(id).orElseThrow(RuntimeException::new);
        clothings.setClothName(newRequest.clothName);
        clothings.setClothPictureId(newRequest.clothPictureId);
        clothings.setClothPrice(newRequest.clothPrice);
        clothingsRepo.save(clothings);
    }
}
