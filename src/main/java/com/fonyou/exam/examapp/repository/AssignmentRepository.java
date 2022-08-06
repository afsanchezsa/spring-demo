package com.fonyou.exam.examapp.repository;

import com.fonyou.exam.examapp.entity.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
}
