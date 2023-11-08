package com.losnazar.university.strategy.command;

import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.service.DepartmentService;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Getter
@AllArgsConstructor
@Slf4j
public class SalaryCommand implements CommandHandler {
    private final CommandPattern pattern = CommandPattern.SALARY;
    private final DepartmentService departmentService;
    @Override
    public void handleCommand(String input) {
        log.info("SalaryCommand invoked.");
        String departmentName = input.split("\\s")[7];
        BigDecimal averageSalary = departmentService.countAverageSalaryForDepartment(departmentName);
        System.out.printf("The average salary of %s department is %s.%n",
                departmentName, averageSalary);
    }
}
