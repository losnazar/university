package com.losnazar.university.strategy.command;

import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.model.Degree;
import com.losnazar.university.service.DepartmentService;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@AllArgsConstructor
@Slf4j
public class StatisticCommand implements CommandHandler {
    private final CommandPattern pattern = CommandPattern.STATISTIC;

    private final DepartmentService departmentService;
    @Override
    public void handleCommand(String input) {
        log.info("StatisticCommand invoked.");
        String departmentName = input.split("\\s")[1];
        Map<Degree, Integer> statistics = departmentService.getStatisticsByDepartmentName(departmentName);
        for (Map.Entry<Degree, Integer> entry : statistics.entrySet()) {
            System.out.printf("%s - %s.%n", entry.getKey().name().toLowerCase()
                            .replace("_", " "), entry.getValue());
        }
    }
}
