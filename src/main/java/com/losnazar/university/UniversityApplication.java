package com.losnazar.university;

import com.losnazar.university.exception.InvalidCommandException;
import com.losnazar.university.model.CommandPattern;
import com.losnazar.university.strategy.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class UniversityApplication implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final List<CommandHandler> commandHandlers;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Map<CommandPattern, CommandHandler> commandMap = commandHandlers.stream()
                .collect(Collectors.toMap(CommandHandler::getPattern, e -> e));
        try {
            System.out.println("Welcome to university application!");
            System.out.println("""
                        Possible commands:
                        1. Who is head of department [department_name].
                        2. Show count of employee for [department_name].
                        3. Show the average salary for the department [department_name].
                        4. Show [department_name] statistic.
                        5. Global search by [template].
                        Enter a command or type 'exit' to quit.
                        """);
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the application.");
                    break;
                }
                CommandHandler commandHandler = commandMap.entrySet().stream().filter(entry ->
                                Pattern.compile(entry.getKey().getValue()).matcher(input).find()).findAny()
                        .orElseThrow(() -> new InvalidCommandException("Command doesn't exists: "
                                + input)).getValue();
                commandHandler.handleCommand(input);
            }
        } catch (Exception e) {
            String message = "Exception occurred. Message: " + e.getMessage() + "\n";
            log.error(message);
            System.out.println(message);
            run();
        }
    }
}
