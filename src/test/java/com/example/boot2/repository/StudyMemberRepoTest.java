package com.example.boot2.repository;

import com.example.boot2.entity.Study_member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest

class StudyMemberRepoTest {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    @Test
    void findByLoginId() {
        Study_member study_member = studyMemberRepo.findByLoginId("id4");

        System.out.println("로그인 id가 id4인 멤버는:" + study_member);

    }
}