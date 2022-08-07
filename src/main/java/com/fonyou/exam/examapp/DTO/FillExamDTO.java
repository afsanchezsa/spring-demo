package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FillExamDTO {
    private Long assignmentId;
    private List<QuestionResponseDTO> responses;

    public FillExamDTO() {
    }
}
