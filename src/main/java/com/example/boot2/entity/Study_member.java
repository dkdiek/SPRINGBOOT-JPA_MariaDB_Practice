package com.example.boot2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="STUDY_MEMBER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study_member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private int memberId;

    @Column(name="login_id")
    private String loginId;

    private String password;

    private String name;

    private String email;

    private String role;

    //DB의 시간이 들어가도록, JPA는 값이 없으면 NULL로 들어가서 이 부분을 막고 DB의 DEFAULT값을 설정
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="reg_day", updatable = false)
    private LocalDateTime reg_day;



}
