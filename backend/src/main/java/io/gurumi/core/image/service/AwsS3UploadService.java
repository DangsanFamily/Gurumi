package io.gurumi.core.image.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;


@Component

public class AwsS3UploadService implements ImageService{

    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public AwsS3UploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }


    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        File uploadFile = convert(file)
                .orElseThrow(() -> new IllegalArgumentException("File convert Error!!"));
        return upload(uploadFile, "/test");
    }

    public String upload(File uploadFile, String filePath) {
        String fileName = filePath + "/" + UUID.randomUUID() + uploadFile.getName();
        String uploadImageUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    public void removeNewFile(File removeFile) {
        if(removeFile.delete()){
            System.out.println("File delete success!!");
            return;
        }
        System.out.println("File delete fail!!");
    }

    public String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }
    public Optional<File> convert(MultipartFile file) throws IOException{

        ClassPathResource resource = new ClassPathResource("static/");
        Path path = Paths.get(resource.getURI()).toAbsolutePath();

        UUID uuid = UUID.randomUUID();


        System.out.println("hi here1");

        File convertFile = new File(path.toString()+"/"+uuid.toString()+ file.getOriginalFilename());
        System.out.println("hi here2");
        System.out.println(convertFile);

        if(convertFile.createNewFile()){
            System.out.println("hi here3");
            try(FileOutputStream fos = new FileOutputStream(convertFile)){
                System.out.println("hi here4");
                fos.write(file.getBytes());
                System.out.println("hi here5");
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }


    @Override
    public String makeUrlImage(String name) {
        return null;
    }

    @Override
    public void deleteImage() {

    }

//    @Override
//    public String uploadFiles(MultipartFile file, String dirName) throws IOException {
//        return null;
//    }
}