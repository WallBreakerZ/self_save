package org.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 列举bucket
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create("N0D3X1ATJK7O7ZZQ7TR6", "hvfQR9cclmzCKSnNc0EEWJUN0NKJ3OL3c9YLBBPJ");
        Region region = Region.US_EAST_1;
        S3Client s3 = S3Client.builder()
                .endpointOverride(new URI("http://s3.dns.guazi.com"))
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
        List<Bucket> buckets = s3.listBuckets().buckets();
        for (Bucket bucket : buckets) {
            System.out.println("bucket name: " + bucket.name());
        }
        s3.close();
    }
}