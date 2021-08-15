package com.mechanicservice.aws;

public enum BucketName {
    PROFILE_IMAGE("car-service-bucket-images");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
