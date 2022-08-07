package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.DTO.OptionDTO;
import com.fonyou.exam.examapp.DTO.QuestionDTO;
import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamService {


    private ExamRepository examRepository;

    public Exam save(Exam exam){
        return this.examRepository.save(exam);
    }

    public Exam getById(Long id){
        return this.examRepository.findById(id).orElse(null);
    }

    public boolean isRigthExam(RegisterExamDTO registerExamDTO){
        boolean correct=registerExamDTO.getDate()!=null && registerExamDTO.getQuestions()!=null;
        if(correct){
            List<QuestionDTO> questionDTOList=registerExamDTO.getQuestions();
            Float maximunGrade=0f;
            for(QuestionDTO question : questionDTOList){
                if(!isRigthQuestion(question))
                    return false;
                maximunGrade+=question.getScore();
            }

        correct=maximunGrade==100.0f;
        }
        return correct;
    }
    private boolean isRigthQuestion(QuestionDTO questionDTO){
        boolean correct=questionDTO.getOptions()!=null
                &&questionDTO.getOptions().size()==4;
        if(correct){
            int countCorrectAnswers=0;
            for(OptionDTO option: questionDTO.getOptions()){
                if(option.getCorrect())
                    countCorrectAnswers++;
            }
            correct=countCorrectAnswers==1;
        }

        if(correct){

        }

        return correct;

    }
}
