package com.example.registration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account implements Serializable {

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    private Long id;

    @Id
    //    @Column(nullable = false, unique = true)
    private String username;

    //    @Column(nullable = false)
    @Transient
    private String password;

    //    @Enumerated(EnumType.STRING)
    //    @Column(nullable = false)
    @Transient
    private AccountType accountType;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createTime;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updateTime;
}
