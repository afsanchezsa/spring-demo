package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignExamDTO {
    private Long examId;
    private Long studentId;

    public AssignExamDTO() {
    }
}
