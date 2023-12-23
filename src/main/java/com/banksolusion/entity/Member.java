package com.banksolusion.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "members")
public class Member implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @NaturalId
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 4, message = "패스워드 4자리 이상 입력해주세요")
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String ssn;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String Address1;

    @NotEmpty
    private String Address2;

    @NotEmpty
    private int type;

    @NotEmpty
    private int status;

    @NotEmpty
    private String role;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;
}
