package com.fonyou.exam.examapp;

import com.fonyou.exam.examapp.DTO.RegisterExamDTO;
import com.fonyou.exam.examapp.entity.Assignment;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.repository.ExamRepository;
import com.fonyou.exam.examapp.service.ExamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestExamService {
    @Mock
    private ExamRepository examRepository;
    @InjectMocks
    private ExamService examService;

    @Test
    public void given_an_exam_with_empty_question_it_fails(){
        RegisterExamDTO registerExamDTO=new RegisterExamDTO();
        registerExamDTO.setDate(new Date());
        registerExamDTO.setQuestions(new ArrayList<>());
        Assertions.assertEquals(this.examService.isRigthExam(registerExamDTO),false);
    }

    @Test
    public void given_an_exam_returned_by_repository_service_return_the_same(){
        Exam exam=new Exam();
        Long id=1l;
        Mockito.when(this.examRepository.findById(id)).thenReturn(Optional.ofNullable(exam));
        Assertions.assertEquals(this.examService.getById(id),exam);
    }

}
