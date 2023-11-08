package com.losnazar.university.service;

import com.losnazar.university.model.Degree;
import com.losnazar.university.model.Department;
import com.losnazar.university.model.Lector;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {
    Department findByName(String name);

    Map<Degree,Integer> getStatisticsByDepartmentName(String name);

    BigDecimal countAverageSalaryForDepartment(String name);
}
