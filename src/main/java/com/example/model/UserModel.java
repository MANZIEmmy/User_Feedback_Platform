package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User_Table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String phone;
    private String password;
}
