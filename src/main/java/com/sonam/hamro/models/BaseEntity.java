package com.sonam.hamro.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

public class BaseEntity<PK extends Serializable> extends AbstractPersistable<PK> {
    @Override
    protected void setId(PK id) {
        super.setId(id);
    }
}
