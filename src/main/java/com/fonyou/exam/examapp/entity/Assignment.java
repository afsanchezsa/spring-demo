package com.fonyou.exam.examapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_assignment")
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_exam")
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @OneToMany(mappedBy = "assignment",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Answer> answers;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "UTC")
    private Date date;
    private Float grade;

    public Assignment() {
    }
}
