package com.fonyou.exam.examapp.controller;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.DTO.RegisterStudentDTO;
import com.fonyou.exam.examapp.caseuse.StudentCaseUse;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    private StudentCaseUse studentCaseUse;
    @PostMapping("/student")
    public ResponseEntity<Student> register(@RequestBody RegisterStudentDTO registerStudentDTO){
    Student student=this.studentCaseUse.register(registerStudentDTO);
    if(student==null)
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
