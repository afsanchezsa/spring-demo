package com.fonyou.exam.examapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_exam")
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-05:00")
  // @JsonFormat(timezone = "GMT-05:00")
    private Date date;
    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Question> questions;
    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Assignment>assignments;

    public Exam() {
    }
}
