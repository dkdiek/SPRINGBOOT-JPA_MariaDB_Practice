package com.example.boot2.service;

import com.example.boot2.entity.Study_record;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    StudyRecordService studyRecordService;

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .STUDY_DAY("2022.08.23")
                .CONTENTS("Test Insert day")
                .reg_day(LocalDateTime.now())
                .build();

        studyRecordService.doInsert(study_record);
    }

    @Test
    void doUpdate() {
        /* 전체 수정할때
        Study_record study_record = new Study_record();
        study_record.setKey_id(3);
        study_record.setSTUDY_DAY("2022.08.23");
        study_record.setCONTENTS("수정");
        study_record.setReg_day(LocalDateTime.now());*/

        //기존에 값 불러와서 그대로 넣고 contents만 수정
        Study_record study_record = studyRecordService.doSelectOne(3);
        study_record.setCONTENTS("수정3");

        studyRecordService.doUpdate(study_record);
    }

    @Test
    void doDelete() {
        studyRecordService.doDelete(3);
    }
}