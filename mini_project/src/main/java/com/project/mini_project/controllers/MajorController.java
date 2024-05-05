package com.project.mini_project.controllers;


import com.project.mini_project.dtos.CreateMajorDTO;
import com.project.mini_project.dtos.UpdateMajorDTO;
import com.project.mini_project.entities.Major;
import com.project.mini_project.services.IMajorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/majors")
@CrossOrigin("http://localhost:3000")
public class MajorController {
    private final IMajorService majorService;

    @PostMapping("")
    public ResponseEntity<?> createMajor(@Valid @RequestBody CreateMajorDTO createMajorDTO){
        try{
            Major major = majorService.createMajor(createMajorDTO);
            return ResponseEntity.ok("Major created successfully !!! ");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMajor(){
        return ResponseEntity.ok(majorService.getAllMajors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMajorById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(majorService.getMajorById(id));
        }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMajor(@PathVariable Long id){
        try{
            majorService.deleteMajor(id);
            return ResponseEntity.ok().body("Deleted major successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMajor(
            @PathVariable Long id,
            @RequestBody UpdateMajorDTO updateMajorDTO
            ){
        try {
            Major major = majorService.updateMajor(id,updateMajorDTO);
            return ResponseEntity.ok(major);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
