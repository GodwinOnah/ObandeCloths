package obandecloths.files;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    private final AmazonS3 s3;

    public void saveFiles(
            String path,
            String fileName,
            Optional<Map<String, String>> metadata,
            InputStream inputStream
    ){
        ObjectMetadata objectMetadata = new ObjectMetadata();
        metadata.ifPresent(map->{
            if(!map.isEmpty()){
        map.forEach(objectMetadata::addUserMetadata);}}
                );
        try{
                s3.putObject(path,fileName,inputStream,objectMetadata);
        }
        catch(AmazonServiceException e){
            throw new IllegalStateException("Saving files to Amazon S3 failed",e);
        }
    }
}
