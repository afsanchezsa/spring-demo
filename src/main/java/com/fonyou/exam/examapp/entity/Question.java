package com.fonyou.exam.examapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_question")
    private Long id;
    private String statement;
    private Float score;
    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Option> options;
    @OneToMany(mappedBy ="question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Answer>answers;

    public Question() {
    }
}
