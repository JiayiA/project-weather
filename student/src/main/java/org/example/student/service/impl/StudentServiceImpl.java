package org.example.student.service.impl;

import org.example.student.exception.ControllerExceptionHandler;
import org.example.student.pojo.Student;
import org.example.student.pojo.dto.StudentResponseDTO;
import org.example.student.repository.StudentRepository;
import org.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO getAllStu(){
        Collection<Student> studentCollection = studentRepository.findAll();
        List<StudentResponseDTO.StudentDTO> studentDTOS = studentCollection
                .stream()
                .map(e -> new StudentResponseDTO.StudentDTO(e))
                .collect(Collectors.toList());
        return new StudentResponseDTO(studentDTOS);

    }

    @Override
    public StudentResponseDTO.StudentDTO getStuById(Long id){
        Student student = studentRepository.getOne(id);
        if (student == null){
            //log..
            throw new ControllerExceptionHandler("Can't find student with id" + id);
        }
        return new StudentResponseDTO.StudentDTO(student);
    }

    @Override
    public StudentResponseDTO.StudentDTO createStu(Student student){
        studentRepository.save(student);
        if(student == null){
            throw new ControllerExceptionHandler("Can't create student since it's null");
        }
        return new StudentResponseDTO.StudentDTO(student);
    }

    @Override
    public StudentResponseDTO.StudentDTO deleteStu(Long id){
        Student student = studentRepository.getOne(id);
        studentRepository.deleteById(id);
        if(student == null){
            throw new ControllerExceptionHandler("Can't delete student since it's nulle");
        }
        return new StudentResponseDTO.StudentDTO(student);
    }

}
