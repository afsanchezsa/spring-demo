package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.entity.Assignment;
import com.fonyou.exam.examapp.repository.AssignmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssignmentService {
    private AssignmentRepository assignmentRepository;

    public Assignment save(Assignment assignment){
        return this.assignmentRepository.save(assignment);
    }

    public Assignment getById(Long id){
        return this.assignmentRepository.findById(id).orElse(null);
    }

}
