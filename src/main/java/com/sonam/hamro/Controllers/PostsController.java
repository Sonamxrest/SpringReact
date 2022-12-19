package com.sonam.hamro.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonam.hamro.Service.PostService;
import com.sonam.hamro.Utils.CommonUtils;
import com.sonam.hamro.models.Posts;
import com.sonam.hamro.models.Uploads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/post")
public class PostsController {

    @Autowired
    private PostService postService;


    @PostMapping("/save")
    public ResponseEntity<?> savePost(@RequestParam(name = "file", required = false) List<MultipartFile> files, @RequestParam("post") String post) throws JsonProcessingException {
        List<String> strings = files.parallelStream().map(d -> {
            try {
                return CommonUtils.uploadAndGetPath(d, "post", "post");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        Posts posts = new ObjectMapper().readValue(post, Posts.class);
        List<Uploads > uploads = strings.stream().map(d -> {
            return Uploads.builder().path(d).build();
        }).toList();
        posts.setUploads(uploads);
        return new ResponseEntity<>(postService.savePost(posts), HttpStatus.OK);
    }


}
