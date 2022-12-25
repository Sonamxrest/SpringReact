package com.sonam.hamro.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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
    public static List<String> generateRandom(String name) {
        int a = 1;
        List<String> join = new ArrayList<>();
        List<String> namesArray = Arrays.stream(name.split(",")).map(String::trim).collect(Collectors.toList());
        List<String> names = namesArray.stream().map(String::trim).toList();

        //Collections.shuffle(names);
        Collections.shuffle(namesArray);

        for (int i = 0; i < namesArray.size(); i++) {
            if (namesArray.get(i).equals(names.get(i))) {
                String nna = namesArray.remove(i);
                namesArray.add(nna);
            }
        }
        for (int i = 0; i < namesArray.size(); i++) {
            if (names.get(i).equals(namesArray.get(i))) {
                generateRandom(name);
                break;
            }
            String giftNo = "";
            if(names.get(i).contains("-")){
                a = (i+1);
                giftNo = a+"";
            }else{
                a++;
                giftNo = a+"";
            }
            String giver = names.get(i).split("-").length > 1 ? names.get(i).split("-")[1]: names.get(i);
            String receiver = namesArray.get(i).split("-").length > 1 ? namesArray.get(i).split("-")[1]: namesArray.get(i);
            join.add("" + (giftNo) + ", " + giver + " -> " +receiver);
        }
        return join;

    }

}
