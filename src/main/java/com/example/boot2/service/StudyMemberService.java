package com.example.boot2.service;

import com.example.boot2.comm.Cm_encrypt;
import com.example.boot2.entity.Study_member;
import com.example.boot2.repository.StudyMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    //양방향 키 application에 저장
    @Value("${encrypt.key16}")
    private String strKey16;


    //전체 row select
    public List<Study_member> doSelectAll() throws Exception {
        Cm_encrypt cmEncrypt = new Cm_encrypt();
        //String strKey16="ABCdefg123456plm";

        List<Study_member> list = studyMemberRepo.findAll();

        /* 복호화 */
        for(Study_member study_member : list){
            study_member.setEmail(cmEncrypt.decryptAes(study_member.getEmail(), strKey16));
        }

        return list;
    }

    //one row select
    public Study_member doSelectOne(int key_id){
        return studyMemberRepo.findById(key_id).get();
    }

    /**
     * 아이디로 조회
     * @param strLoginId
     * @throws Exception
     */
    public Study_member doSelectLoginId(String strLoginId){
        return studyMemberRepo.findByLoginId(strLoginId);
    }


    //insert
    public void doInsert(Study_member study_member ) throws Exception {
        Cm_encrypt cmEncrypt = new Cm_encrypt();
        //String strKey16="ABCdefg123456plm";


        study_member.setPassword(cmEncrypt.encryptSha256(study_member.getPassword()));
        study_member.setEmail(cmEncrypt.encryptAes(study_member.getEmail(),strKey16));

        studyMemberRepo.save(study_member);
    }

    //update
    public void doUpdate(Study_member study_member){
        studyMemberRepo.save(study_member);
    }

    //delete
    public void doDelete(int key_id){
        studyMemberRepo.deleteById(key_id);
    }
}
