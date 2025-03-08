package com.dct.Simple_Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @SequenceGenerator(
            name = "stu_seq",
            sequenceName = "stu_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stu_seq"
    )
    private int id;
    private String name;
    private int age;
    private String dept;
}
