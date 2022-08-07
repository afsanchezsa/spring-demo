package com.fonyou.exam.examapp.entity.adapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fonyou.exam.examapp.DTO.OptionDTO;
import com.fonyou.exam.examapp.entity.Answer;
import com.fonyou.exam.examapp.entity.Option;
import com.fonyou.exam.examapp.entity.Question;

import javax.persistence.*;
import java.util.List;

public class OptionAdapter extends Option {
    OptionDTO optionDTO;

    public OptionAdapter(OptionDTO optionDTO,Question question){
        super();
        super.setCorrect(optionDTO.getCorrect());
        super.setStatement(optionDTO.getStatement());
        super.setQuestion(question);

    }





}
