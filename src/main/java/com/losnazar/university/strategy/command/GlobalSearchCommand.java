package com.losnazar.university.strategy.command;

import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.model.Lector;
import com.losnazar.university.service.LectorService;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@AllArgsConstructor
@Slf4j
public class GlobalSearchCommand implements CommandHandler {
    private final CommandPattern pattern = CommandPattern.GLOBAL_SEARCH;
    private final LectorService lectorService;

    @Override
    public void handleCommand(String input) {
        log.info("GlobalSearchCommand invoked.");
        List<Lector> lectors = lectorService.findByTemplate(input.split("\\s")[3]);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lectors.size(); i++) {
            Lector lector = lectors.get(i);
            builder.append(lector.getFirstName())
                    .append(" ")
                    .append(lector.getLastName());
            if (i != lectors.size() - 1) {
                builder.append(", ");
            }
        }
        String string = builder.toString();
        if (builder.isEmpty()) {
            System.out.println("Nothing found.");
        }
        System.out.println(string);
    }
}
