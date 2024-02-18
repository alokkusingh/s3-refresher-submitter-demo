package com.alok.aws.s3.refresher.demo.submitter;

import com.alok.aws.s3.refresh.submitter.S3RefreshSubmitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class ApplicationConfiguration {

    private final S3Client s3Client = S3Client.builder()
            .region(Region.AP_SOUTH_1)
            .credentialsProvider(ProfileCredentialsProvider.create("yahoo"))
            .build();

    @Bean
    S3RefreshSubmitter s3RefreshSubmitter(@Value("${aws.s3.refresh.bucket-name}") String bucketName) {
        return S3RefreshSubmitter.builder()
                .setBucketName(bucketName)
                .setS3Client(s3Client)
                .build();
    }
}
