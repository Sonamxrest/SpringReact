package com.sonam.hamro.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Message extends BaseEntity<Long> {
    private String message;
    private Long from;
    private Boolean msgType;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("messages")
    private Group group;
}
