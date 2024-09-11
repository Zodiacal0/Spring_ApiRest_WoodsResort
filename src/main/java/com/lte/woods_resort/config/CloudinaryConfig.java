package com.lte.woods_resort.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dygm69wqw",
            "api_key", "224317176964494",
            "api_secret", "zspSxLu05nZsSUdG1T-2mtUJN8w"
        ));
    }
}
