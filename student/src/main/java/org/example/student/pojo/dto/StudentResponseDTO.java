package org.example.student.pojo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.student.pojo.Student;

import java.util.List;

public class StudentResponseDTO {
    private List<StudentDTO> studentList;

    public StudentResponseDTO(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class StudentDTO{
        private String name;
        private Long id;

        public StudentDTO(Student s) {
            this.name = s.getName();
            this.id = s.getId();
        }

    }


}
