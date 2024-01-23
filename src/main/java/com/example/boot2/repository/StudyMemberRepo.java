package com.example.boot2.repository;

import com.example.boot2.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudyMemberRepo extends JpaRepository<Study_member, Integer> {
    
    //id가 member_id컬럼이고 아래는 login_id컬럼 값으로 찾는 메소드 생성
    Study_member findByLoginId(String loginId);
}
