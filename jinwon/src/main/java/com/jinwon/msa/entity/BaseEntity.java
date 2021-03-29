package com.jinwon.msa.entity;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public abstract class BaseEntity {
    @Column(name = "modify_dt")
    private LocalDateTime modifyDt;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @PrePersist
    public void registeredAt() {
        this.regDt = LocalDateTime.now();
    }

    @PreUpdate
    public void modifiedAt(){
        this.modifyDt = LocalDateTime.now();
    }
}
