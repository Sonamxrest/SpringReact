package com.sonam.hamro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class RefreshToken extends BaseEntity<Long>{
    public String token;
    public Instant expiration;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;
}
