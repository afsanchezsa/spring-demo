package com.fonyou.exam.examapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_option")
    private Long id;
    private String statement;
    private Boolean correct;
    @ManyToOne
    @JoinColumn(name="id_question")
    @JsonIgnore
    private Question question;
    @OneToMany(mappedBy = "option",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Answer> answers;

    public Option() {
    }
}
