package com.project.mini_project.services;

import com.project.mini_project.dtos.CreateMajorDTO;
import com.project.mini_project.dtos.UpdateMajorDTO;
import com.project.mini_project.entities.Major;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IMajorService {

    Major createMajor(CreateMajorDTO createMajorDTO);
    List<Major> getAllMajors();
    Major getMajorById(Long id);
    void deleteMajor(Long id);
    Major updateMajor(Long id ,@RequestBody UpdateMajorDTO updateMajorDTO);
}
