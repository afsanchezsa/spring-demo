package com.fonyou.exam.examapp.caseuse;

import com.fonyou.exam.examapp.DTO.FillExamDTO;
import com.fonyou.exam.examapp.DTO.QualificationDTO;
import com.fonyou.exam.examapp.DTO.QuestionResponseDTO;
import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.entity.*;

import com.fonyou.exam.examapp.entity.adapter.QuestionAdapter;
import com.fonyou.exam.examapp.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ExamCaseUse {
    private ExamService examService;
    private OptionService optionService;
    private QuestionService questionService;
    private AssignmentService assignmentService;
    private AnswerService answerService;

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
    @Transactional
    public void fillExam(FillExamDTO fillExamDTO){
        List<QuestionResponseDTO>responses=fillExamDTO.getResponses();
        responses.stream().forEach(questionResponseDTO -> {
            Option option =this.optionService.getById(questionResponseDTO.getOptionId());
            Question question=this.questionService.getById(questionResponseDTO.getQuestionId());
            Assignment assignment=this.assignmentService.getById(fillExamDTO.getAssignmentId());
            Answer newAnswer=new Answer();
            newAnswer.setAssignment(assignment);
            newAnswer.setOption(option);
            newAnswer.setQuestion(question);
            if(option!=null&&option!=null&&assignment!=null&&
                    question.getOptions().contains(option)&&
                    assignment.getExam().getQuestions().contains(question)){
                this.answerService.save(newAnswer);
            }
        });
    }

    public QualificationDTO qualifyExam(Long assigmentId){
        Assignment assignment=this.assignmentService.getById(assigmentId);
        if(assignment==null)
            return null;
        Double totalScore=assignment.getAnswers().stream().mapToDouble(answer -> {
            Question question=answer.getQuestion();
            Option option=answer.getOption();
            if(question==option.getQuestion() && option.getCorrect())
                return question.getScore();
            return 0f;
        }).sum();
        QualificationDTO qualificationDTO=new QualificationDTO();
        qualificationDTO.setTotalScore(totalScore);
        return qualificationDTO;
    }


}
