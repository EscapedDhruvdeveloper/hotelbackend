package com.Dhruvs.Hotels.service;

import com.Dhruvs.Hotels.exception.OurException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    @Value("${cloudinary.upload-preset}")
    private String uploadPreset;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile photo) {
        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.asMap(
                    "upload_preset", uploadPreset,
                    "folder", "hotel-images"
            ));
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new OurException("Failed to upload image to Cloudinary: " + e.getMessage());
        }
    }
}
