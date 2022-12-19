package com.sonam.hamro.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Posts extends BaseEntity<Long> {
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posts")
    private List<Uploads> uploads;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
