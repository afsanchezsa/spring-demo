package com.fonyou.exam.examapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_answer")
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_question")
    private Question question;
    @ManyToOne
    @JoinColumn(name="id_option")
    private Option option;
    @ManyToOne
    @JoinColumn(name = "id_assignment")
    @JsonIgnore
    private Assignment assignment;

    public Answer() {
    }
}
