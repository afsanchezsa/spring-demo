package com.fonyou.exam.examapp.caseuse;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.entity.Exam;

import com.fonyou.exam.examapp.entity.Question;
import com.fonyou.exam.examapp.entity.adapter.QuestionAdapter;
import com.fonyou.exam.examapp.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ExamCaseUse {
    private ExamService examService;

    public Exam register(RegisterExamDTO registerExamDTO){
        Exam newExam=new Exam();
        List<Question> questionList=  registerExamDTO.getQuestions().stream().map(
                questionDTO -> {
                    return new QuestionAdapter(questionDTO);
        }).collect(Collectors.toList());
        newExam.setQuestions(questionList);
        newExam.setDate(registerExamDTO.getDate());
        Exam registeredExam=this.examService.save(newExam);

        registeredExam.getQuestions().forEach(question -> {question.setExam(registeredExam);});
        return this.examService.save(registeredExam);
    }
}
