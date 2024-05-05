package com.project.mini_project.services;

import com.project.mini_project.dtos.CreateStudentDTO;
import com.project.mini_project.dtos.UpdateStudentDTO;
import com.project.mini_project.entities.Major;
import com.project.mini_project.entities.Student;
//import com.project.mini_project.entities.User;
import com.project.mini_project.repositories.MajorRepository;
import com.project.mini_project.repositories.StudentRepository;
//import com.project.mini_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
//    private final UserRepository userRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(CreateStudentDTO createStudentDTO) {
//        if(createStudentDTO.getUser_id()==null){
//            throw  new IllegalArgumentException("userid không được phép null");
//        }
        Major major = majorRepository.findById(createStudentDTO.getMajor_id()).orElseThrow(
                () -> new RuntimeException("Major khong ton tai")
        );

//        User user = userRepository.findById(createStudentDTO.getUser_id())
//                .orElseThrow(() -> new RuntimeException("User không tồn tại"));

        Student student = Student.builder()
                .name(createStudentDTO.getName())
                .email(createStudentDTO.getEmail())
                .address(createStudentDTO.getAddress())
                .major(major)
                .build();

        return studentRepository.save(student);

    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Sinh vien khong ton tai")
        );
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    @Override
    public Student updateStudent(Long id, UpdateStudentDTO updateStudentDTO) {
        Major major = majorRepository.findById(updateStudentDTO.getMajor_id()).orElseThrow(
                () -> new RuntimeException("Major khong ton tai")
        );
        Student student = getStudentById(id);

        student.setName(updateStudentDTO.getName());
        student.setAddress(updateStudentDTO.getAddress());
        student.setMajor(major);
        return studentRepository.save(student);

    }
}
