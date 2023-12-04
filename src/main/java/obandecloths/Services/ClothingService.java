package obandecloths.Services;

import obandecloths.Clothings;
import obandecloths.Controllers.ClothingsController;
import obandecloths.Repositories.ClothingsRepo;
import obandecloths.bucket.BucketName;
import obandecloths.files.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.springframework.http.MediaType.*;
@Service
public class ClothingService {
    private final ClothingsRepo clothingsRepo;
    private final Files files;
    @Autowired
    public ClothingService(ClothingsRepo clothingsRepo, Files files) {
        this.files = files;
        this.clothingsRepo = clothingsRepo;
    }

    public List<Clothings> getClothings(){
        return clothingsRepo.findAll();
    }

    public Optional<Clothings> getByIdClothings(Integer id){

        return Optional.ofNullable(clothingsRepo.findById(id).orElseThrow(RuntimeException::new));
    }


    public boolean addClothings(Clothings clothings)
            throws URISyntaxException
    {
        clothingsRepo.save(clothings);
        return true;
    }

    public void uploadClothingsImage(Integer clothId
            ,  MultipartFile file)
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
        try{
            files.saveFiles(path,fileName, Optional.of(metadata),file.getInputStream());
        }
        catch (IOException e){
            throw new IllegalStateException(e);

        }
    }


    public boolean deleteClothings( Integer id){
        clothingsRepo.deleteById(id);
        return true;
    }

    public boolean updateClothings(Integer id, Clothings clothings){
        clothingsRepo.save(clothings);
        return  true;
    }

    public Clothings findClothings(Integer id){
        return clothingsRepo.findById(id).orElseThrow(RuntimeException::new);
    }

}
