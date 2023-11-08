package com.losnazar.university.service;

import com.losnazar.university.model.Degree;
import com.losnazar.university.model.Department;
import java.math.BigDecimal;
import java.util.Map;

public interface DepartmentService {
    Department findByName(String name);

    Map<Degree,Integer> getStatisticsByDepartmentName(String name);

    BigDecimal countAverageSalaryForDepartment(String name);
}
