package org.example.student.service;

import org.example.student.StudentApplication;
import org.example.student.pojo.Student;
import org.example.student.pojo.dto.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO getAllStu();
    StudentResponseDTO.StudentDTO getStuById(Long id);
    StudentResponseDTO.StudentDTO createStu(Student student);
    StudentResponseDTO.StudentDTO deleteStu(Long id);
}
