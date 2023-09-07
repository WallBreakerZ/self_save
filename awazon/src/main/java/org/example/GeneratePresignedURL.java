package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

/**
 * 获取签名的访问链接
 */
public class GeneratePresignedURL {
    public static void main(String[] args) throws URISyntaxException {
        String bucketName = "audio-record-2023-09";
        String keyName = "provider-0/2023-09/202309071139572321372223166.mp3";
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create("N0D3X1ATJK7O7ZZQ7TR6", "hvfQR9cclmzCKSnNc0EEWJUN0NKJ3OL3c9YLBBPJ");
        S3Presigner presigner = S3Presigner.builder()
                .endpointOverride(new URI("http://s3.dns.guazi.com"))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
        GetObjectRequest getObjectRequest =
                GetObjectRequest.builder()
                        .bucket(bucketName)
                        .key(keyName)
                        .build();
        GetObjectPresignRequest getObjectPresignRequest =
                GetObjectPresignRequest.builder()
                        .signatureDuration(Duration.ofMinutes(10))
                        .getObjectRequest(getObjectRequest)
                        .build();
        PresignedGetObjectRequest presignedGetObjectRequest =
                presigner.presignGetObject(getObjectPresignRequest);
        System.out.println("Presigned URL: " + presignedGetObjectRequest.url());
        presigner.close();
    }
}