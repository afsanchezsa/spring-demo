package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.entity.Question;
import com.fonyou.exam.examapp.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {
    private QuestionRepository questionRepository;
    public Question getById(Long id){
        return this.questionRepository.findById(id).orElse(null);
    }
}
