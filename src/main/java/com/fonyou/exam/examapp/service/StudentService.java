package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.entity.Student;
import com.fonyou.exam.examapp.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public Student save(Student student){
        return this.studentRepository.save(student);
    }

    public Student getById(Long id){
        return this.studentRepository.findById(id).orElse(null);
    }
}
