package com.losnazar.university.repository;

import com.losnazar.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LectorRepositoryJpa extends JpaRepository<Lector, Long> {
    List<Lector> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String s, String s1);
}
