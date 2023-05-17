package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ClientTbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class FeedbackModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private  String lecname;
    private  String coursename;
    private  String description;

    public FeedbackModal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecname() {
        return lecname;
    }

    public void setLecname(String lecname) {
        this.lecname = lecname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
