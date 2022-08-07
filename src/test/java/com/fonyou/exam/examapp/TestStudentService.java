package com.fonyou.exam.examapp;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.DTO.RegisterStudentDTO;
import com.fonyou.exam.examapp.repository.StudentRepository;
import com.fonyou.exam.examapp.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class TestStudentService {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void given_an_student_without_name_it_fails(){
        RegisterStudentDTO registerStudentDTO=new RegisterStudentDTO();
        registerStudentDTO.setAge(10);
        registerStudentDTO.setCity("Bogota");
        registerStudentDTO.setTimezone("timeZone");

        Assertions.assertEquals(this.studentService.isRigthStudent(registerStudentDTO),false);
        registerStudentDTO.setName("Andres");
        Assertions.assertEquals(this.studentService.isRigthStudent(registerStudentDTO),true);
    }
}
