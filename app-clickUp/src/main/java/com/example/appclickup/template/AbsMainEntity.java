package com.example.appclickup.template;

import com.example.appclickup.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsMainEntity {

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @JoinColumn(updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @JoinColumn()
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;
}