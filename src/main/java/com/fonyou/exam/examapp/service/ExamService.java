package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExamService {
    private ExamRepository examRepository;

    public Exam save(Exam exam){
        return this.examRepository.save(exam);
    }



}
