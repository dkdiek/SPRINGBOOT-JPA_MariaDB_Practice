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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key_id;
    private String STUDY_DAY;
    private String CONTENTS;
    
    //DB의 시간이 들어가도록, JPA는 값이 없으면 NULL로 들어가서 이 부분을 막고 DB의 DEFAULT값이 들어가도록 설정
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="reg_day", updatable = false)
    private LocalDateTime reg_day;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name="mod_day")
    private LocalDateTime mod_day;

    //두개 테이블 Join
    @ManyToOne
    @JoinColumn(name="member_id") // 공통 컬럼
    private Study_member study_member; //Join할 테이블

}
