package com.Invitemee.Invitemee.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class FirebaseService {

    public List<String> uploadImages(List<MultipartFile> imageFiles, String folderName) throws IOException {
        List<String> imageUrls = new ArrayList<>();
        Bucket bucket = StorageClient.getInstance().bucket();

        for (MultipartFile imageFile : imageFiles) {
            String imageName = folderName + "/" + imageFile.getOriginalFilename();
            InputStream inputStream = imageFile.getInputStream();
            bucket.create(imageName, inputStream, imageFile.getContentType());
            String imageUrl = "https://storage.googleapis.com/" + bucket.getName() + "/" + imageName;
            imageUrls.add(imageUrl);
        }

        return imageUrls;
    }

    public void deleteFolder(String folderName) {
        Bucket bucket = StorageClient.getInstance().bucket();

        List<Blob> blobs = StreamSupport
                .stream(bucket.list(Storage.BlobListOption.prefix(folderName + "/")).iterateAll().spliterator(), false)
                .toList();

        for (Blob blob : blobs) {
            blob.delete();
        }
    }
}
