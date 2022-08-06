package com.fonyou.exam.examapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStudentDTO {
    private String  name;
    private Integer age;
    private String city;
    private String timezone;

    public RegisterStudentDTO() {
    }
}
