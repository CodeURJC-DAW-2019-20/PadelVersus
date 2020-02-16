package com.example.padelversus;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService implements WebMvcConfigurer {


    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + FILES_FOLDER.toAbsolutePath().toString() + "/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    private Path createFilePath(long id, Path folder) {
        return folder.resolve("image-" + id + ".jpg");
    }

    public String saveImage(String folderName, long id, BufferedImage image) throws IOException {

        Path folder = FILES_FOLDER.resolve(folderName);

        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }

        Path newFile = createFilePath(id, folder);

        ImageIO.write(image, "jpg", newFile.toFile());
        return newFile.toString();
    }



}