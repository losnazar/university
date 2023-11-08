package com.losnazar.university.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lectors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Degree degree;

    private BigDecimal salary;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.LAZY)
    private Set<Department> departments = new HashSet<>();
}
