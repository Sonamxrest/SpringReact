package com.sonam.hamro.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group extends BaseEntity<Long> {
    private Long uidOne;
    private Long uidTwo;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("group")
    private List<Message> messages;
}
