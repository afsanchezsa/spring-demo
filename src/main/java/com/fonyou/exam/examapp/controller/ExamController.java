package com.fonyou.exam.examapp.controller;

import com.fonyou.exam.examapp.DTO.AssignExamDTO;
import com.fonyou.exam.examapp.DTO.FillExamDTO;
import com.fonyou.exam.examapp.DTO.QualificationDTO;
import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.caseuse.AssignmentCaseUse;
import com.fonyou.exam.examapp.caseuse.ExamCaseUse;
import com.fonyou.exam.examapp.entity.Assignment;
import com.fonyou.exam.examapp.entity.Exam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ExamController {
        private ExamCaseUse examCaseUse;
        private AssignmentCaseUse assignmentCaseUse;

        @PostMapping("/exam")
        public ResponseEntity<Exam> register(@RequestBody RegisterExamDTO registerExamDTO){
            Exam registeredExam=this.examCaseUse.register(registerExamDTO);
            if(registeredExam==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(registeredExam, HttpStatus.CREATED);
        }

        @PostMapping("/exam/assign")
        public ResponseEntity<Assignment>assignExam(@RequestBody  AssignExamDTO assignExamDTO){
            Assignment assignment=this.assignmentCaseUse.register(assignExamDTO);
            if(assignment==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(assignment,HttpStatus.CREATED);
        }

        @PostMapping("exam/fill")
        public ResponseEntity<Void> fillExam(@RequestBody FillExamDTO fillExamDTO){
            this.examCaseUse.fillExam(fillExamDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        @GetMapping("/exam/qualify/{assignmentId}")
        public ResponseEntity<QualificationDTO>qualifyExam(@PathVariable Long assignmentId){
            QualificationDTO response=this.examCaseUse.qualifyExam(assignmentId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

}
