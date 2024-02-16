package com.alpha.school.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String confirmPassword;
    private String name;
    private String fatherName;
    private String motherName;
    private Date dob;
    private String gender;
    private Integer phoneNumber;
    @Lob
    private byte[] photo;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="class_student",
               joinColumns = @JoinColumn(name="student_id"),
               inverseJoinColumns=@JoinColumn(name="class_id"))
    private List<Class> classes;

   // @Autowired
    //private Address address;
}
