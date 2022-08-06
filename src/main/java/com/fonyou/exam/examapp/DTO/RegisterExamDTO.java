package com.fonyou.exam.examapp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RegisterExamDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "UTC")
    private Date date;
    private List<QuestionDTO> questions;

    public RegisterExamDTO() {
    }
}
