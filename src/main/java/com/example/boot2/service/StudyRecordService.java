package com.example.boot2.service;

import com.example.boot2.entity.Study_record;
import com.example.boot2.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepo studyRecordRepo;

    //전체 row select
    public List<Study_record> doSelectAll(){
        //return studyRecordRepo.findJpql();//만든쿼리테스트
        return studyRecordRepo.findAll();
    }

    //one row select
    public Study_record doSelectOne(int key_id){
        return studyRecordRepo.findById(key_id).get();
    }

    //insert
    public void doInsert(Study_record study_record){
        studyRecordRepo.save(study_record);
    }

    //update
    public void doUpdate(Study_record study_record){
        studyRecordRepo.save(study_record);
    }

    //delete
    public void doDelete(int key_id){
        studyRecordRepo.deleteById(key_id);
    }
}
