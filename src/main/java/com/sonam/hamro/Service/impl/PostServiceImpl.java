package com.sonam.hamro.Service.impl;

import com.sonam.hamro.Repository.PostRepository;
import com.sonam.hamro.Service.PostService;
import com.sonam.hamro.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Posts savePost(Posts posts) {
        return postRepository.save(posts);
    }
}
