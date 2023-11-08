package com.losnazar.university.repository;

import com.losnazar.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepositoryJpa extends JpaRepository<Department, Long> {
    @Query("SELECT d from Department d JOIN FETCH d.lectors WHERE d.name = :name")
    Optional<Department> findByNameIgnoreCase(String name);
}
