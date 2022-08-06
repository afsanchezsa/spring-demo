package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionDTO {
    private String statement;
    private Boolean correct;

    public OptionDTO() {
    }
}
