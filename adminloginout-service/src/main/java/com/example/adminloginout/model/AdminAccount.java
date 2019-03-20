package com.example.adminloginout.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    /*@Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Date createTime;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updateTime;*/
}
