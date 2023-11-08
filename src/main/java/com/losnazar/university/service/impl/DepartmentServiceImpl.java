package com.losnazar.university.service.impl;

import com.losnazar.university.exception.DataProcessingException;
import com.losnazar.university.model.Degree;
import com.losnazar.university.model.Department;
import com.losnazar.university.model.Lector;
import com.losnazar.university.repository.DepartmentRepositoryJpa;
import com.losnazar.university.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepositoryJpa repositoryJpa;

    @Override
    public Department findByName(String name) {
        log.info("findByName method invoked.");
        String message = String.format("Department by name: %s doesn't exists.", name);
        return repositoryJpa.findByNameIgnoreCase(name)
                .orElseThrow(() -> new DataProcessingException(message));
    }

    @Override
    public Map<Degree, Integer> getStatisticsByDepartmentName(String name) {
        return findByName(name).getLectors().stream()
                .collect(Collectors.groupingBy(Lector::getDegree,
                        Collectors.summingInt(e -> 1)));
    }

    @Override
    public BigDecimal countAverageSalaryForDepartment(String name) {
        BigDecimal sum = findByName(name).getLectors().stream().map(Lector::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(BigDecimal.valueOf(findByName(name).getLectors().size()),
                RoundingMode.HALF_UP);
    }
}
