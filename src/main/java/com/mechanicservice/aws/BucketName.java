package com.mechanicservice.aws;

public enum BucketName {
    PROFILE_IMAGE("carserviceimagesbucket");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
