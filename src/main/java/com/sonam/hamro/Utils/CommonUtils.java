package com.sonam.hamro.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class CommonUtils {

    public static String uploadAndGetPath(MultipartFile file, String path, String toBe) throws IOException {
        byte[] fb = file.getBytes();
        String os = System.getProperty("os.name");
        String fileName = String.valueOf(toBe + "." + Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1]);
        Path path1 = Paths.get(os.toLowerCase().contains("windows") ? "C:/images/" + path + "/" : "");
        if (!Files.exists(path1)) {
            path1.toFile().mkdirs();
        }
        path1 = Paths.get(path1.toString() + "/" + fileName);
        Files.write(path1, fb);
        return "images/" + path + "/" + fileName;
    }
}
