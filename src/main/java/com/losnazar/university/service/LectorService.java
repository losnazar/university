package com.losnazar.university.service;

import com.losnazar.university.model.Lector;

import java.util.List;

public interface LectorService {

    List<Lector> findByTemplate(String string);
}
