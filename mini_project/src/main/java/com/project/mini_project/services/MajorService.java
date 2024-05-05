package com.project.mini_project.services;

import com.project.mini_project.dtos.CreateMajorDTO;
import com.project.mini_project.dtos.UpdateMajorDTO;
import com.project.mini_project.entities.Major;
import com.project.mini_project.repositories.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService{

    private final MajorRepository majorRepository;

    @Override
    public Major createMajor(CreateMajorDTO createMajorDTO) {
       Major newMajor = Major.builder()
               .name(createMajorDTO.getName())
               .des(createMajorDTO.getDes())
               .build();
       return majorRepository.save(newMajor);
    }

    @Override
    public List<Major> getAllMajors() {
        return majorRepository.findAll();
    }

    @Override
    public Major getMajorById(Long id) {
        return majorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Major not found "));
    }

    @Override
    public void deleteMajor(Long id) {
        Optional<Major> optionalMajor = majorRepository.findById(id);
        if (optionalMajor.isPresent()) {
            majorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Major not found with id: " + id);
        }
    }

    @Override
    public Major updateMajor(Long id,@RequestBody UpdateMajorDTO updateMajorDTO) {
        Major existingMajor = getMajorById(id);
        existingMajor.setName(updateMajorDTO.getName());
        existingMajor.setDes(updateMajorDTO.getDes());
        return majorRepository.save(existingMajor);
    }
}
