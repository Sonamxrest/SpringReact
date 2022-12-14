package com.sonam.hamro.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group extends BaseEntity<Long> {
    private Long uidOne;
    private Long uidTwo;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Message> messages;
}
