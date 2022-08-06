package com.fonyou.exam.examapp.caseuse;

import com.fonyou.exam.examapp.DTO.AssignExamDTO;
import com.fonyou.exam.examapp.entity.Assignment;
import com.fonyou.exam.examapp.entity.Exam;
import com.fonyou.exam.examapp.entity.Student;
import com.fonyou.exam.examapp.service.AssignmentService;
import com.fonyou.exam.examapp.service.ExamService;
import com.fonyou.exam.examapp.service.StudentService;
import com.fonyou.exam.examapp.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssignmentCaseUse {
    private AssignmentService assignmentService;
    private ExamService examService;
    private StudentService studentService;

    public Assignment register(AssignExamDTO assignExamDTO){

        Assignment newAssignment=new Assignment();
        Exam exam= this.examService.getById(assignExamDTO.getExamId());
        Student student= this.studentService.getById(assignExamDTO.getStudentId());
        if(exam==null||student==null)
            return null;

        newAssignment.setExam(exam);
        newAssignment.setStudent(student);
        newAssignment.setDate(DateUtils.getDate(exam.getDate(),student.getTimeZone()));
        return this.assignmentService.save(newAssignment);

    }

}
