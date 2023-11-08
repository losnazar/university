package com.losnazar.university.strategy.command;

import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.model.Lector;
import com.losnazar.university.service.DepartmentService;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@Slf4j
public class HeadOfDepartmentCommand implements CommandHandler {
    private final CommandPattern pattern = CommandPattern.DEPARTMENT_HEAD;

    private final DepartmentService departmentService;

    @Override
    public void handleCommand(String input) {
        log.info("HeadOfDepartmentCommand invoked.");
        String[] words = input.split("\\s");
        String departmentName;
        if (words.length == 6) {
            departmentName = words[5];
        } else {
            departmentName = String.join(" ", words[5], words[6]);
        }
        Lector headLector = departmentService.findByName(departmentName).getHeadLector();
        System.out.printf("Head of %s department is %s %s.%n", departmentName,
                headLector.getFirstName(), headLector.getLastName());
    }
}
