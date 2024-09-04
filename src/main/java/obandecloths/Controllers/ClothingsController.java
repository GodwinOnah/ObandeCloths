package obandecloths.Controllers;
import obandecloths.Clothings;
import obandecloths.Services.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("api/clothings")
@CrossOrigin(origins="http://localhost:3000")

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
            Integer clothPrice
    ){};

    @PostMapping
    public String addClothings(@RequestBody NewRequest newRequest)
            throws URISyntaxException {
        Clothings clothings = new Clothings();
        clothings.setClothName(newRequest.clothName);
        clothings.setClothPrice(newRequest.clothPrice);
        boolean added = clothingService.addClothings(clothings);
        if(added) return "Item added successfully";
        return "Item not added";
    }

    @PostMapping(
            path = "{clothId}/images/uploads",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadClothingsImage(@PathVariable("clothId") Integer clothId,
                                     @RequestParam("file") MultipartFile file)
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
    public boolean updateClothings(@PathVariable("id") Integer id,
                                   @RequestBody NewRequest newRequest){
        Clothings clothings = clothingService.findClothings(id);
        clothings.setClothName(newRequest.clothName);
        clothings.setClothPrice(newRequest.clothPrice);
        clothingService.updateClothings(id,clothings);
        return true;
    }
}
