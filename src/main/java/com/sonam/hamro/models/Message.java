package com.sonam.hamro.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message extends BaseEntity<Long> {
    private String message;
    private Long from;
    private Boolean msgType;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "group_id")
    private Group group;
}
