package com.project.mini_project.services;

import com.project.mini_project.dtos.CreateStudentDTO;
import com.project.mini_project.dtos.UpdateStudentDTO;
import com.project.mini_project.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student createStudent(CreateStudentDTO createStudentDTO);

    Student getStudentById(Long id);

    void deleteStudent(Long id);

    Student updateStudent(Long id, UpdateStudentDTO updateStudentDTO);
}
