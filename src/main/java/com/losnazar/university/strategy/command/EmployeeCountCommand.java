package com.losnazar.university.strategy.command;

import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.model.Department;
import com.losnazar.university.service.DepartmentService;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@Slf4j
public class EmployeeCountCommand implements CommandHandler {
    private final CommandPattern pattern = CommandPattern.EMPLOYEE_COUNT;
    private final DepartmentService departmentService;

    @Override
    public void handleCommand(String input) {
        log.info("EmployeeCountCommand invoked.");
        Department department = departmentService.findByName(input.split("\\s")[5]);
        System.out.println(department.getLectors().size());
    }
}
