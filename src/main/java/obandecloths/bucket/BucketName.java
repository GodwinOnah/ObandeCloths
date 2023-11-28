package obandecloths.bucket;

public enum BucketName {
    PROFILE_IMAGE("godwinobande-1");
    BucketName(String bucketName) {

        this.bucketName = bucketName;
    }
    public String getBucketName() {

        return bucketName;
    }
    public final String bucketName;
}
