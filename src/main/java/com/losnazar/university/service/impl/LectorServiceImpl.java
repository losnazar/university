package com.losnazar.university.service.impl;

import com.losnazar.university.exception.DataProcessingException;
import com.losnazar.university.model.Lector;
import com.losnazar.university.repository.LectorRepositoryJpa;
import com.losnazar.university.service.LectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepositoryJpa repository;

    @Override
    public List<Lector> findByTemplate(String string) {
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(string, string);
    }
}
