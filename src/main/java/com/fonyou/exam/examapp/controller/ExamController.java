package com.fonyou.exam.examapp.controller;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.caseuse.ExamCaseUse;
import com.fonyou.exam.examapp.entity.Exam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ExamController {
        private ExamCaseUse examCaseUse;

        @PostMapping("/exam")
        public ResponseEntity<Exam> register(@RequestBody RegisterExamDTO registerExamDTO){
            Exam registeredExam=this.examCaseUse.register(registerExamDTO);
            if(registeredExam==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(registeredExam, HttpStatus.CREATED);
        }

}
