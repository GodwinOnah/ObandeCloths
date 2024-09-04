package obandecloths.bucket;

public enum BucketName {
    PROFILE_IMAGE("godwinobande-1");
    public final String bucketName;
    BucketName(String bucketName) {

        this.bucketName = bucketName;
    }
    public String getBucketName() {

        return bucketName;
    }

}
