package com.project.mini_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter ... to string
@AllArgsConstructor // ham tao co tham so
@Builder
@NoArgsConstructor // ham tao khong co tham so
public class UpdateStudentDTO {
    private String name;
    private String address;
    private Long major_id;
}
