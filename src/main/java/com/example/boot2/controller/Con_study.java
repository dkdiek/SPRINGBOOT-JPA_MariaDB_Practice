package com.example.boot2.controller;

import com.example.boot2.entity.Study_record;
import com.example.boot2.service.StudyRecordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/study")
public class Con_study {

    @Autowired
    StudyRecordService studyRecordService;
    
    //List 조회
    @GetMapping("/list")
    public String doStudyList(Model model){
        List<Study_record> list =  studyRecordService.doSelectAll();
        model.addAttribute("list",list);
        return "/study/study_list";
    }

    //입력
    @GetMapping("/insert")
    public String doIns() {return "/study/study_ins";}

    //등록하기 실행
    @PostMapping ("/insert_exe")
    public String doInsExe(@ModelAttribute Study_record study_record){
        //study_record.setReg_day(LocalDateTime.now());
        //study_record.setMod_day(LocalDateTime.now());

        studyRecordService.doInsert(study_record);

        return "redirect:/study/list";
    }

    //수정
    @GetMapping("/modify")
    public String doMod(HttpServletRequest request, Model model){
        String strKeyId = request.getParameter("key_id");
        Study_record study_record = studyRecordService.doSelectOne(Integer.parseInt(strKeyId));
        //request.setAttribute("vo_study",study_record);
        model.addAttribute("vo_study",study_record);

        return "/study/study_mod";

    }
    
    //수정하기 실행
    @PostMapping("/modify_exe")
    public String doModExe(@ModelAttribute Study_record study_record){
        //study_record.setReg_day(LocalDateTime.now());
        //study_record.setMod_day(LocalDateTime.now());

        studyRecordService.doUpdate(study_record);

        return "redirect:/study/list";
    }

    //삭제
    @GetMapping("/delete")
    public String doDel(@RequestParam(value = "key_id", defaultValue = "--") String strKeyId){
        studyRecordService.doDelete(Integer.parseInt(strKeyId));
        return "redirect:/study/list";
    }


}
