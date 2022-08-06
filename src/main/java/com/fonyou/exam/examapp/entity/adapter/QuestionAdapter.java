package com.fonyou.exam.examapp.entity.adapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fonyou.exam.examapp.DTO.QuestionDTO;
import com.fonyou.exam.examapp.entity.Answer;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.entity.Option;
import com.fonyou.exam.examapp.entity.Question;


import java.util.List;
import java.util.stream.Collectors;

public class QuestionAdapter extends Question {
   // private QuestionDTO question;
    public QuestionAdapter(QuestionDTO questionDTO){
        super();
        super.setScore(questionDTO.getScore());
        super.setStatement(questionDTO.getStatement());
        //super.setExam(exam);
        List<Option>options=questionDTO.getOptions().stream().map(optionDTO -> {
            return new OptionAdapter(optionDTO,this);
        }).collect(Collectors.toList());
        super.setOptions(options);


    }


}
