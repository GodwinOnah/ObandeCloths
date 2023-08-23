package obandecloths.AWSConfiguration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSS3Config {
    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAWT5JFNMPOWRHPPPI",
                "IBxahyC2nLDE40EPwUKfJgE4BKNNaz2LK4jgkAX/"
        );

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(
                new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
