package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponseDTO {
    private Long questionId;
    private Long optionId;

    public QuestionResponseDTO() {
    }
}
