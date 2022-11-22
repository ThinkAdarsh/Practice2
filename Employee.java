package com.springdemo.Jpa.MODEL;



import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Thinkitive")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="Name")
    private String name;

    @Column(name="Language")
    private String language;

    @Column(name="City")
    private String city;

    @Column(name="Doj")
    private String joiningDate;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Emp_add", referencedColumnName ="id")
    private List<Address> address;

}
