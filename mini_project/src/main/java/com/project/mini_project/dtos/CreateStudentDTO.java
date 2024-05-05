package com.project.mini_project.dtos;


import lombok.*;

@Data // getter setter ... to string
@Setter
@Getter
@AllArgsConstructor // ham tao co tham so
@NoArgsConstructor // ham tao khong co tham so
public class CreateStudentDTO {
    private String name;
    private String email;
    private String address;
    private Long major_id;
//    private Long user_id;
}
