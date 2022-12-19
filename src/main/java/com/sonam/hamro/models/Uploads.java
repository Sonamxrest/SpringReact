package com.sonam.hamro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Uploads extends BaseEntity<Long> {
    private String path;
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;
}
