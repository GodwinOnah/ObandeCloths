package obandecloths;

import jdk.jfr.ContentType;
import obandecloths.Controllers.ClothingsController;
import obandecloths.bucket.BucketName;
import obandecloths.files.Files;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.springframework.http.MediaType.*;
@SpringBootApplication

public class Main {


    public Main() {
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }

}

