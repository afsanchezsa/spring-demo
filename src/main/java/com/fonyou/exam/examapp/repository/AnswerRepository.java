package com.fonyou.exam.examapp.repository;

import com.fonyou.exam.examapp.entity.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
