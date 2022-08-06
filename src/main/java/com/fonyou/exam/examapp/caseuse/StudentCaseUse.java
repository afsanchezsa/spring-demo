package com.fonyou.exam.examapp.caseuse;

import com.fonyou.exam.examapp.DTO.RegisterStudentDTO;
import com.fonyou.exam.examapp.entity.Student;
import com.fonyou.exam.examapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentCaseUse {
    private StudentService studentService;
    public Student register(RegisterStudentDTO registerStudentDTO){
        Student newStudent=new Student();
        newStudent.setCity(registerStudentDTO.getCity());
        newStudent.setName(registerStudentDTO.getName());
        newStudent.setAge(registerStudentDTO.getAge());
        newStudent.setTimeZone(registerStudentDTO.getTimezone());
        return this.studentService.save(newStudent);
    }
}
