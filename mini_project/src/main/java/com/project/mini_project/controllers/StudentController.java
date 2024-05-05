package com.project.mini_project.controllers;

import com.project.mini_project.dtos.CreateStudentDTO;
import com.project.mini_project.dtos.UpdateStudentDTO;
import com.project.mini_project.entities.Student;
import com.project.mini_project.services.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@Valid  @RequestBody CreateStudentDTO createStudentDTO) {
        try {
            Student student = studentService.createStudent(createStudentDTO);
            return ResponseEntity.ok(student);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
       try {
           return ResponseEntity.ok(studentService.getStudentById(id));
       }catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body("Delete success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Long id,
            @RequestBody UpdateStudentDTO updateStudentDTO
            ) {
        try {
           Student student = studentService.updateStudent(id, updateStudentDTO);
            return ResponseEntity.ok(student);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
