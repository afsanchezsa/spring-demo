package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.entity.Answer;
import com.fonyou.exam.examapp.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerService {
    private AnswerRepository answerRepository;

    public Answer save(Answer answer){
        return this.answerRepository.save(answer);
    }

}
