package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDTO {
    private String statement;
    private Float score;
    private List<OptionDTO> options;
    public QuestionDTO() {
    }
}
